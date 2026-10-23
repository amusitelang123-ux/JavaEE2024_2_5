import cn.edu.lingnan.pojo.Score;
import cn.edu.lingnan.service.ScoreService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class ScoreTest {
    @Test
    public void queryScoreAllTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        for (Score score : context.getBean(ScoreService.class).queryScoreAll()) {
            System.out.println(score.toString());
        }
    }

    @Test
    public void queryScoreBySidTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        for (Score score : context.getBean(ScoreService.class).queryScoreBySid("s01")) {
            System.out.println(score.toString());
        }
    }

    @Test
    public void queryScoreByCidTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        for (Score score : context.getBean(ScoreService.class).queryScoreByCid("c02")) {
            System.out.println(score.toString());
        }
    }

    @Test
    public void insertScoreTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Score score = new Score("s01","c03",1,1);
        System.out.println(context.getBean(ScoreService.class).insertScore(score));
    }

    @Test
    public void updateScoreBySidAndCidTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Map<String,Object> map = new HashMap<>();
        map.put("sid","s01");
        map.put("cid","c03");
        map.put("score",20);
        map.put("flag",1);
        System.out.println(context.getBean(ScoreService.class).updateScoreBySidAndCid(map));
    }

    @Test
    public void queryScoreTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Map<String,Object> map = new HashMap<>();
        map.put("sid","s01");
        for (Score score : context.getBean(ScoreService.class).queryScore(map)) {
            System.out.println(score.toString());
        }
    }

    @Test
    public void deleteScoreBySidTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(context.getBean(ScoreService.class).deleteScoreBySid("s03"));
    }
}
