package cn.edu.lingnan.service.Impl;

import cn.edu.lingnan.mapper.*;
import cn.edu.lingnan.pojo.Course;
import cn.edu.lingnan.pojo.Score;
import cn.edu.lingnan.pojo.TimeTable;
import cn.edu.lingnan.service.ScoreService;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ScoreServiceImpl implements ScoreService {

    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<Score> queryScoreBySid(String _sid) {
        return sqlSessionTemplate.getMapper(ScoreMapper.class).queryScoreBySid(_sid);
    }

    @Override
    public List<Score> queryScoreByCid(String _cid) {
        return sqlSessionTemplate.getMapper(ScoreMapper.class).queryScoreByCid(_cid);
    }

    @Override
    public int insertScore(Score _score) {
        return sqlSessionTemplate.getMapper(ScoreMapper.class).insertScore(_score);
    }

    @Override
    public int updateScoreBySidAndCid(Map<String, Object> _map) {
        return sqlSessionTemplate.getMapper(ScoreMapper.class).updateScoreBySidAndCid(_map);
    }

    @Override
    public List<Score> queryScore(Map<String, Object> _map) {
        return sqlSessionTemplate.getMapper(ScoreMapper.class).queryScore(_map);
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public int deleteScoreBySid(String _sid) {

        List<String> cids = sqlSessionTemplate.getMapper(ScoreMapper.class).queryScoreCidBySid(_sid);
        List<TimeTable> timeTables = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        List<Score> scores = sqlSessionTemplate.getMapper(ScoreMapper.class).queryScoreBySid(_sid);

        int flag = sqlSessionTemplate.getMapper(ScoreMapper.class).deleteScoreBySid(_sid);

        for (String cid : cids) {
            if (sqlSessionTemplate.getMapper(ScoreMapper.class).queryScoreNumByCid(cid) == 0) {
                timeTables.addAll(sqlSessionTemplate.getMapper(TimeTableMapper.class).queryTimeTableByCid(cid));
                courses.add(sqlSessionTemplate.getMapper(CourseMapper.class).queryCourseByCid(cid));
                sqlSessionTemplate.getMapper(TimeTableMapper.class).deleteTimeTableByCid(cid);
                sqlSessionTemplate.getMapper(CourseMapper.class).deleteCourseByCid(cid);
            }
        }

        for (Score score : scores) {
            sqlSessionTemplate.getMapper(ScoreHistoryMapper.class).insertScore(score);
        }
        for (TimeTable timeTable : timeTables) {
            sqlSessionTemplate.getMapper(TimeTableHistoryMapper.class).insertTimeTable(timeTable);
        }
        for (Course course : courses) {
            sqlSessionTemplate.getMapper(CourseHistoryMapper.class).insertCourse(course);
        }

        return flag;
    }

    @Override
    public List<Score> queryScoreAll() {
        return sqlSessionTemplate.getMapper(ScoreMapper.class).queryScoreAll();
    }
//    @Override
//    public List<Score> queryScoreBySid(String _sid) {
//        List<Score> list= null;
//        try(SqlSession session = MyBatisUtil.getSqlSession()) {
//            ScoreMapper scoreMapper = session.getMapper(ScoreMapper.class);
//            list = scoreMapper.queryScoreBySid(_sid);
//        }
//        return list;
//    }
//
//    @Override
//    public List<Score> queryScoreByCid(String _cid) {
//        List<Score> list= null;
//        try(SqlSession session = MyBatisUtil.getSqlSession()) {
//            ScoreMapper scoreMapper = session.getMapper(ScoreMapper.class);
//            list = scoreMapper.queryScoreByCid(_cid);
//        }
//        return list;
//    }
//
//    @Override
//    public int insertScore(Score _score) {
//        int flag = 0;
//        try(SqlSession session = MyBatisUtil.getSqlSession()) {
//            ScoreMapper scoreMapper = session.getMapper(ScoreMapper.class);
//            flag = scoreMapper.insertScore(_score);
//            session.commit();
//        }
//        return flag;
//    }
//
//    @Override
//    public int updateScoreBySidAndCid(Map<String, Object> _map) {
//        int flag = 0;
//        try(SqlSession session = MyBatisUtil.getSqlSession()) {
//            ScoreMapper scoreMapper = session.getMapper(ScoreMapper.class);
//            flag = scoreMapper.updateScoreBySidAndCid(_map);
//            session.commit();
//        }
//        return flag;
//    }
//
//    @Override
//    public List<Score> queryScore(Map<String, Object> _map) {
//        List<Score> list= null;
//        try(SqlSession session = MyBatisUtil.getSqlSession()) {
//            ScoreMapper scoreMapper = session.getMapper(ScoreMapper.class);
//            list = scoreMapper.queryScore(_map);
//        }
//        return list;
//    }
//
//    @Override
//    public int deleteScoreBySid(String _sid) {
//        int flag = 0;
//        try(SqlSession session = MyBatisUtil.getSqlSession()) {
//            ScoreMapper scoreMapper = session.getMapper(ScoreMapper.class);
//            ScoreHistoryMapper  scoreHistoryMapper = session.getMapper(ScoreHistoryMapper.class);
//            List<Score> list = scoreMapper.queryScoreBySid(_sid);
//            flag = scoreMapper.deleteScoreBySid(_sid);
//            for (Score score : list) {
//                scoreHistoryMapper.insertScore(score);
//            }
//            session.commit();
//        }
//        return flag;
//    }
//
//    @Override
//    public List<Score> queryScoreAll() {
//        List<Score> list= null;
//        try(SqlSession session = MyBatisUtil.getSqlSession()) {
//            ScoreMapper scoreMapper = session.getMapper(ScoreMapper.class);
//            list = scoreMapper.queryScoreAll();
//        }
//        return list;
//    }
}
