package com.java.lhb.anno.pojo;

import com.java.lhb.anno.Column;
import com.java.lhb.anno.Table;

/**
 * @author harryper
 * @date 2020/8/3
 */
@Table("t_user")
public class User {

    @Column(name = "t_name", length = 23)
    private String name;

    @Column(name = "t_age", length = 2)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
