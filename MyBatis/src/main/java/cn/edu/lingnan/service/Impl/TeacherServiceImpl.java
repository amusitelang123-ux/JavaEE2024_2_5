package cn.edu.lingnan.service.Impl;

import cn.edu.lingnan.mapper.*;
import cn.edu.lingnan.pojo.Course;
import cn.edu.lingnan.pojo.Score;
import cn.edu.lingnan.pojo.Teacher;
import cn.edu.lingnan.pojo.TimeTable;
import cn.edu.lingnan.service.TeacherService;
import cn.edu.lingnan.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TeacherServiceImpl implements TeacherService {
    @Override
    public List<Teacher> queryTeacherAll() {
        List<Teacher> list = null;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            TeacherMapper mapper = session.getMapper(TeacherMapper.class);
            list = mapper.queryTeacherAll();
        }
        return list;
    }

    @Override
    public List<Teacher> queryTeacherByName(String _tname) {
        List<Teacher> list = null;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            TeacherMapper mapper = session.getMapper(TeacherMapper.class);
            list = mapper.queryTeacherByName(_tname);
        }
        return list;
    }

    @Override
    public Teacher queryTeacherByTid(int _tid) {
        Teacher teacher = null;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            TeacherMapper mapper = session.getMapper(TeacherMapper.class);
            teacher = mapper.queryTeacherByTid(_tid);
        }
        return teacher;
    }

    @Override
    public int deleteTeacherByTid(int _tid) {
        int flag = 0;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
            TimeTableMapper timeTableMapper = session.getMapper(TimeTableMapper.class);
            CourseMapper  courseMapper = session.getMapper(CourseMapper.class);
            ScoreMapper scoreMapper = session.getMapper(ScoreMapper.class);

            TeacherHistoryMapper  teacherHistoryMapper = session.getMapper(TeacherHistoryMapper.class);
            TimeTableHistoryMapper timeTableHistoryMapper = session.getMapper(TimeTableHistoryMapper.class);
            CourseHistoryMapper courseHistoryMapper = session.getMapper(CourseHistoryMapper.class);
            ScoreHistoryMapper scoreHistoryMapper = session.getMapper(ScoreHistoryMapper.class);

            List<String> delCids = new ArrayList<>();
            List<String> tempCids = timeTableMapper.queryTimeTableCidByTid(_tid);
            Teacher delTeacher = teacherMapper.queryTeacherByTid(_tid);
            List<TimeTable> delTimeTables = timeTableMapper.queryTimeTableByTid(_tid);
            List<Course> delCourses = new ArrayList<>();
            List<Score> delScores = new ArrayList<>();
            for (String cid : tempCids){
                if (timeTableMapper.queryTimeTableNumByCid(cid) == 1){
                    delCids.add(cid);
                    delCourses.add(courseMapper.queryCourseByCid(cid));
                    delScores.addAll(scoreMapper.queryScoreByCid(cid));
                }
            }
            timeTableMapper.deleteTimeTableByTid(_tid);
            teacherMapper.deleteTeacherByTid(_tid);
            for (String cid : delCids){
                scoreMapper.deleteScoreByCid(cid);
                flag = courseMapper.deleteCourseByCid(cid);
            }

            teacherHistoryMapper.insertTeacher(delTeacher);
            for (TimeTable timeTable : delTimeTables) {
                timeTableHistoryMapper.insertTimeTable(timeTable);
            }
            for (Course course : delCourses) {
                courseHistoryMapper.insertCourse(course);
            }
            for (Score score : delScores) {
                scoreHistoryMapper.insertScore(score);
            }

            session.commit();
        }
        return flag;
    }

    @Override
    public int insertTeacher(Teacher teacher) {
        int flag = 0;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
            flag = teacherMapper.insertTeacher(teacher);
            session.commit();
        }
        return flag;
    }

    @Override
    public int updateTeacherByTid(Map<String, Object> _map) {
        int flag = 0;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
            flag = teacherMapper.updateTeacherByTid(_map);
            session.commit();
        }
        return flag;
    }

    @Override
    public List<Teacher> queryTeacher(Map<String, Object> _map) {
        List<Teacher> list = null;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
            list = teacherMapper.queryTeacher(_map);
        }
        return list;
    }
}
