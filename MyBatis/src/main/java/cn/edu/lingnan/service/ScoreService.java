package cn.edu.lingnan.service;

import cn.edu.lingnan.pojo.Score;

import java.util.List;
import java.util.Map;

public interface ScoreService {
    public List<Score> queryScoreBySid(String _sid);
    public List<Score> queryScoreByCid(String _cid);
    public int insertScore(Score _score);
    public int updateScoreBySidAndCid(Map<String,Object> _map);
    public List<Score> queryScore(Map<String,Object> _map);
    public int deleteScoreBySid(String _sid);
}

