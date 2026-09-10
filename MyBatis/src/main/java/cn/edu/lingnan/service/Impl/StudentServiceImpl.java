package cn.edu.lingnan.service.Impl;

import cn.edu.lingnan.mapper.StudentMapper;
import cn.edu.lingnan.pojo.Student;
import cn.edu.lingnan.service.StudentService;
import cn.edu.lingnan.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
}
