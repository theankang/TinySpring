package com.github.theankang.tinyspring.aop;

import java.lang.reflect.Method;

public class AfterAdvice implements Advice {
    private Object bean;
    private MethodInvocation methodInvocation;

    public AfterAdvice(Object bean, MethodInvocation methodInvocation) {
        this.bean = bean;
        this.methodInvocation = methodInvocation;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object o = method.invoke(bean, args);
        methodInvocation.invoke();
        return o;
    }
}
