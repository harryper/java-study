package com.lhb.file;

import java.io.File;
import java.io.IOException;

/**
 * @author harryper
 * @date 2020/8/14
 */
public class FileTest {

    public static void main(String[] args) throws IOException {
        testMk();
    }
    /**
     * File 类包含四个常量
     * constant             windows     linux
     *
     * pathSeparator        ;           :
     * pathSeparatorChar    ;           :
     * separator            \           /
     * separatorChar        \           /
     */
    @SuppressWarnings("unused")
    public static void constantTest() {
        System.out.println("pathSeparator = " + File.pathSeparator);
        System.out.println("pathSeparatorChar = " + File.pathSeparatorChar);
        System.out.println("separator = " + File.separator);
        System.out.println("separatorChar = " + File.separatorChar);
    }

    /**
     * File 类包含四个构造方法，传入路径无论存在与否都不会报异常。
     *
     * File(File parent, String child)
     * File(String pathname)                // 可传路径或文件
     * File(String parent, String child)
     * File(URI uri)
     */
    @SuppressWarnings("unused")
    private static void fileTest() {
        File pathname = new File("E:\\study\\java-study\\src\\com\\lhb\\file");
        System.out.println("pathname = " + pathname);

        File pathParentStringChild = new File(pathname, "child");
        System.out.println("pathParentStringChild = " + pathParentStringChild);

        File stringParentStringChild = new File("", "");
        System.out.println("stringParentStringChild = " + stringParentStringChild);

        File uriPath = new File("https://qa.crpower.com.cn/qa/getObj/qa-pro-n/2019/11/34d1cb80009f46bbbcc0b5694377be29.png");
        System.out.println("uriPath = " + uriPath);
    }

    public static void testMk() throws IOException {
        File file = new File("E:\\study\\java-study\\src\\com\\lhb\\file\\Test.java");
        if (!file.exists()) {
            boolean bool = file.createNewFile();// 创建
            System.out.println("bool = " + bool);
        }

        File dirFile = new File("E:\\study\\java-study\\src\\com\\lhb\\file\\aa\\bb\\cc");
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
    }
}
