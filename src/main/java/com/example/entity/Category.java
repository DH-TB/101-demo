package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue

    private Long id;
    private String name;

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {

    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private List<Item> itemList;


//    @OneToOne(cascade = CascadeType.ALL)//City是关系的维护端
//    @JoinTable(name = "item_category", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
//    //通过关联表来保存一对一的关系。
//    //定义了一张叫"city_mayor"的表,
//    //joinColumns定义一个外键叫"city_id"，指向关系维护端City的主键
//    //inverseJoinColumns定义了一个外键叫"mayor_id",指向关系被维护端Mayor的主键
//    private Item item;


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

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
