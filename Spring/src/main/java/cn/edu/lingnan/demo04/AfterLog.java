package cn.edu.lingnan.demo04;

import org.jspecify.annotations.Nullable;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AfterLog implements AfterReturningAdvice {
    @Override
    public void afterReturning(@Nullable Object returnValue, Method method, @Nullable Object[] args, @Nullable Object target) throws Throwable {
        System.out.println("[Debug]AOP模拟日志输出:-after-" + method.getName() + "方法被调用");
    }
}
