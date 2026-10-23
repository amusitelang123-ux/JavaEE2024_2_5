import cn.edu.lingnan.mapper.StudentMapper;
import cn.edu.lingnan.pojo.Student;
import cn.edu.lingnan.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class StudentTest {
    @Test
    public void queryStudentAllTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = context.getBean(StudentService.class);
        for (Student student : studentService.queryStudentAll()) {
            System.out.println(student.toString());
        }
    }

    @Test
    public void queryStudentBySidTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(context.getBean(StudentService.class).queryStudentBySid("s01").toString());
    }

    @Test
    public void querySudentBySnameAndSpasswordTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(context.getBean(StudentService.class).queryStudentBySnameAndSpassword("kobe", "kobe").toString());
    }

    @Test
    public void insertStudentTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = new Student("s99", "cxk", "1234", 1, 1);
        System.out.println(context.getBean(StudentService.class).insertStudent(student));
    }

    @Test
    public void deleteStudentBySidTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(context.getBean(StudentService.class).deleteStudentBySid("s99"));
    }

    @Test
    public void updateStudentTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = new Student("s04", "man", "man1", 1, 1);
        System.out.println(context.getBean(StudentService.class).updateStudent(student));
    }

    @Test
    public void updateStudentPasswordTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Map<String,Object> map = new HashMap<>();
        map.put("sid","s04");
        map.put("spassword","man2");
        System.out.println(context.getBean(StudentService.class).updateStudentPassword(map));
    }

    @Test
    public void queryStudentUseIfTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Map<String,Object> map = new HashMap<>();
        map.put("sid","s04");
        map.put("sname","man");
        for (Student student : context.getBean(StudentService.class).queryStudentUseIf(map)) {
            System.out.println(student.toString());
        }
    }

    @Test
    public void updateStudentUseSetTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Map<String,Object> map = new HashMap<>();
        map.put("sid","s04");
        map.put("sname","man6");
        System.out.println(context.getBean(StudentService.class).updateStudentUseSet(map));
    }
}
