package com.java.lhb;

/**
 * @author harryper
 * @date 2020/7/29
 * 类加载有三个阶段；
 *      1, 加载
 *          加载 .class 字节码文件到内存中，将静态文件转换成方法区的运行时数据结构；
 *          生成一个代表这个类的 java.lang.Class 对象；
 *      2，链接
 *          验证: 验证类的信息符合 JVM 规范，没有安全方面的问题；
 *          准备: 为类变量 (static) 分配内存并设置初始值，这些内存都在方法区分配；
 *          解析: 常量池内的符号引用 (常量名) 替换为直接引用 (地址);
 *      3, 初始化
 *          虚拟机调用类构造器 <clint>() 方法。该方法由编译期收集的所有 类变量赋值动作 和 静态代码块 中的语句合并产生。
 *              （类构造器是构造类的信息，不是构造类对象的构造器）
 *              并非所有的类都包含 <clint>() 方法：
 *                  1，没有类变量、没有静态代码块；
 *                  2，只声明了类变量，没有明确执行赋值操作；
 *          如果父类还未初始化，则先触发父类的初始化；
 *          保证每个类的 <client>() 方法在多线程环境中能被正确加锁和同步；
 */
public class StaticTest {

    @SuppressWarnings("all")
    public static void main(String[] args) {
        //A a = new A();
        System.out.println(A.M);
    }
}

@SuppressWarnings("all")
class A {

    static {
        System.out.println("静态代码块");
    }

    static int m;
    static final int M = 1;

    public A() {
        System.out.println("构造代码块");
    }
}
