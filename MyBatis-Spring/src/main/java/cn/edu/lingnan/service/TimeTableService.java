package cn.edu.lingnan.service;

import cn.edu.lingnan.pojo.TimeTable;

import java.util.List;
import java.util.Map;

public interface TimeTableService {
    public List<TimeTable> queryTimeTableAll();
    public List<TimeTable> queryTimeTableByTid(int _tid);
    public List<TimeTable> queryTimeTableByCid(String _cid);
    public int insertTimeTable(TimeTable _timeTable);
    public int deleteTimeTableByTid(int _tid);
    public int deleteTimeTableByCid(String _cid);
    public int updateTimeTableByTidAndCid(Map<String,Object> _map);
    public List<TimeTable> queryTimeTable(Map<String,Object> _map);
}

