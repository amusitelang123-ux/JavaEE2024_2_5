package cn.edu.lingnan.service;

import cn.edu.lingnan.pojo.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    public List<Student> queryStudentAll();
    public Student queryStudentBySid(String _sid);
    public Student queryStudentBySnameAndSpassword(String _sname, String _spassword);
    public int insertStudent(Student _student);
    public int updateStudent(Student _student);
    public int updateStudentPassword(Map<String, Object> _map);
    public int deleteStudentBySid(String _sid);
    public List<Student> queryStudentUseIf(Map<String, Object> _map);
    public int updateStudentUseSet(Map<String, Object> _map);
}
