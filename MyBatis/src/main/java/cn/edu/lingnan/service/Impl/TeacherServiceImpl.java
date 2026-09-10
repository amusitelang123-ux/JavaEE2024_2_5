package cn.edu.lingnan.service.Impl;

import cn.edu.lingnan.mapper.TeacherMapper;
import cn.edu.lingnan.pojo.Teacher;
import cn.edu.lingnan.service.TeacherService;
import cn.edu.lingnan.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    @Override
    public List<Teacher> queryTeacherAll() {
        List<Teacher> list = null;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            TeacherMapper mapper = session.getMapper(TeacherMapper.class);
            list = mapper.queryTeacherAll();
        }
        return list;
    }

    @Override
    public List<Teacher> queryTeacherByName(String _tname) {
        List<Teacher> list = null;
        try(SqlSession session = MyBatisUtil.getSqlSession()){
            TeacherMapper mapper = session.getMapper(TeacherMapper.class);
            list = mapper.queryTeacherByName(_tname);
        }
        return list;
    }
}
