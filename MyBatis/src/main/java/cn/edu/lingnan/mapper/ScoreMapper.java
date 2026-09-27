package cn.edu.lingnan.mapper;

import cn.edu.lingnan.pojo.Score;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ScoreMapper {
    @Select("select cid from score where sid = #{_sid}")
    public List<String> queryScoreCidBySid(String _sid);
    @Select("select count(*) as num from score where cid = #{_cid}")
    public int queryScoreNumByCid(String _cid);
    @Delete("delete from score where sid = #{_sid}")
    public int deleteScoreBySid(String _sid);
    @Delete("delete from score where cid = #{_cid}")
    public int deleteScoreByCid(String _cid);
    @Select("select * from score where sid = #{_sid}")
    public List<Score> queryScoreBySid(String _sid);
    @Select("select * from score where cid = #{_cid}")
    public List<Score> queryScoreByCid(String _cid);
    @Insert("insert into score values (#{sid},#{cid},#{score},#{scflag})")
    public int insertScore(Score _score);
    //动态SQL
    public int updateScoreBySidAndCid(Map<String,Object> _map);
    public List<Score> queryScore(Map<String,Object> _map);
}
