package com.java.lhb.thread;

import java.text.SimpleDateFormat;
import java.time.Instant;

/**
 * @author harryper
 * @date 2020/9/15
 */
public class InstantTest {
    public static void main(String[] args) {
        Instant epoch = Instant.now();
        System.out.println("epoch.toString() === " + epoch.toString());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    }

}
