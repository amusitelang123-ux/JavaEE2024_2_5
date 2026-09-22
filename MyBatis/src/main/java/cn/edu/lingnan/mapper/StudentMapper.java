package cn.edu.lingnan.mapper;

import cn.edu.lingnan.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    public List<Student> queryStudentAll();
    public Student queryStudentBySid(String _sid);
    public Student queryStudentBySnameAndSpassword(@Param("_sname") String _sname, @Param("_spassword") String _spassword);
    public int insertStudent(Student _student);
    public int updateStudent(Student _student);
    public int updateStudentPassword(Map<String, Object> _map);
    public int deleteStudentBySid(String _sid);
    public List<Student> queryStudentUseIf(Map<String, Object> _map);
    public int updateStudentUseSet(Map<String, Object> _map);
}
