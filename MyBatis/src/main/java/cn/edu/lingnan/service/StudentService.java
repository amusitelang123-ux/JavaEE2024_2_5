package cn.edu.lingnan.service;

import cn.edu.lingnan.pojo.Student;

import java.util.List;

public interface StudentService {
    public List<Student> queryStudentAll();
    public Student queryStudentBySid(String _sid);
    public Student queryStudentBySnameAndSpassword(String _sname, String _spassword);
}
