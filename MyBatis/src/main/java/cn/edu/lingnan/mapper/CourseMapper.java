package cn.edu.lingnan.mapper;

import cn.edu.lingnan.pojo.Course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CourseMapper {
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
}
