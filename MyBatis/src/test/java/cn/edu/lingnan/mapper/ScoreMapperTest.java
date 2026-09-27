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
        Score score = new Score("s05","c05",100,1);
        System.out.println(scoreService.insertScore(score));
    }

    @Test
    public void updateScoreBySidTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("sid","s05");
        map.put("cid","c05");
//        map.put("score",60);
        map.put("scflag",1);
        System.out.println(scoreService.updateScoreBySidAndCid(map));
    }

    @Test
    public void queryScoreTest(){
        Map<String,Object> map = new HashMap<>();
//        map.put("sid","s05");
        map.put("cid","c02");
//        map.put("score",60);
//        map.put("scflag",0);
        for (Score score : scoreService.queryScore(map)) {
            System.out.println(score.toString());
        }
    }

    @Test
    public void deleteScoreBySidTest(){
        System.out.println(scoreService.deleteScoreBySid("s05"));
    }
}
