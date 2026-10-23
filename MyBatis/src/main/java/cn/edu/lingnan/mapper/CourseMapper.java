package cn.edu.lingnan.mapper;

import cn.edu.lingnan.pojo.Course;
import cn.edu.lingnan.pojo.CourseExtend;
import cn.edu.lingnan.pojo.CourseTeacherTimeTable;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface CourseMapper {
    @Delete("delete from course where cid = #{_sid}")
    public int deleteCourseByCid(String _cid);
    @Select("select * from course")
    public List<Course> queryCourseAll();
    @Select("select * from school.course where cid = #{_cid}")
    public Course queryCourseByCid(String _cid);
    @Insert("insert into course values (#{cid},#{cname},#{cflag})")
    public int insertCourse(Course _course);
    @Update("update course set cname = #{cname},cflag = #{cflag} where cid = #{cid}")
    public int updateCourse(Course _course);
    @Select("select * from course where cname like concat('%',#{_cname},'%')")
    public List<Course> queryCourseByCname(String _cname);
    public Map<String,Object> queryInfoByCid01(String _cid);
    public List<CourseTeacherTimeTable> queryInfoByCid02(String _cid);
    public List<CourseExtend> queryInfoByCid03(String _cid);
    //动态SQL
    public List<Course> queryCourseUseIf(Map<String,Object> _map);
    public int updateCourseUseSet(Map<String,Object> _map);
}
