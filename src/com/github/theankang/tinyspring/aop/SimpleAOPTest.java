package com.github.theankang.tinyspring.aop;

import org.junit.jupiter.api.Test;

public class SimpleAOPTest {
    @Test
    public void getProxy() throws Exception {
        // 1. 创建一个 MethodInvocation 实现类
        MethodInvocation logTask = () -> System.out.println("log task start");
        HelloServiceImpl helloServiceImpl = new HelloServiceImpl();

        // 2. 创建一个 Advice
        Advice beforeAdvice = new BeforeAdvice(helloServiceImpl, logTask);

        // 3. 为目标对象生成代理
        HelloService helloServiceImplProxy = (HelloService) SimpleAOP.getProxy(helloServiceImpl,beforeAdvice);

        helloServiceImplProxy.sayHelloWorld();

        MethodInvocation logTaskAfter = () -> System.out.println("log task end");
        Advice afterAdvice = new AfterAdvice(helloServiceImpl, logTaskAfter);
        HelloService helloServiceImplProxy1 = (HelloService) SimpleAOP.getProxy(helloServiceImpl, afterAdvice);
        helloServiceImplProxy1.sayHelloWorld();
    }
}
