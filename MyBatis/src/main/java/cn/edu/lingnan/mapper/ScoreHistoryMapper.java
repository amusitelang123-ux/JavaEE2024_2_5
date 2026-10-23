package cn.edu.lingnan.mapper;

import cn.edu.lingnan.pojo.Score;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ScoreHistoryMapper {
    @Insert("insert into scorehistory values (#{sid},#{cid},#{score},#{scflag})")
    public int insertScore(Score _score);
    @Delete("delete from scorehistory where sid = #{_sid}")
    public int deleteScoreBySid(String _sid);
    @Delete("delete from scorehistory where cid = #{_cid}")
    public int deleteScoreByCid(String _cid);
    @Select("select * from scorehistory")
    public List<Score> queryScoreAll();
    @Select("select * from scorehistory where sid = #{_sid}")
    public List<Score> queryScoreBySid(String _sid);
    @Select("select * from scorehistory where cid = #{_cid}")
    public List<Score> queryScoreByCid(String _cid);
    //动态SQL
    public List<Score> queryScore(Map<String,Object> _map);
}
