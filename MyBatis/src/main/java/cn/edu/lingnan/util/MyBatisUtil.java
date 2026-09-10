package cn.edu.lingnan.util;

import cn.edu.lingnan.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static String resource = "mybatis-config.xml";
    public static SqlSessionFactory sqlSessionFactory = null;
    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static SqlSession getSqlSession(){
        SqlSession session = null;
        session = sqlSessionFactory.openSession();
        return session;
    }

}
