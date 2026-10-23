package cn.edu.lingnan.service;

import cn.edu.lingnan.pojo.Course;
import cn.edu.lingnan.pojo.CourseExtend;
import cn.edu.lingnan.pojo.CourseTeacherTimeTable;

import java.util.List;
import java.util.Map;

public interface CourseService {
    public List<Course> queryCourseAll();
    public Course queryCourseByCid(String _cid);
    public int insertCourse(Course _course);
    public int updateCourse(Course _course);
    public List<Course> queryCourseByCname(String _cname);
    public int deleteCourseByCid(String _cid);
    public List<Course> queryCourseUseIf(Map<String,Object> _map);
    public int updateCourseUseSet(Map<String,Object> _map);
    public List<String> queryTnameByCid(String _cid);
    public Map<String,Object> queryInfoByCid01(String _cid);
    public List<CourseTeacherTimeTable> queryInfoByCid02(String _cid);
    public List<CourseExtend> queryInfoByCid03(String _cid);
}
