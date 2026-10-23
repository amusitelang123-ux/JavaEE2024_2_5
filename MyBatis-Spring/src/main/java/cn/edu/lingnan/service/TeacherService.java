package cn.edu.lingnan.service;

import cn.edu.lingnan.pojo.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    public List<Teacher> queryTeacherAll();
    public List<Teacher> queryTeacherByName(String _tname);
    public Teacher queryTeacherByTid(int _tid);
    public int deleteTeacherByTid(int _tid);
    public int insertTeacher(Teacher teacher);
    public int updateTeacherByTid(Map<String,Object> _map);
    public List<Teacher> queryTeacher(Map<String,Object> _map);
}
