package cn.edu.lingnan.demo04;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.jspecify.annotations.Nullable;

public class AroundLog implements MethodInterceptor {
    @Override
    public @Nullable Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("[Debug]AOP模拟日志输出:-环绕before-" + invocation.getMethod().getName() + "方法被调用");
        Object proceed = invocation.proceed();
        System.out.println("[Debug]AOP模拟日志输出:-环绕after-" + invocation.getMethod().getName() + "方法被调用");
        return proceed;
    }

}
