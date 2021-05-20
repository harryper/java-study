package com.java.lhb.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author harryper
 * @date 2020/9/14
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap();
        map.put("1", "11");
        map.put("2", "22");
        map.put("3", "33");
        map.put("4", "44");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println("next.getKey() = " + next.getKey() + ";;;next.getValue() = " + next.getValue());
        }
    }

}
