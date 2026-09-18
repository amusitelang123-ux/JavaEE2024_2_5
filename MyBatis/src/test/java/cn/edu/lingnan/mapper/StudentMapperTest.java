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
import java.util.HashMap;
import java.util.Map;

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
        //请根据数据库实际情况传入正确参数
        System.out.println(studentService.queryStudentBySid("s01").toString());
    }

    @Test
    public void queryStudentBySnameAndSpasswordTest(){
        //请根据数据库实际情况传入正确参数
        System.out.println(studentService.queryStudentBySnameAndSpassword("admin", "admin").toString());
    }

    @Test
    public void insertStudentTest(){
        //请根据数据库实际情况传入正确参数
        Student student=new Student("s06","柯比","1234",0,1);
        System.out.println(studentService.insertStudent(student));
    }

    @Test
    public void updateStudentTest(){
        //请根据数据库实际情况传入正确参数
        Student student = new Student("s06","柯比","123456",0,1);
        System.out.println(studentService.updateStudent(student));
    }

    @Test
    public void updateStudentPasswordTest(){
        //请根据数据库实际情况传入正确参数
        Map<String,Object> map=new HashMap<>();
        map.put("sid","s06");
        map.put("spassword","kebi123456");
        System.out.println(studentService.updateStudentPassword(map));
    }

    @Test
    public void deleteStudentTest(){
        //请根据数据库实际情况传入正确参数
        System.out.println(studentService.deleteStudentBySid("s06"));
    }


}
