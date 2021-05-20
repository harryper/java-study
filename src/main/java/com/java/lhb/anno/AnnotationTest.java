package com.java.lhb.anno;

import com.java.lhb.anno.pojo.User;

import java.lang.reflect.Field;

/**
 * @author harryper
 * @date 2020/8/3
 */
public class AnnotationTest {

    public static void main(String[] args) throws NoSuchFieldException {
        Class<User> userClass = User.class;

        Table annotation = userClass.getAnnotation(Table.class);
        System.out.println(" 获取类注解值 = " + annotation.value());

        Field name = userClass.getDeclaredField("age");
        Column annotation1 = name.getAnnotation(Column.class);
        System.out.println(" 获取属性注解值 name = " + annotation1.name() + "-----length = " + annotation1.length());

    }
}
