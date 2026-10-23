package cn.edu.lingnan.util;

import org.jspecify.annotations.Nullable;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeforeLog implements MethodBeforeAdvice {
    @Override
    public void before(Method method, @Nullable Object[] args, @Nullable Object target) throws Throwable {
        System.out.println("[Debug]AOP模拟日志输出:-before-" + method.getName() + "方法被调用");
    }
}
