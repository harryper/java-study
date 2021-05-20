package com.lhb.reflection;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Class 本身是一个类，它用来记录各 .class 文件的信息，如方法、父类、实现的接口等等；每一个类都有且仅有一个 Class 对象；
 * @author harryper
 * @date 2020/7/29
 */
@SuppressWarnings("all")
public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        /**
         * 有四种方式可以获得 Class 对象
         */
        Student student = new Student();

        // 1, 通过 Class.forName("类的全路径") 获取;
        Class<?> aClass = Class.forName("com.lhb.reflection.Student");

        // 2, 通过 Object 提供的 getClass() 获取;
        Class<? extends Student> aClass1 = student.getClass();

        // 3, 通过类名直接获取;
        Class<Student> studentClass = Student.class;

        // 4, 基本类型包装类有 TYPE 属性可以获取
        Class<Integer> type = Integer.TYPE;

        /**
         * 以下各类型可以获取 Class 对象
         */
        // 类
        Class<Object> objectClass = Object.class;
        // 接口
        Class<Comparable> comparableClass = Comparable.class;
        // 枚举
        Class<ElementType> elementTypeClass = ElementType.class;
        // 注解
        Class<Override> overrideClass = Override.class;
        // 基本数据类型
        Class<Integer> integerClass = int.class;
        // void
        Class<Void> voidClass = void.class;
        // 一维数组
        Class<int[]> aClass2 = int[].class;
        // 二位数组
        Class<int[][]> aClass3 = int[][].class;


        Class cl = Class.forName("com.lhb.reflection.Person");

        System.out.println("=========获取本类以及父类的 public 属性=============");
        Field[] fields = cl.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("=========仅仅获取本类的所有属性===========");
        fields = cl.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("=========仅仅获取本类的所有方法===========");
        Method[] declaredMethods = cl.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        System.out.println("=========仅仅获取本类的构造器===========");
        Constructor[] declaredConstructors = cl.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        System.out.println("=========仅仅获取本类指定的构造器===========");
        Constructor declaredConstructor = cl.getDeclaredConstructor(String.class);
        System.out.println(declaredConstructor);

        System.out.println("=========动态获取对象，无参构造器===========");
        Person person = (Person)cl.newInstance();
        System.out.println(person.getGender());

        System.out.println("=========动态获取对象，有参构造器===========");
        Constructor declaredConstructor1 = cl.getDeclaredConstructor(String.class);
        Object kenan = declaredConstructor1.newInstance("kenan");
        System.out.println(kenan);


        System.out.println("=========通过反射操作方法===========");
        Constructor declaredConstructor2 = cl.getDeclaredConstructor();
        Person per = (Person)declaredConstructor2.newInstance();

        Method setAge = cl.getDeclaredMethod("setAge", Integer.class);
        setAge.invoke(per, 23);
        System.out.println(per.getAge());

        System.out.println("=========通过反射操作属性===========");
        Field gender = cl.getDeclaredField("gender");

        gender.setAccessible(true);// 不能直接访问私有属性，需要打开可访问性；
        gender.set(per, "女");
        System.out.println(per.getGender());

    }
}

class  Person {
    public String name ;
    protected Integer age;
    private String gender;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}


class Teacher extends Person {
    public Teacher() {
        this.name = "老师";
    }
}

class Student extends Person {
    public Student() {
        this.name = "学生";
    }
}


