package cn.edu.lingnan.service.Impl;

import cn.edu.lingnan.mapper.*;
import cn.edu.lingnan.pojo.Course;
import cn.edu.lingnan.pojo.Score;
import cn.edu.lingnan.pojo.Student;
import cn.edu.lingnan.pojo.TimeTable;
import cn.edu.lingnan.service.StudentService;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<Student> queryStudentAll() {
        return sqlSessionTemplate.getMapper(StudentMapper.class).queryStudentAll();
    }

    @Override
    public Student queryStudentBySid(String _sid) {
        return sqlSessionTemplate.getMapper(StudentMapper.class).queryStudentBySid(_sid);
    }

    @Override
    public Student queryStudentBySnameAndSpassword(String _sname, String _spassword) {
        return sqlSessionTemplate.getMapper(StudentMapper.class).queryStudentBySnameAndSpassword(_sname, _spassword);
    }

    @Override
    public int insertStudent(Student _student) {
        return sqlSessionTemplate.getMapper(StudentMapper.class).insertStudent(_student);
    }

    @Override
    public int updateStudent(Student _student) {
        return sqlSessionTemplate.getMapper(StudentMapper.class).updateStudent(_student);
    }

    @Override
    public int updateStudentPassword(Map<String, Object> _map) {
        return sqlSessionTemplate.getMapper(StudentMapper.class).updateStudentPassword(_map);
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public int deleteStudentBySid(String _sid) {
        StudentMapper studentMapper = sqlSessionTemplate.getMapper(StudentMapper.class);
        CourseMapper courseMapper = sqlSessionTemplate.getMapper(CourseMapper.class);
        ScoreMapper scoreMapper = sqlSessionTemplate.getMapper(ScoreMapper.class);
        TimeTableMapper timeTableMapper = sqlSessionTemplate.getMapper(TimeTableMapper.class);

        List<String> cids = scoreMapper.queryScoreCidBySid(_sid);
        List<Course> delcourses = new ArrayList<>();
        List<TimeTable> deltimetable = new ArrayList<>();
        Student student = studentMapper.queryStudentBySid(_sid);
        List<Score> scores = scoreMapper.queryScoreBySid(_sid);
        scoreMapper.deleteScoreBySid(_sid);
        for (String cid : cids) {
            if (scoreMapper.queryScoreNumByCid(cid) == 0) {
                delcourses.add(courseMapper.queryCourseByCid(cid));
                deltimetable.addAll(timeTableMapper.queryTimeTableByCid(cid));
                timeTableMapper.deleteTimeTableByCid(cid);
                courseMapper.deleteCourseByCid(cid);
            }
        }
        sqlSessionTemplate.getMapper(StudentHistoryMapper.class).insertStudent(student);
        for (Score score : scores) {
            sqlSessionTemplate.getMapper(ScoreHistoryMapper.class).insertScore(score);
        }
        for (Course course : delcourses) {
            sqlSessionTemplate.getMapper(CourseHistoryMapper.class).insertCourse(course);
        }
        for (TimeTable timeTable : deltimetable) {
            sqlSessionTemplate.getMapper(TimeTableHistoryMapper.class).insertTimeTable(timeTable);
        }
        return studentMapper.deleteStudentBySid(_sid);
    }

    @Override
    public List<Student> queryStudentUseIf(Map<String, Object> _map) {
        return sqlSessionTemplate.getMapper(StudentMapper.class).queryStudentUseIf(_map);
    }

    @Override
    public int updateStudentUseSet(Map<String, Object> _map) {
        return sqlSessionTemplate.getMapper(StudentMapper.class).updateStudentUseSet(_map);
    }
//    @Override
//    public List<Student> queryStudentAll() {
//        List<Student> list = null;
////        try {
////            String resource = "mybatis-config.xml";
////            InputStream inputStream = Resources.getResourceAsStream(resource);
////            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
////            SqlSession session = sqlSessionFactory.openSession();
////            StudentMapper mapper = session.getMapper(StudentMapper.class);
////            list = mapper.queryStudentAll();
////        }catch (IOException e){
////            throw new RuntimeException(e);
////        }
//        try(SqlSession session = MyBatisUtil.getSqlSession()) {
//            StudentMapper mapper = session.getMapper(StudentMapper.class);
//            list = mapper.queryStudentAll();
//        }
//        return list;
//    }
//
//    @Override
//    public Student queryStudentBySid(String _sid) {
//        Student student = null;
//        try(SqlSession session = MyBatisUtil.getSqlSession()) {
//            StudentMapper mapper = session.getMapper(StudentMapper.class);
//            student = mapper.queryStudentBySid(_sid);
//        }
//        return student;
//    }
//
//    @Override
//    public Student queryStudentBySnameAndSpassword(String _sname, String _spassword) {
//        Student student = null;
//        try(SqlSession session = MyBatisUtil.getSqlSession()) {
//            StudentMapper mapper = session.getMapper(StudentMapper.class);
//            student = mapper.queryStudentBySnameAndSpassword(_sname, _spassword);
//        }
//        return student;
//    }
//
//    @Override
//    public int insertStudent(Student _student) {
//        int flag = 0;
//        try(SqlSession session = MyBatisUtil.getSqlSession()) {
//            StudentMapper mapper = session.getMapper(StudentMapper.class);
//            flag = mapper.insertStudent(_student);
//            session.commit();
//        }
//        return flag;
//    }
//
//    @Override
//    public int updateStudent(Student _student) {
//        int flag = 0;
//        try(SqlSession session = MyBatisUtil.getSqlSession()) {
//            StudentMapper mapper = session.getMapper(StudentMapper.class);
//            flag = mapper.updateStudent(_student);
//            session.commit();
//        }
//        return flag;
//    }
//
//    @Override
//    public int updateStudentPassword(Map<String, Object> _map) {
//        int flag = 0;
//        try(SqlSession session = MyBatisUtil.getSqlSession()) {
//            StudentMapper mapper = session.getMapper(StudentMapper.class);
//            flag = mapper.updateStudentPassword(_map);
//            session.commit();
//        }
//        return flag;
//    }
//
//    @Override
//    public int deleteStudentBySid(String _sid) {
//        int flag = 0;
//        try(SqlSession session = MyBatisUtil.getSqlSession()) {
//            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
//            CourseMapper  courseMapper = session.getMapper(CourseMapper.class);
//            ScoreMapper  scoreMapper = session.getMapper(ScoreMapper.class);
//            TimeTableMapper timeTableMapper = session.getMapper(TimeTableMapper.class);
//            StudentHistoryMapper  studentHistoryMapper = session.getMapper(StudentHistoryMapper.class);
//            CourseHistoryMapper  courseHistoryMapper = session.getMapper(CourseHistoryMapper.class);
//            ScoreHistoryMapper  scoreHistoryMapper = session.getMapper(ScoreHistoryMapper.class);
//            TimeTableHistoryMapper  timeTableHistoryMapper = session.getMapper(TimeTableHistoryMapper.class);
//
//            List<String> delCids = new ArrayList<>();
//            List<String> tempCids = scoreMapper.queryScoreCidBySid(_sid);
//            Student delStudent = studentMapper.queryStudentBySid(_sid);
//            List<Course> delCourses = new ArrayList<>();
//            List<Score> delScores = scoreMapper.queryScoreBySid(_sid);
//            List<TimeTable> delTimeTables = new ArrayList<>();
//            for (String cid : tempCids) {
//                if (scoreMapper.queryScoreNumByCid(cid) == 1) {
//                    delCids.add(cid);
//                    delCourses.add(courseMapper.queryCourseByCid(cid));
//                    delTimeTables.addAll(timeTableMapper.queryTimeTableByCid(cid));
//                }
//            }
//            scoreMapper.deleteScoreBySid(_sid);
//            studentMapper.deleteStudentBySid(_sid);
//            for (String cid : delCids) {
//                timeTableMapper.deleteTimeTableByCid(cid);
//                flag = courseMapper.deleteCourseByCid(cid);
//            }
//
//            studentHistoryMapper.insertStudent(delStudent);
//            for (Course course : delCourses) {
//                courseHistoryMapper.insertCourse(course);
//            }
//            for (Score score : delScores) {
//                scoreHistoryMapper.insertScore(score);
//            }
//            for (TimeTable timeTable : delTimeTables) {
//                timeTableHistoryMapper.insertTimeTable(timeTable);
//            }
//
//            session.commit();
//        }
//        return flag;
//    }
//
//    @Override
//    public List<Student> queryStudentUseIf(Map<String, Object> _map) {
//        List<Student> list = null;
//        try(SqlSession session = MyBatisUtil.getSqlSession()) {
//            StudentMapper mapper = session.getMapper(StudentMapper.class);
//            list = mapper.queryStudentUseIf(_map);
//        }
//        return list;
//    }
//
//    @Override
//    public int updateStudentUseSet(Map<String, Object> _map) {
//        int flag = 0;
//        try(SqlSession session = MyBatisUtil.getSqlSession()) {
//            StudentMapper mapper = session.getMapper(StudentMapper.class);
//            flag = mapper.updateStudentUseSet(_map);
//            session.commit();
//        }
//        return flag;
//    }
}
