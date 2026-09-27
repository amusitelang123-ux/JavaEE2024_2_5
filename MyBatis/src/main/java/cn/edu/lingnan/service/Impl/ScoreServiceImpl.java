package cn.edu.lingnan.service.Impl;

import cn.edu.lingnan.mapper.ScoreMapper;
import cn.edu.lingnan.pojo.Score;
import cn.edu.lingnan.service.ScoreService;
import cn.edu.lingnan.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ScoreServiceImpl implements ScoreService {
    @Override
    public List<Score> queryScoreBySid(String _sid) {
        List<Score> list= null;
        try(SqlSession session = MyBatisUtil.getSqlSession()) {
            ScoreMapper scoreMapper = session.getMapper(ScoreMapper.class);
            list = scoreMapper.queryScoreBySid(_sid);
        }
        return list;
    }

    @Override
    public List<Score> queryScoreByCid(String _cid) {
        List<Score> list= null;
        try(SqlSession session = MyBatisUtil.getSqlSession()) {
            ScoreMapper scoreMapper = session.getMapper(ScoreMapper.class);
            list = scoreMapper.queryScoreByCid(_cid);
        }
        return list;
    }

    @Override
    public int insertScore(Score _score) {
        int flag = 0;
        try(SqlSession session = MyBatisUtil.getSqlSession()) {
            ScoreMapper scoreMapper = session.getMapper(ScoreMapper.class);
            flag = scoreMapper.insertScore(_score);
            session.commit();
        }
        return flag;
    }

    @Override
    public int updateScoreBySidAndCid(Map<String, Object> _map) {
        int flag = 0;
        try(SqlSession session = MyBatisUtil.getSqlSession()) {
            ScoreMapper scoreMapper = session.getMapper(ScoreMapper.class);
            flag = scoreMapper.updateScoreBySidAndCid(_map);
            session.commit();
        }
        return flag;
    }

    @Override
    public List<Score> queryScore(Map<String, Object> _map) {
        List<Score> list= null;
        try(SqlSession session = MyBatisUtil.getSqlSession()) {
            ScoreMapper scoreMapper = session.getMapper(ScoreMapper.class);
            list = scoreMapper.queryScore(_map);
        }
        return list;
    }

    @Override
    public int deleteScoreBySid(String _sid) {
        int flag = 0;
        try(SqlSession session = MyBatisUtil.getSqlSession()) {
            ScoreMapper scoreMapper = session.getMapper(ScoreMapper.class);
            flag = scoreMapper.deleteScoreBySid(_sid);
            session.commit();
        }
        return flag;
    }
}
