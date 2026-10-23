package cn.edu.lingnan.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class StudentServiceDynamicProxy implements InvocationHandler {
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(
          this.getClass().getClassLoader(),
          studentService.getClass().getInterfaces(),
          this
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log();
        return method.invoke(studentService, args);
    }

    public void log(){
        System.out.println("[Debug]模拟日志:" + Thread.currentThread().getStackTrace()[3].getMethodName() + "方法被调用");
    }
}
