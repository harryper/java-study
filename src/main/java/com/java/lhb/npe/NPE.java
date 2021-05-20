package com.java.lhb.npe;

/**
 * @author harryper
 * @date 2020/9/15
 */
public class NPE {


    public static void main(String[] args) {
        npe(sql());
    }




    // 数据库返回的结果，可能为 null, 如果用 int 接收会发生 NPE 异常，所以 pojo 类基本数据类型要用包装类
    public static Integer sql() {
        return null;
    }
    public static void npe(Integer a) {
        System.out.println("a = " + a);
    }
}
