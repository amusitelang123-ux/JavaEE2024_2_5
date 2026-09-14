package cn.edu.lingnan.mapper;

import cn.edu.lingnan.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    public List<Student> queryStudentAll();
    public Student queryStudentBySid(String _sid);
    public Student queryStudentBySnameAndSpassword(@Param("_sname") String _sname, @Param("_spassword") String _spassword);

}
