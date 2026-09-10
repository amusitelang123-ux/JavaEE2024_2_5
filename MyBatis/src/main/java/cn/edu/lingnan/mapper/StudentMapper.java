package cn.edu.lingnan.mapper;

import cn.edu.lingnan.pojo.Student;

import java.util.List;

public interface StudentMapper {
    public List<Student> queryStudentAll();
    public Student queryStudentBySid(String _sid);

}
