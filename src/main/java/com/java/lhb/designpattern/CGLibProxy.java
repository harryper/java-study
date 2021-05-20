package com.java.lhb.designpattern;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *
 * 如果要代理的类未实现接口，可以借助 cglib 完成。
 * 实现原理：利用 Enhancer 构造一个类，其父类为委托类
 * @author harryper
 * @date 2021/3/15
 */
public class CGLibProxy {
    public static void main(String[] args) {
        CGLibFactory cgLibFactory = new CGLibFactory(Man.class);
        Man o = (Man) cgLibFactory.create();
        o.bath();
    }
}

class CGLibFactory implements MethodInterceptor {

    private Class target;
    public CGLibFactory() {}

    public CGLibFactory(Class target) {
        super();
        this.target = target;
    }

    public Object create() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("bath")) {
            System.out.println("洗澡之前先打马赛克");
        }
        return method.invoke(target, objects);
    }
}

class Man {

    public void eat() {
        System.out.println("girl eat...");
    }

    public void bath() {
        System.out.println("girl bath...");
    }
}




