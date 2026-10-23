package cn.edu.lingnan.service.Impl;

import cn.edu.lingnan.mapper.*;
import cn.edu.lingnan.pojo.*;
import cn.edu.lingnan.service.CourseService;
import cn.edu.lingnan.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseServiceImpl implements CourseService {
    @Override
    public List<Course> queryCourseAll() {
        List<Course> list = new ArrayList<>();
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            CourseMapper mapper = session.getMapper(CourseMapper.class);
            list = mapper.queryCourseAll();
        }
        return list;
    }

    @Override
    public Course queryCourseByCid(String _cid) {
        Course course = null;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            CourseMapper mapper = session.getMapper(CourseMapper.class);
            course = mapper.queryCourseByCid(_cid);
        }
        return course;
    }

    @Override
    public int insertCourse(Course _course) {
        int flag = 0;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            CourseMapper mapper = session.getMapper(CourseMapper.class);
            flag = mapper.insertCourse(_course);
            session.commit();
        }
        return flag;
    }

    @Override
    public int updateCourse(Course _course) {
        int flag = 0;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            CourseMapper mapper = session.getMapper(CourseMapper.class);
            flag = mapper.updateCourse(_course);
            session.commit();
        }
        return flag;
    }

    @Override
    public List<Course> queryCourseByCname(String _cname) {
        List<Course> list = new ArrayList<>();
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            CourseMapper mapper = session.getMapper(CourseMapper.class);
            list = mapper.queryCourseByCname(_cname);
        }
        return list;
    }

    @Override
    public List<Course> queryCourseUseIf(Map<String, Object> _map) {
        List<Course> list = new ArrayList<>();
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            CourseMapper mapper = session.getMapper(CourseMapper.class);
            list = mapper.queryCourseUseIf(_map);
        }
        return list;
    }

    @Override
    public int updateCourseUseSet(Map<String, Object> _map) {
        int flag = 0;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            CourseMapper mapper = session.getMapper(CourseMapper.class);
            flag = mapper.updateCourseUseSet(_map);
            session.commit();
        }
        return flag;
    }

    @Override
    public int deleteCourseByCid(String _cid) {
        int flag = 0;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            CourseMapper courseMapper = session.getMapper(CourseMapper.class);
            ScoreMapper scoreMapper = session.getMapper(ScoreMapper.class);
            TimeTableMapper timeTableMapper = session.getMapper(TimeTableMapper.class);
            CourseHistoryMapper courseHistoryMapper = session.getMapper(CourseHistoryMapper.class);
            ScoreHistoryMapper scoreHistoryMapper = session.getMapper(ScoreHistoryMapper.class);
            TimeTableHistoryMapper timeTableHistoryMapper = session.getMapper(TimeTableHistoryMapper.class);

            Course delCourse = courseMapper.queryCourseByCid(_cid);
            List<Score> delScores = scoreMapper.queryScoreByCid(_cid);
            List<TimeTable> delTimeTables = timeTableMapper.queryTimeTableByCid(_cid);

            scoreMapper.deleteScoreByCid(_cid);
            timeTableMapper.deleteTimeTableByCid(_cid);
            flag = courseMapper.deleteCourseByCid(_cid);

            courseHistoryMapper.insertCourse(delCourse);
            for (Score score : delScores) {
                scoreHistoryMapper.insertScore(score);
            }
            for (TimeTable timeTable : delTimeTables) {
                timeTableHistoryMapper.insertTimeTable(timeTable);
            }
            session.commit();
        }
        return flag;
    }

    @Override
    public List<String> queryTnameByCid(String _cid) {
        List<String> stringList = new ArrayList<>();
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
            TimeTableMapper timeTableMapper = session.getMapper(TimeTableMapper.class);
            for (Integer i : timeTableMapper.queryTimeTableTidByCid(_cid)) {
                stringList.add(teacherMapper.queryTeacherTnameByTid(i));
            }

        }
        return stringList;
    }

    @Override
    public Map<String, Object> queryInfoByCid01(String _cid) {
        Map<String, Object> map = null;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            CourseMapper courseMapper = session.getMapper(CourseMapper.class);
            map = courseMapper.queryInfoByCid01(_cid);
        }
        return map;
    }

    @Override
    public List<CourseTeacherTimeTable> queryInfoByCid02(String _cid) {
        List<CourseTeacherTimeTable> list = null;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            CourseMapper courseMapper = session.getMapper(CourseMapper.class);
            list = courseMapper.queryInfoByCid02(_cid);
        }
        return list;
    }

    @Override
    public List<CourseExtend> queryInfoByCid03(String _cid) {
        List<CourseExtend> list = null;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            CourseMapper courseMapper = session.getMapper(CourseMapper.class);
            list = courseMapper.queryInfoByCid03(_cid);
        }
        return list;
    }
}
