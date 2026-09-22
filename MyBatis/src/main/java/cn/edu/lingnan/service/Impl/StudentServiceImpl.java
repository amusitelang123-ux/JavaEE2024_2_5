package cn.edu.lingnan.service.Impl;

import cn.edu.lingnan.mapper.CourseMapper;
import cn.edu.lingnan.mapper.ScoreMapper;
import cn.edu.lingnan.mapper.StudentMapper;
import cn.edu.lingnan.mapper.TimeTableMapper;
import cn.edu.lingnan.pojo.Student;
import cn.edu.lingnan.service.StudentService;
import cn.edu.lingnan.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> queryStudentAll() {
        List<Student> list = null;
//        try {
//            String resource = "mybatis-config.xml";
//            InputStream inputStream = Resources.getResourceAsStream(resource);
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//            SqlSession session = sqlSessionFactory.openSession();
//            StudentMapper mapper = session.getMapper(StudentMapper.class);
//            list = mapper.queryStudentAll();
//        }catch (IOException e){
//            throw new RuntimeException(e);
//        }
        try(SqlSession session = MyBatisUtil.getSqlSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            list = mapper.queryStudentAll();
        }
        return list;
    }

    @Override
    public Student queryStudentBySid(String _sid) {
        Student student = null;
        try(SqlSession session = MyBatisUtil.getSqlSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            student = mapper.queryStudentBySid(_sid);
        }
        return student;
    }

    @Override
    public Student queryStudentBySnameAndSpassword(String _sname, String _spassword) {
        Student student = null;
        try(SqlSession session = MyBatisUtil.getSqlSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            student = mapper.queryStudentBySnameAndSpassword(_sname, _spassword);
        }
        return student;
    }

    @Override
    public int insertStudent(Student _student) {
        int flag = 0;
        try(SqlSession session = MyBatisUtil.getSqlSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            flag = mapper.insertStudent(_student);
            session.commit();
        }
        return flag;
    }

    @Override
    public int updateStudent(Student _student) {
        int flag = 0;
        try(SqlSession session = MyBatisUtil.getSqlSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            flag = mapper.updateStudent(_student);
            session.commit();
        }
        return flag;
    }

    @Override
    public int updateStudentPassword(Map<String, Object> _map) {
        int flag = 0;
        try(SqlSession session = MyBatisUtil.getSqlSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            flag = mapper.updateStudentPassword(_map);
            session.commit();
        }
        return flag;
    }

    @Override
    public int deleteStudentBySid(String _sid) {
        int flag = 0;
        try(SqlSession session = MyBatisUtil.getSqlSession()) {
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            CourseMapper  courseMapper = session.getMapper(CourseMapper.class);
            ScoreMapper  scoreMapper = session.getMapper(ScoreMapper.class);
            TimeTableMapper timeTableMapper = session.getMapper(TimeTableMapper.class);

            List<String> delCids = new ArrayList<>();
            List<String> tempCids = scoreMapper.queryScoreCidBySid(_sid);
            for (String cid : tempCids) {
                if (scoreMapper.queryScoreNumByCid(cid) == 1) {
                    delCids.add(cid);
                }
            }
            scoreMapper.deleteScoreBySid(_sid);
            studentMapper.deleteStudentBySid(_sid);
            for (String cid : delCids) {
                timeTableMapper.deleteTimeTableByCid(cid);
                flag = courseMapper.deleteCourseByCid(cid);
            }
            session.commit();
        }
        return flag;
    }

    @Override
    public List<Student> queryStudentUseIf(Map<String, Object> _map) {
        List<Student> list = null;
        try(SqlSession session = MyBatisUtil.getSqlSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            list = mapper.queryStudentUseIf(_map);
        }
        return list;
    }

    @Override
    public int updateStudentUseSet(Map<String, Object> _map) {
        int flag = 0;
        try(SqlSession session = MyBatisUtil.getSqlSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            flag = mapper.updateStudentUseSet(_map);
            session.commit();
        }
        return flag;
    }
}
