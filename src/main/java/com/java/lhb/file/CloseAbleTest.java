package com.java.lhb.file;

import java.io.*;

/**
 * @author harryper
 * @date 2021/5/12
 */
public class CloseAbleTest {
    public static void main(String[] args) {
        File file = new File("E:\\study\\T\\we-project.iml");
        try (InputStream inputStream = new FileInputStream(file)) {
            int read;
            byte[] buf = new byte[1024];
            while ((read = inputStream.read(buf)) > 0) {
                System.out.println(new String(buf, 0, read));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
