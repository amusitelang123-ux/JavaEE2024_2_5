package cn.edu.lingnan.service.Impl;

import cn.edu.lingnan.mapper.CourseMapper;
import cn.edu.lingnan.pojo.Course;
import cn.edu.lingnan.service.CourseService;
import cn.edu.lingnan.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CourseServiceImpl implements CourseService {
    @Override
    public List<Course> queryCourseAll() {
        List<Course> list = new ArrayList<>();
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            CourseMapper mapper = session.getMapper(CourseMapper.class);
            list = mapper.queryCourseAll();
        }
        return list;
    }

    @Override
    public Course queryCourseByCid(String _cid) {
        Course course = null;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            CourseMapper mapper = session.getMapper(CourseMapper.class);
            course = mapper.queryCourseByCid(_cid);
        }
        return course;
    }

    @Override
    public int insertCourse(Course _course) {
        int flag = 0;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            CourseMapper mapper = session.getMapper(CourseMapper.class);
            flag = mapper.insertCourse(_course);
            session.commit();
        }
        return flag;
    }

    @Override
    public int updateCourse(Course _course) {
        int flag = 0;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            CourseMapper mapper = session.getMapper(CourseMapper.class);
            flag = mapper.updateCourse(_course);
            session.commit();
        }
        return flag;
    }

    @Override
    public List<Course> queryCourseByCname(String _cname) {
        List<Course> list = new ArrayList<>();
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            CourseMapper mapper = session.getMapper(CourseMapper.class);
            list = mapper.queryCourseByCname(_cname);
        }
        return list;
    }

    @Override
    public List<Course> queryCourseUseIf(Map<String, Object> _map) {
        List<Course> list = new ArrayList<>();
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            CourseMapper mapper = session.getMapper(CourseMapper.class);
            list = mapper.queryCourseUseIf(_map);
        }
        return list;
    }

    @Override
    public int updateCourseUseSet(Map<String, Object> _map) {
        int flag = 0;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            CourseMapper mapper = session.getMapper(CourseMapper.class);
            flag = mapper.updateCourseUseSet(_map);
            session.commit();
        }
        return flag;
    }
}
