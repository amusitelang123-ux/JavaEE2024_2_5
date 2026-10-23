package cn.edu.lingnan.mapper;

import cn.edu.lingnan.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface StudentHistoryMapper {
    @Insert("insert into studenthistory(sid, sname, spassword, sright, sflag)\n" +
            "        values (#{sid}, #{sname}, #{spassword}, #{sright}, #{sflag})")
    public int insertStudent(Student _student);
    @Delete("delete from studenthistory where sid = #{sid}")
    public int deleteStudentBySid(String _sid);
    @Select("select * from studenthistory")
    public List<Student> queryStudentAll();
    @Select("select * from studenthistory where sid = #{_sid}")
    public Student queryStudentBySid(String _sid);
    //动态SQL
    public List<Student> queryStudentUseIf(Map<String, Object> _map);
}
