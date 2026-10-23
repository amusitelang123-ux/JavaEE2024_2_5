package cn.edu.lingnan.service.Impl;

import cn.edu.lingnan.mapper.*;
import cn.edu.lingnan.pojo.Course;
import cn.edu.lingnan.pojo.Score;
import cn.edu.lingnan.pojo.TimeTable;
import cn.edu.lingnan.service.TimeTableService;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TimeTableServiceImpl implements TimeTableService {
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<TimeTable> queryTimeTableAll() {
        return sqlSessionTemplate.getMapper(TimeTableMapper.class).queryTimeTableAll();
    }

    @Override
    public List<TimeTable> queryTimeTableByTid(int _tid) {
        return sqlSessionTemplate.getMapper(TimeTableMapper.class).queryTimeTableByTid(_tid);
    }

    @Override
    public List<TimeTable> queryTimeTableByCid(String _cid) {
        return sqlSessionTemplate.getMapper(TimeTableMapper.class).queryTimeTableByCid(_cid);
    }

    @Override
    public int insertTimeTable(TimeTable _timeTable) {
        return sqlSessionTemplate.getMapper(TimeTableMapper.class).insertTimeTable(_timeTable);
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public int deleteTimeTableByTid(int _tid) {
        TimeTableMapper timeTableMapper = sqlSessionTemplate.getMapper(TimeTableMapper.class);
        ScoreMapper scoreMapper = sqlSessionTemplate.getMapper(ScoreMapper.class);
        CourseMapper courseMapper = sqlSessionTemplate.getMapper(CourseMapper.class);

        List<TimeTable> timeTables = timeTableMapper.queryTimeTableByTid(_tid);
        List<String> cids = timeTableMapper.queryTimeTableCidByTid(_tid);
        List<Score> scores = new ArrayList<>();
        List<Course> courses = new ArrayList<>();

        int flag = 0;

        flag = timeTableMapper.deleteTimeTableByTid(_tid);

        for (String cid : cids) {
            if (timeTableMapper.queryTimeTableNumByCid(cid) == 0) {
                scores.addAll(scoreMapper.queryScoreByCid(cid));
                courses.add(courseMapper.queryCourseByCid(cid));
                scoreMapper.deleteScoreByCid(cid);
                courseMapper.deleteCourseByCid(cid);
            }
        }
        for (TimeTable timeTable : timeTables) {
            sqlSessionTemplate.getMapper(TimeTableHistoryMapper.class).insertTimeTable(timeTable);
        }
        for (Score score : scores) {
            sqlSessionTemplate.getMapper(ScoreHistoryMapper.class).insertScore(score);
        }
        for (Course course : courses) {
            sqlSessionTemplate.getMapper(CourseHistoryMapper.class).insertCourse(course);
        }
        return flag;
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public int deleteTimeTableByCid(String _cid) {
        TimeTableMapper timeTableMapper = sqlSessionTemplate.getMapper(TimeTableMapper.class);
        ScoreMapper scoreMapper = sqlSessionTemplate.getMapper(ScoreMapper.class);
        CourseMapper courseMapper = sqlSessionTemplate.getMapper(CourseMapper.class);

        int flag = 0;

        List<Score> scores = scoreMapper.queryScoreByCid(_cid);
        Course course = courseMapper.queryCourseByCid(_cid);
        List<TimeTable> timeTables = timeTableMapper.queryTimeTableByCid(_cid);

        flag = timeTableMapper.deleteTimeTableByCid(_cid);
        scoreMapper.deleteScoreByCid(_cid);
        courseMapper.deleteCourseByCid(_cid);

        for (TimeTable timeTable : timeTables) {
            sqlSessionTemplate.getMapper(TimeTableHistoryMapper.class).insertTimeTable(timeTable);
        }
        for (Score score : scores) {
            sqlSessionTemplate.getMapper(ScoreHistoryMapper.class).insertScore(score);
        }
        sqlSessionTemplate.getMapper(CourseHistoryMapper.class).insertCourse(course);
        return flag;
    }

    @Override
    public int updateTimeTableByTidAndCid(Map<String, Object> _map) {
        return sqlSessionTemplate.getMapper(TimeTableMapper.class).updateTimeTableByTidAndCid(_map);
    }

    @Override
    public List<TimeTable> queryTimeTable(Map<String, Object> _map) {
        return sqlSessionTemplate.getMapper(TimeTableMapper.class).queryTimeTable(_map);
    }
//    @Override
//    public List<TimeTable> queryTimeTableAll() {
//        List<TimeTable> list = null;
//        try(SqlSession session = MyBatisUtil.getSqlSession()){
//            TimeTableMapper mapper = session.getMapper(TimeTableMapper.class);
//            list = mapper.queryTimeTableAll();
//        }
//        return list;
//    }
//
//    @Override
//    public List<TimeTable> queryTimeTableByTid(int _tid) {
//        List<TimeTable> list = null;
//        try(SqlSession session = MyBatisUtil.getSqlSession()){
//            TimeTableMapper mapper = session.getMapper(TimeTableMapper.class);
//            list = mapper.queryTimeTableByTid(_tid);
//        }
//        return list;
//    }
//
//    @Override
//    public List<TimeTable> queryTimeTableByCid(String _cid) {
//        List<TimeTable> list = null;
//        try(SqlSession session = MyBatisUtil.getSqlSession()){
//            TimeTableMapper mapper = session.getMapper(TimeTableMapper.class);
//            list = mapper.queryTimeTableByCid(_cid);
//        }
//        return list;
//    }
//
//    @Override
//    public int insertTimeTable(TimeTable _timeTable) {
//        int flag = 0;
//        try(SqlSession session = MyBatisUtil.getSqlSession()){
//            TimeTableMapper mapper = session.getMapper(TimeTableMapper.class);
//            flag = mapper.insertTimeTable(_timeTable);
//            session.commit();
//        }
//        return flag;
//    }
//
//    @Override
//    public int deleteTimeTableByTid(int _tid) {
//        int flag = 0;
//        try(SqlSession session = MyBatisUtil.getSqlSession()){
//            TimeTableMapper timeTableMapper = session.getMapper(TimeTableMapper.class);
//            TimeTableHistoryMapper  timeTableHistoryMapper = session.getMapper(TimeTableHistoryMapper.class);
//            List<TimeTable> list = timeTableMapper.queryTimeTableByTid(_tid);
//            flag = timeTableMapper.deleteTimeTableByTid(_tid);
//            for (TimeTable timeTable : list) {
//                timeTableHistoryMapper.insertTimeTable(timeTable);
//            }
//            session.commit();
//        }
//        return flag;
//    }
//
//    @Override
//    public int deleteTimeTableByCid(String _cid) {
//        int flag = 0;
//        try(SqlSession session = MyBatisUtil.getSqlSession()){
//            TimeTableMapper timeTableMapper = session.getMapper(TimeTableMapper.class);
//            TimeTableHistoryMapper  timeTableHistoryMapper = session.getMapper(TimeTableHistoryMapper.class);
//            List<TimeTable> list = timeTableMapper.queryTimeTableByCid(_cid);
//            flag = timeTableMapper.deleteTimeTableByCid(_cid);
//            for (TimeTable timeTable : list) {
//                timeTableHistoryMapper.insertTimeTable(timeTable);
//            }
//            session.commit();
//        }
//        return flag;
//    }
//
//    @Override
//    public int updateTimeTableByTidAndCid(Map<String, Object> _map) {
//        int flag = 0;
//        try(SqlSession session = MyBatisUtil.getSqlSession()){
//            TimeTableMapper mapper = session.getMapper(TimeTableMapper.class);
//            flag = mapper.updateTimeTableByTidAndCid(_map);
//            session.commit();
//        }
//        return flag;
//    }
//
//    @Override
//    public List<TimeTable> queryTimeTable(Map<String, Object> _map) {
//        List<TimeTable> list = null;
//        try(SqlSession session = MyBatisUtil.getSqlSession()){
//            TimeTableMapper mapper = session.getMapper(TimeTableMapper.class);
//            list = mapper.queryTimeTable(_map);
//        }
//        return list;
//    }
}
