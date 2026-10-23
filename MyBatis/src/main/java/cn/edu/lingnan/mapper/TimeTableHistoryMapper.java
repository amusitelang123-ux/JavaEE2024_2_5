package cn.edu.lingnan.mapper;

import cn.edu.lingnan.pojo.TimeTable;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TimeTableHistoryMapper {
    @Insert("insert into timetablehistory values (#{tid},#{cid},#{classroom},#{classtime},#{ttflag})")
    public int insertTimeTable(TimeTable _timeTable);
    @Delete("delete from timetablehistory where tid = #{_tid}")
    public int deleteTimeTableByTid(int _tid);
    @Delete("delete from timetablehistory where cid = #{_cid}")
    public int deleteTimeTableByCid(String _cid);
    @Select("select * from timetablehistory")
    public List<TimeTable> queryTimeTableAll();
    @Select("select * from timetablehistory where tid = #{_tid}")
    public List<TimeTable> queryTimeTableByTid(int _tid);
    @Select("select * from timetablehistory where cid = #{_cid}")
    public List<TimeTable> queryTimeTableByCid(String _cid);
    //动态SQL
    public List<TimeTable> queryTimeTable(Map<String,Object> _map);
}
