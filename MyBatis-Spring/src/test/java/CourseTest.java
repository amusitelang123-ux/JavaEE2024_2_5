import cn.edu.lingnan.pojo.Course;
import cn.edu.lingnan.service.CourseService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CourseTest {
    @Test
    public void queryCourseAllTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        for (Course course : context.getBean(CourseService.class).queryCourseAll()) {
            System.out.println(course.toString());
        }
    }

    @Test
    public void insertCourseTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Course course = new Course("c99", "abc", 1);
        System.out.println(context.getBean(CourseService.class).insertCourse(course));
    }

    @Test
    public void deleteCourseByCidTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(context.getBean(CourseService.class).deleteCourseByCid("c99"));
    }

    @Test
    public void queryCourseByCidTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(context.getBean(CourseService.class).queryCourseByCid("c01").toString());
    }
}
