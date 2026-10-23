import cn.edu.lingnan.pojo.Teacher;
import cn.edu.lingnan.service.TeacherService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class TeacherTest {
    @Test
    public void queryTeacherAllTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        for (Teacher teacher : context.getBean(TeacherService.class).queryTeacherAll()) {
            System.out.println(teacher.toString());
        }
    }

    @Test
    public void insertTeacherTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Teacher teacher = new Teacher(0, "manba", "123", 1, 1);
        System.out.println(context.getBean(TeacherService.class).insertTeacher(teacher));
    }

    @Test
    public void deleteTeacherByTidTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(context.getBean(TeacherService.class).deleteTeacherByTid(7));
    }

    @Test
    public void queryTeacherByNameTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        for (Teacher teacher : context.getBean(TeacherService.class).queryTeacherByName("teacher")) {
            System.out.println(teacher.toString());
        }
    }

    @Test
    public void queryTeacherByTidTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(context.getBean(TeacherService.class).queryTeacherByTid(1).toString());
    }

    @Test
    public void updateTeacherByTidTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Map<String,Object> map = new HashMap<>();
        map.put("tid",6);
        map.put("tname","kebi5");
        System.out.println(context.getBean(TeacherService.class).updateTeacherByTid(map));
    }

    @Test
    public void queryTeacherTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Map<String,Object> map = new HashMap<>();
        map.put("tname","teacher");
        for (Teacher teacher : context.getBean(TeacherService.class).queryTeacher(map)) {
            System.out.println(teacher.toString());
        }
    }
}
