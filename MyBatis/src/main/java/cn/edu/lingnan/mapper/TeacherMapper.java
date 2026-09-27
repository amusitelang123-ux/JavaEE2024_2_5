package cn.edu.lingnan.mapper;

import cn.edu.lingnan.pojo.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TeacherMapper {
    @Select("select * from teacher")
    public List<Teacher> queryTeacherAll();
    @Select("select * from teacher where tname like concat('%', #{_tname}, '%')")
    public List<Teacher> queryTeacherByName(String _tname);
    @Select("select * from teacher where tid = #{_tid}")
    public Teacher queryTeacherByTid(int _tid);
    @Delete("delete from teacher where tid = #{_tid}")
    public int deleteTeacherByTid(int _tid);
    @Insert("insert into teacher values (null,#{tname},#{tpassword},#{tright},#{tflag})")
    public int insertTeacher(Teacher teacher);
    //动态SQL
    public int updateTeacherByTid(Map<String,Object> _map);
    public List<Teacher> queryTeacher(Map<String,Object> _map);
}
