package com.gianghoang.core;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by MinhTu on 8/16/2016.
 */
@Entity
@Table(name = "students")
@NamedQueries({
        @NamedQuery(name = "com.gianghoang.Student.findAll",
                query = "select e from Student e"),
})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private BigDecimal salary;
    @Column(length = 1024, name ="Name")
    private String name;
    private Date birthday;
    private Date deadline;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Student() {
    }

    public Student(BigDecimal salary, String name, Date birthday, Date deadline) {
        this.salary = salary;
        this.name = name;
        this.birthday = birthday;
        this.deadline = deadline;
    }
}
