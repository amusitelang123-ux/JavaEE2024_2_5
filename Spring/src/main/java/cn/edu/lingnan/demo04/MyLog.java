package cn.edu.lingnan.demo04;

public class MyLog {
    public void before(){
        System.out.println("[Debug]AOP模拟日志输出:-before-");
    }

    public void after(){
        System.out.println("[Debug]AOP模拟日志输出:-after-");
    }
}
