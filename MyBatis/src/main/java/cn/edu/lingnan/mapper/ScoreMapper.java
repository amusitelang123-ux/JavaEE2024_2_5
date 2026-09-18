package cn.edu.lingnan.mapper;

import java.util.List;

public interface ScoreMapper {
    public List<String> queryScoreCidBySid(String _sid);
    public int queryScoreNumByCid(String _cid);
    public int deleteScoreBySid(String _sid);
}
