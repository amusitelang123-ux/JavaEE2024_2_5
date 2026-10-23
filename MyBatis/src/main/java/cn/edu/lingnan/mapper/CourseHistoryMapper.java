package cn.edu.lingnan.mapper;

import cn.edu.lingnan.pojo.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface CourseHistoryMapper {
    @Insert("insert into coursehistory values (#{cid},#{cname},#{cflag})")
    public int insertCourse(Course _course);
    @Delete("delete from coursehistory where cid = #{_sid}")
    public int deleteCourseByCid(String _cid);
    @Select("select * from coursehistory")
    public List<Course> queryCourseAll();
    @Select("select * from school.coursehistory where cid = #{_cid}")
    public Course queryCourseByCid(String _cid);
    //动态SQL
    public List<Course> queryCourseUseIf(Map<String,Object> _map);
}
