package com.itheima.doamin;

import java.io.Serializable;

/**
 * @author: mingjian
 * @create: 2020-01-04 12:01
 * 账户的实体类
 */
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Float money;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getMoney() {
        return money;
    }
}
