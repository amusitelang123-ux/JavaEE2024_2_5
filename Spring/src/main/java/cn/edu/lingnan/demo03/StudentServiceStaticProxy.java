package cn.edu.lingnan.demo03;

public class StudentServiceStaticProxy implements StudentService{
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void query() {
        log();
        studentService.query();
    }

    @Override
    public void insert() {
        log();
        studentService.insert();
    }

    @Override
    public void update() {
        log();
        studentService.update();
    }

    @Override
    public void delete() {
        log();
        studentService.delete();
    }

    public void log(){
        System.out.println("[Debug]模拟日志:" + Thread.currentThread().getStackTrace()[2].getMethodName() + "方法被调用");
    }
}
