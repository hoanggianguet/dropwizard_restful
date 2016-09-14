package com.gianghoang.core;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by MinhTu on 8/15/2016.
 */
@Entity
@Table(name = "persons")
@NamedQueries({
        @NamedQuery(name = "com.gianghoang.Person.findAll",
                query = "select e from Person e"),
})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int age;
    private String sex;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age, String sex, Date birthday) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
    }

    public Person() {
    }
}
