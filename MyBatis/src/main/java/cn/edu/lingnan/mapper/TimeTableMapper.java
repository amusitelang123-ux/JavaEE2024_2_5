package cn.edu.lingnan.mapper;

import cn.edu.lingnan.pojo.TimeTable;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TimeTableMapper {
    @Delete("delete from timetable where cid = #{_cid}")
    public int deleteTimeTableByCid(String _cid);
    @Select("select cid from timetable where tid = #{_tid}")
    public List<String> queryTimeTableCidByTid(int _tid);
    @Select("select count(*) as num from timetable where cid = #{_cid}")
    public int queryTimeTableNumByCid(String _cid);
    @Delete("delete from timetable where tid = #{_tid}")
    public int deleteTimeTableByTid(int _tid);
    @Select("select * from timetable")
    public List<TimeTable> queryTimeTableAll();
    @Select("select * from timetable where tid = #{_tid}")
    public List<TimeTable> queryTimeTableByTid(int _tid);
    @Select("select * from timetable where cid = #{_cid}")
    public List<TimeTable> queryTimeTableByCid(String _cid);
    @Insert("insert into timetable values (#{tid},#{cid},#{classroom},#{classtime},#{ttflag})")
    public int insertTimeTable(TimeTable _timeTable);
    @Select("select tid from timetable where cid = #{_cid}")
    public List<Integer> queryTimeTableTidByCid(String _cid);
    //动态SQL
    public int updateTimeTableByTidAndCid(Map<String,Object> _map);
    public List<TimeTable> queryTimeTable(Map<String,Object> _map);
}
