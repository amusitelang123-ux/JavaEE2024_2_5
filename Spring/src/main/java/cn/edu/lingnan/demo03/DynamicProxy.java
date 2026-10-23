package cn.edu.lingnan.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private Object object;

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                this
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log();
        return method.invoke(object, args);
    }

    public void log(){
        System.out.println("[Debug]模拟日志:" + Thread.currentThread().getStackTrace()[3].getMethodName() + "方法被调用");
    }
}
