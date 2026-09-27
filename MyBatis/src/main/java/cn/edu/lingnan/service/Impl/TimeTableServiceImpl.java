package cn.edu.lingnan.service.Impl;

import cn.edu.lingnan.mapper.TimeTableMapper;
import cn.edu.lingnan.pojo.TimeTable;
import cn.edu.lingnan.service.TimeTableService;
import cn.edu.lingnan.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class TimeTableServiceImpl implements TimeTableService {
    @Override
    public List<TimeTable> queryTimeTableAll() {
        List<TimeTable> list = null;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            TimeTableMapper mapper = session.getMapper(TimeTableMapper.class);
            list = mapper.queryTimeTableAll();
        }
        return list;
    }

    @Override
    public List<TimeTable> queryTimeTableByTid(int _tid) {
        List<TimeTable> list = null;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            TimeTableMapper mapper = session.getMapper(TimeTableMapper.class);
            list = mapper.queryTimeTableByTid(_tid);
        }
        return list;
    }

    @Override
    public List<TimeTable> queryTimeTableByCid(String _cid) {
        List<TimeTable> list = null;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            TimeTableMapper mapper = session.getMapper(TimeTableMapper.class);
            list = mapper.queryTimeTableByCid(_cid);
        }
        return list;
    }

    @Override
    public int insertTimeTable(TimeTable _timeTable) {
        int flag = 0;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            TimeTableMapper mapper = session.getMapper(TimeTableMapper.class);
            flag = mapper.insertTimeTable(_timeTable);
            session.commit();
        }
        return flag;
    }

    @Override
    public int deleteTimeTableByTid(int _tid) {
        int flag = 0;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            TimeTableMapper mapper = session.getMapper(TimeTableMapper.class);
            flag = mapper.deleteTimeTableByTid(_tid);
            session.commit();
        }
        return flag;
    }

    @Override
    public int deleteTimeTableByCid(String _cid) {
        int flag = 0;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            TimeTableMapper mapper = session.getMapper(TimeTableMapper.class);
            flag = mapper.deleteTimeTableByCid(_cid);
            session.commit();
        }
        return flag;
    }

    @Override
    public int updateTimeTableByTidAndCid(Map<String, Object> _map) {
        int flag = 0;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            TimeTableMapper mapper = session.getMapper(TimeTableMapper.class);
            flag = mapper.updateTimeTableByTidAndCid(_map);
            session.commit();
        }
        return flag;
    }

    @Override
    public List<TimeTable> queryTimeTable(Map<String, Object> _map) {
        List<TimeTable> list = null;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            TimeTableMapper mapper = session.getMapper(TimeTableMapper.class);
            list = mapper.queryTimeTable(_map);
        }
        return list;
    }
}
