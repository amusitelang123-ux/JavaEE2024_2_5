package cn.edu.lingnan.mapper;

import cn.edu.lingnan.pojo.Score;
import cn.edu.lingnan.service.Impl.ScoreServiceImpl;
import cn.edu.lingnan.service.ScoreService;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ScoreMapperTest {
    ScoreService scoreService =  new ScoreServiceImpl();
    @Test
    public void queryScoreBySidTest(){
        for (Score score : scoreService.queryScoreBySid("s01")) {
            System.out.println(score.toString());
        }
    }

    @Test
    public void queryScoreByCidTest(){
        for (Score score : scoreService.queryScoreByCid("c02")) {
            System.out.println(score.toString());
        }
    }

    @Test
    public void insertScoreTest(){
        Score score = new Score("s04","c04",100,1);
        System.out.println(scoreService.insertScore(score));
    }

    @Test
    public void updateScoreBySidTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("sid","s04");
        map.put("cid","c04");
        map.put("score",60);
        map.put("scflag",1);
        System.out.println(scoreService.updateScoreBySidAndCid(map));
    }

    @Test
    public void queryScoreTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("sid","s04");
        map.put("cid","c04");
        map.put("score",60);
        map.put("scflag",1);
        for (Score score : scoreService.queryScore(map)) {
            System.out.println(score.toString());
        }
    }

    @Test
    public void deleteScoreBySidTest(){
        System.out.println(scoreService.deleteScoreBySid("s04"));
    }

    @Test
    public void queryScoreAllTest(){
        for (Score score : scoreService.queryScoreAll()) {
            System.out.println(score.toString());
        }
    }
}
