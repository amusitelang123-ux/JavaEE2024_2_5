package cn.edu.lingnan.mapper;

import cn.edu.lingnan.pojo.Teacher;
import cn.edu.lingnan.service.Impl.TeacherServiceImpl;
import cn.edu.lingnan.service.TeacherService;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TeacherMapperTest {

    TeacherService teacherService =  new TeacherServiceImpl();

    @Test
    public void queryTeacherAllTest(){
        for (Teacher teacher : teacherService.queryTeacherAll()) {
            System.out.println(teacher.toString());
        }
    }

    @Test
    public void queryTeacherByNameTest(){
        for (Teacher teacher : teacherService.queryTeacherByName("Lao")) {
            System.out.println(teacher.toString());
        }
    }

    @Test
    public void queryTeacherByTidTest(){
        System.out.println(teacherService.queryTeacherByTid(1).toString());
    }

    @Test
    public void deleteTeacherByTidTest(){
        System.out.println(teacherService.deleteTeacherByTid(6));
    }

    @Test
    public void insertTeacherTest(){
        Teacher teacher = new Teacher(0,"可比2","123",1,0);
        System.out.println(teacherService.insertTeacher(teacher));
    }

    @Test
    public void updateTeacherByTidTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("tid",8);
//        map.put("tname","kebi3");
//        map.put("spassword","123");
        map.put("tright",0);
        map.put("tflag",0);
        System.out.println(teacherService.updateTeacherByTid(map));
    }

    @Test
    public void queryTeacherTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("tname","可");
//        map.put("tright",1);
//        map.put("tflag",0);
        System.out.println(teacherService.queryTeacher(map).toString());
    }
}
