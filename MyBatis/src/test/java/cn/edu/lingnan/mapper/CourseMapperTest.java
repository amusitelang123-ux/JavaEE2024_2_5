package cn.edu.lingnan.mapper;

import cn.edu.lingnan.pojo.Course;
import cn.edu.lingnan.pojo.CourseExtend;
import cn.edu.lingnan.pojo.CourseTeacherTimeTable;
import cn.edu.lingnan.service.CourseService;
import cn.edu.lingnan.service.Impl.CourseServiceImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class CourseMapperTest {
    CourseService courseService=new CourseServiceImpl();

    @Test
    public void queryCourseAllTest(){
        for (Course course : courseService.queryCourseAll()) {
            System.out.println(course.toString());
        }
    }

    @Test
    public void queryCourseByCidTest(){
        System.out.println(courseService.queryCourseByCid("c01").toString());
    }

    @Test
    public void insertCourseTest(){
        Course course=new Course("c06","Python",1);
        System.out.println(courseService.insertCourse(course));
    }

    @Test
    public void updateCourseTest(){
        Course course=new Course("c06","Python",0);
        System.out.println(courseService.updateCourse(course));
    }

    @Test
    public void queryCourseByCnameTest(){
        for (Course course : courseService.queryCourseByCname("Java")) {
            System.out.println(course.toString());
        }
    }

    @Test
    public void queryCourseUseIfTest(){
        Map<String,Object> map=new HashMap<>();
        map.put("cname","J");
        map.put("cflag","1");
        for (Course course : courseService.queryCourseUseIf(map)) {
            System.out.println(course.toString());
        }
    }

    @Test
    public void updateCourseUseSetTest(){
        Map<String,Object> map=new HashMap<>();
        map.put("cid","c06");
        map.put("cname","PHP");
        map.put("cflag",0);
        System.out.println(courseService.updateCourseUseSet(map));
    }

    @Test
    public void deleteCourseByCidTest(){
        System.out.println(courseService.deleteCourseByCid("c06"));
    }

    @Test
    public void queryTnameByCidTest(){
        System.out.println(courseService.queryTnameByCid("c01"));
    }
    @Test
    public void queryInfoByCid01Test(){
        System.out.println(courseService.queryInfoByCid01("c01"));
    }

    @Test
    public void queryInfoByCid02Test(){
        for (CourseTeacherTimeTable ctt : courseService.queryInfoByCid02("c02")) {
            System.out.println(ctt.toString());
        }
    }

    @Test
    public void queryInfoByCid03Test(){
        for (CourseExtend ct : courseService.queryInfoByCid03("c02")) {
            System.out.println(ct.toString());
        }
    }
}
