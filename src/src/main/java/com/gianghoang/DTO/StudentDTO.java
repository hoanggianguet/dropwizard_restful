package com.gianghoang.DTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by MinhTu on 8/16/2016.
 */
public class StudentDTO {

    private BigDecimal salary;
    private String name;
    private Date birthday;
    private Date deadline;

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

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

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
