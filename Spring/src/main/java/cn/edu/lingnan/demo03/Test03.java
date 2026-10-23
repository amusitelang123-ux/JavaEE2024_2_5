package cn.edu.lingnan.demo03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = context.getBean("studentService",StudentService.class);
        studentService.query();
        studentService.insert();
        studentService.update();
        studentService.delete();
        //静态代理
//        StudentServiceStaticProxy staticProxy = context.getBean(StudentServiceStaticProxy.class);
//        staticProxy.query();
//        staticProxy.delete();
//        staticProxy.insert();
//        staticProxy.update();
//        //动态代理
//        DynamicProxy dynamicProxy = context.getBean(DynamicProxy.class);
//        StudentService proxy = (StudentService) dynamicProxy.getProxy();
//        proxy.update();
//        proxy.insert();
//        proxy.insert();
//        proxy.delete();
    }
}
