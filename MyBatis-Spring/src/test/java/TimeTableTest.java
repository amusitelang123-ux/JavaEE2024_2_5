import cn.edu.lingnan.pojo.TimeTable;
import cn.edu.lingnan.service.TimeTableService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TimeTableTest {
    @Test
    public void queryTimeTableAllTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        for (TimeTable timeTable : context.getBean(TimeTableService.class).queryTimeTableAll()) {
            System.out.println(timeTable.toString());
        }
    }

    @Test
    public void queryTimeTableByTidTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        for (TimeTable timeTable : context.getBean(TimeTableService.class).queryTimeTableByTid(1)) {
            System.out.println(timeTable.toString());
        }
    }

    @Test
    public void queryTimeTableByCidTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        for (TimeTable timeTable : context.getBean(TimeTableService.class).queryTimeTableByCid("c01")) {
            System.out.println(timeTable.toString());
        }
    }

    @Test
    public void insertTimeTableTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TimeTable timeTable = new TimeTable(1, "c03", "教室", "时间", 1);
        System.out.println(context.getBean(TimeTableService.class).insertTimeTable(timeTable));
    }

    @Test
    public void deleteTimeTableByTidTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(context.getBean(TimeTableService.class).deleteTimeTableByTid(3));
    }
}
