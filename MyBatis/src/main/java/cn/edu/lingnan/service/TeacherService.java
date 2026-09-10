package cn.edu.lingnan.service;

import cn.edu.lingnan.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    public List<Teacher> queryTeacherAll();
    public List<Teacher> queryTeacherByName(String _tname);
}
