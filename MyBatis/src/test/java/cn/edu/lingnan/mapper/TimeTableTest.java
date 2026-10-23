package cn.edu.lingnan.mapper;

import cn.edu.lingnan.pojo.TimeTable;
import cn.edu.lingnan.service.Impl.TimeTableServiceImpl;
import cn.edu.lingnan.service.TimeTableService;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TimeTableTest {
    TimeTableService timeTableService = new TimeTableServiceImpl();
    @Test
    public void queryTimeTableAllTest(){
        for (TimeTable timeTable : timeTableService.queryTimeTableAll()) {
            System.out.println(timeTable.toString());
        }
    }
    @Test
    public void queryTimeTableByTidTest(){
        for (TimeTable timeTable : timeTableService.queryTimeTableByTid(1)) {
            System.out.println(timeTable.toString());
        }
    }
    @Test
    public void queryTimeTableByCidTest(){
        for (TimeTable timetable : timeTableService.queryTimeTableByCid("c02")) {
            System.out.println(timetable.toString());
        }
    }
    @Test
    public void insertTimeTableTest(){
        TimeTable timeTable = new TimeTable(3,"c04","厕所","24小时不间断",1);
        System.out.println(timeTableService.insertTimeTable(timeTable));
    }
    @Test
    public void deleteTimeTableByTidTest(){
        System.out.println(timeTableService.deleteTimeTableByTid(4));
    }
    @Test
    public void deleteTimeTableByCidTest(){
        System.out.println(timeTableService.deleteTimeTableByCid("c04"));
    }
    @Test
    public void updateTimeTableByTidAndCidTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("tid",3);
        map.put("cid","c03");
        map.put("classroom","公共厕所");
        map.put("classtime","持续宇宙热寂");
        map.put("ttflag",1);
        System.out.println(timeTableService.updateTimeTableByTidAndCid(map));
    }
    @Test
    public void queryTimeTableTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("tid",1);
//        map.put("cid","c01");
//        map.put("classroom","公共厕所");
//        map.put("classtime","持续宇宙热寂");
//        map.put("ttflag",1);
        for (TimeTable timeTable : timeTableService.queryTimeTable(map)) {
            System.out.println(timeTable.toString());
        }
    }
}
