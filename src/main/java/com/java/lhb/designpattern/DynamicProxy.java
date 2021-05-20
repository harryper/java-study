package com.java.lhb.designpattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 有点：可复用性强
 * @author harryper
 * @date 2021/3/13
 */
public class DynamicProxy {

    public static void main(String[] args) {

        Girl girl = new DynamicProxy().new Girl();
        Human human = (Human) Proxy.newProxyInstance(Girl.class.getClassLoader(), Girl.class.getInterfaces(), (proxy, method, arg)-> {

                if ("bath".equals(method.getName())) {
                    System.out.println("调用 bath 方法前先打马赛克...");
                }
                return method.invoke(girl, arg);
        });
        human.eat();
        System.out.println("--------");
        human.bath();
    }

    /**
     * test 和 test 2 为扩展知识。
     *  外部类的非静态方法创建内部类对象时，因为有隐式的 this 对象，所以表明已创建了外部类对象，不报错；
     *  外部类的静态方法调用时，没有隐式的 this 对象，外部类可能还未创建对象，所以不通过。
     */
    public void test() {
        Girl girl = new Girl();
    }
    public static void test2() {
       // Girl g = new Girl(); 报错
    }

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



    class LogHandler implements InvocationHandler {

        // 目标对象
        private Object targetObject;
        //绑定关系，也就是关联到哪个接口（与具体的实现类绑定）的哪些方法将被调用时，执行invoke方法。
        public Object newProxyInstance(Object targetObject){
            this.targetObject=targetObject;
            //该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
            //第一个参数指定产生代理对象的类加载器，需要将其指定为和目标对象同一个类加载器
            //第二个参数要实现和目标对象一样的接口，所以只需要拿到目标对象的实现接口
            //第三个参数表明这些被拦截的方法在被拦截时需要执行哪个InvocationHandler的invoke方法
            //根据传入的目标返回一个代理对象
            return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                    targetObject.getClass().getInterfaces(),this);
        }
        @Override
        //关联的这个实现类的方法被调用时将被执行
        /*InvocationHandler接口的方法，proxy表示代理，method表示原对象被调用的方法，args表示方法的参数*/
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
            System.out.println("start-->>");
            for(int i=0;i<args.length;i++){
                System.out.println(args[i]);
            }
            Object ret=null;
            try{
                /*原对象方法调用前处理日志信息*/
                System.out.println("satrt-->>");

                //调用目标方法
                ret=method.invoke(targetObject, args);
                /*原对象方法调用后处理日志信息*/
                System.out.println("success-->>");
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("error-->>");
                throw e;
            }
            return ret;
        }

    }
}
