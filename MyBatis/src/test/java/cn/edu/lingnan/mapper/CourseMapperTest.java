package cn.edu.lingnan.mapper;

import cn.edu.lingnan.pojo.Course;
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
        System.out.println(courseService.queryCourseByCname("Java").toString());
    }

    @Test
    public void queryCourseUseIfTest(){
        Map<String,Object> map=new HashMap<>();
//        map.put("cname","J");
        map.put("cflag","1");
        System.out.println(courseService.queryCourseUseIf(map).toString());
    }

    @Test
    public void updateCourseUseSetTest(){
        Map<String,Object> map=new HashMap<>();
        map.put("cid","c06");
//        map.put("cname","PHP");
        map.put("cflag",0);
        System.out.println(courseService.updateCourseUseSet(map));
    }
}
