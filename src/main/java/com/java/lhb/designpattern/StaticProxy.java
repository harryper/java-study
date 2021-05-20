package com.java.lhb.designpattern;

/**
 * 代理模式，限制对某一对象的直接访问。
 *  实现原理：委托类和代理类实现同一接口，客户端调用时传必要的参数就行
 *
 *  优点：保护了真实对象，解耦
 *  缺点：代码冗余，代理类和委托类都要实现同样方法，造成了大量代码重复；如果接口中新增方法时，所有类都要实现，造成维护困难。
 *        每个代理类只能服务同一类对象。
 * @author harryper
 * @date 2021/3/13
 */
public class StaticProxy {
    /**
     * 模拟客户端调用
     * @param args
     */
    public static void main(String[] args) {
        //这里 new Girl() 暴露了真实的对象，只为演示使用，在真实环境中可以中工厂方式生产，避免对客户端可见。
        Human human = new GirlProxy(new Girl());
        human.eat();
        System.out.println("------------");
        human.bath();
    }

}


/**
 * 顶层接口
 */
interface Human {
    /**
     * 吃饭
     */
    void eat();

    /**
     * 洗澡
     */
    void bath();
}

/**
 * 对于 girl 类来说，eat 方法尚可被外界看见，bath 不可，
 * 所以需要第三方代理限制一下，避免直接查看到 bath 方法。
 */
class Girl implements Human {

    @Override
    public void eat() {
        System.out.println("girl eat...");
    }

    @Override
    public void bath() {
        System.out.println("girl bath...");
    }
}

class GirlProxy implements Human {
    private Human human;

    public GirlProxy() {
        super();
    }

    public GirlProxy(Human human) {
        super();
        this.human = human;
    }

    @Override
    public void eat() {
        System.out.println("eat 方法随便调用...");
        human.eat();
    }

    @Override
    public void bath() {
        System.out.println("bath 方法先打马赛克...");
        human.bath();
    }
}