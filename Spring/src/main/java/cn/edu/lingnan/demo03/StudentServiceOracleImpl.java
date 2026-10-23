package cn.edu.lingnan.demo03;

public class StudentServiceOracleImpl implements StudentService{
    @Override
    public void query() {
        System.out.println("Oracle实现了查询");
    }

    @Override
    public void insert() {
        System.out.println("Oracle实现了新增");
    }

    @Override
    public void update() {
        System.out.println("Oracle实现了更新");
    }

    @Override
    public void delete() {
        System.out.println("Oracle实现了删除");
    }
}
