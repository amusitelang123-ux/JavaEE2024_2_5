package cn.edu.lingnan.service;

import cn.edu.lingnan.pojo.Course;

import java.util.List;
import java.util.Map;

public interface CourseService {
    public List<Course> queryCourseAll();
    public Course queryCourseByCid(String _cid);
    public int insertCourse(Course _course);
    public int updateCourse(Course _course);
    public List<Course> queryCourseByCname(String _cname);
    public List<Course> queryCourseUseIf(Map<String,Object> _map);
    public int updateCourseUseSet(Map<String,Object> _map);
}
