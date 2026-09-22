package cn.edu.lingnan.service;

import cn.edu.lingnan.pojo.Course;

import java.util.List;

public interface CourseService {
    public List<Course> queryCourseAll();
    public Course queryCourseByCid(String _cid);
    public int insertCourse(Course _course);
    public int updateCourse(Course _course);
    public List<Course> queryCourseByCname(String _cname);
}
