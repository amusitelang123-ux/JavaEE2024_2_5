package cn.edu.lingnan.demo00;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test00 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello666 hello666 = context.getBean("hello666", Hello666.class);
        Helloworld helloworld = context.getBean("helloworld", Helloworld.class);
        Hello hello = context.getBean("hello", Hello.class);
        hello666.sayHello();
        helloworld.sayHello();
        hello.sayHello();
    }
}
