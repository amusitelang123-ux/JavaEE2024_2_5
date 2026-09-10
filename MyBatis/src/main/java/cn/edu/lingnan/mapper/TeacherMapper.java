package cn.edu.lingnan.mapper;

import cn.edu.lingnan.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {
    public List<Teacher> queryTeacherAll();
    public List<Teacher> queryTeacherByName(String _tname);
}
