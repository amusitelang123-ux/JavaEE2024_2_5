package cn.edu.lingnan.demo03;

public class StudentServiceMysqlImpl implements StudentService{
    @Override
    public void query() {
        System.out.println("MySQL实现了查询");
    }

    @Override
    public void insert() {
        System.out.println("MySQL实现了新增");
    }

    @Override
    public void update() {
        System.out.println("MySQL实现了更新");
    }

    @Override
    public void delete() {
        System.out.println("MySQL实现了删除");
    }
}
