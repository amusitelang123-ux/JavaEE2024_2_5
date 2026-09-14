package cn.edu.lingnan.mapper;

import cn.edu.lingnan.pojo.Student;
import cn.edu.lingnan.service.Impl.StudentServiceImpl;
import cn.edu.lingnan.service.StudentService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class StudentMapperTest {
    StudentService studentService = new StudentServiceImpl();
    @Test
    public void queryStudentAllTest(){
//        try {
//            String resource = "mybatis-config.xml";
//            InputStream inputStream = Resources.getResourceAsStream(resource);
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//            SqlSession session = sqlSessionFactory.openSession();
//            StudentMapper mapper = session.getMapper(StudentMapper.class);
//            for (Student student : mapper.queryStudentAll()) {
//                System.out.println(student.toString());
//            }
//
//        }catch (IOException e){
//            throw new RuntimeException(e);
//        }
        for (Student student : studentService.queryStudentAll()) {
            System.out.println(student.toString());
        }
    }

    @Test
    public void queryStudentBySidTest(){
        System.out.println(studentService.queryStudentBySid("s01").toString());
    }

    @Test
    public void queryStudentBySnameAndSpasswordTest(){
        System.out.println(studentService.queryStudentBySnameAndSpassword("admin", "admin").toString());
    }


}
