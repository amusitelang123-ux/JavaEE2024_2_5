package cn.edu.lingnan.mapper;

import cn.edu.lingnan.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    @Select("select * from student")
    public List<Student> queryStudentAll();
    @Select("select * from student where sid = #{_sid}")
    public Student queryStudentBySid(String _sid);
    @Select("select * from student where sname = #{_sname} and spassword = #{_spassword}")
    public Student queryStudentBySnameAndSpassword(@Param("_sname") String _sname, @Param("_spassword") String _spassword);
    @Insert("insert into student(sid, sname, spassword, sright, sflag)\n" +
            "        values (#{sid}, #{sname}, #{spassword}, #{sright}, #{sflag})")
    public int insertStudent(Student _student);
    @Update("update student\n" +
            "        set sname=#{sname},spassword=#{spassword},sright=#{sright},sflag=#{sflag}\n" +
            "        where sid=#{sid}")
    public int updateStudent(Student _student);
    @Update("update student\n" +
            "        set spassword=#{spassword}\n" +
            "        where sid=#{sid}")
    public int updateStudentPassword(Map<String, Object> _map);
    @Delete("delete from student where sid = #{sid}")
    public int deleteStudentBySid(String _sid);

    //动态SQL
    public List<Student> queryStudentUseIf(Map<String, Object> _map);
    public int updateStudentUseSet(Map<String, Object> _map);
    public List<Student> queryStudentUseForeach(Map<String, Object> _map);
}
