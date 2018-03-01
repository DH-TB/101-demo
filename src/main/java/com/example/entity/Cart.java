package com.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart {
    @Id
    @GeneratedValue

    private Long id;
    private String name;
    //关系维护端:可以操作中间表
    // @JoinTable描述了多对多关系的数据表关系。name属性指定中间表名称，
    // joinColumns定义中间表与Cart表的外键关系。
    // 中间表t_cart_item的cartId是Cart表的主键列对应的外键列，
    // inverseJoinColumns属性定义了中间表与另外一端(Item)的外键关系。

    @ManyToMany
    @JoinTable(name = "cart_item",
            joinColumns = { @JoinColumn(name = "cart_id") },
            inverseJoinColumns = {@JoinColumn(name = "item_id") }
            )
    //自己写sql必须定义中间表

    private Set<Item> items;

    public Cart(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Cart(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
