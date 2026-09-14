package cn.edu.lingnan.mapper;

import cn.edu.lingnan.pojo.Teacher;
import cn.edu.lingnan.service.Impl.TeacherServiceImpl;
import cn.edu.lingnan.service.TeacherService;
import org.junit.Test;

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
}
