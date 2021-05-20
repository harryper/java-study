package com.java.lhb.jvm;
/**
 * Java 一种有三种类加载器，从上到下依次为
 *      启动类加载器(Bootstrap ClassLoader) 加载 jvm 运行必须的类，java的基础类
 *      扩展类加载器(ExtClassLoader) 加载 ext 目录的一些类
 *      应用类加载器(AppClassLoader) 加载用户类
 *
 *      双亲委派模型：当一个 .class 文件需要被加载时，会通过判断、加载两个阶段完成。
 *            判断阶段：从下向上依次进行，首先应用类加载器判断是否已经加载过该 class 文件，如果已加载，则返回；
 *                      如过未加载，扩展类加载器会判断是否已加载该 class 文件，如果已加载，则返回；
 *                      如果未加载，启动类加载器会判断是否已加载该 class 文件，如果已加载，则返回；
 *                      如果未加载，会进入加载阶段。
 *            加载阶段：从上向下依次进行，首先启动类加载器会判断能否加载该 class 文件，如果能则加载并返回；
 *                      如果不能，扩展类加载器会判断能否加载该 class 文件，如果能则加载并返回；
 *                      如果不能，应用类加载器会判断能否加载该 class 文件，如果能则加载并返回；
 *                      如果不能，则抛出 ClassNotFoundException 或 NoClassDefFoundError
 *
 *      优点：避免类被重复加载，避免 java 核心类被篡改
 * @author harryper
 * @date 2021年3月16日
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException {
        // 其实还有自定义类加载器

        // 应用类加载器，加载用户类
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("首先应用类加载器: " + systemClassLoader);

        // 扩展类加载器，加载扩展包
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println("其次扩展类加载器: " + extClassLoader);

        // 引导类加载器，加载核心包，该类用 C/C++实现，无法获取。
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println("核心类加载器: " + bootstrapClassLoader);


        // 获取当前类的类加载器
        ClassLoader classLoader = Class.forName("com.lhb.jvm.ClassLoaderTest").getClassLoader();
        System.out.println("用户类加载器为: " + classLoader);

        // 核心类的类加载器
        ClassLoader classLoader1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println("基础类加载器为: " + classLoader1);

        System.out.println("java.class.path = " + System.getProperty("java.class.path"));
    }
}
