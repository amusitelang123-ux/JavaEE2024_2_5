package cn.edu.lingnan.mapper;

import cn.edu.lingnan.pojo.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TeacherHistoryMapper {
    @Insert("insert into teacherhistory values (null,#{tname},#{tpassword},#{tright},#{tflag})")
    public int insertTeacher(Teacher teacher);
    @Select("select * from teacherhistory")
    public List<Teacher> queryTeacherAll();
    @Select("select * from teacherhistory where tid = #{_tid}")
    public Teacher queryTeacherByTid(int _tid);
    @Delete("delete from teacherhistory where tid = #{_tid}")
    public int deleteTeacherByTid(int _tid);
    //动态SQL
    public List<Teacher> queryTeacher(Map<String,Object> _map);
}
