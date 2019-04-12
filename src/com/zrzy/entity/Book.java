package com.zrzy.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: 徐大伟
 * User: ${和敬清寂}
 * Date: 2019/4/8
 * Time: 17:48
 */
@Entity
@Table(name="Book")
public class Book {

    private Integer id;
    private String name;
    private Date pulishDate; // 发布日期
    private float price; // 价钱
    private Blob bookImage; //图片

    @Id
    @GenericGenerator(name = "_native",strategy = "native")
    @GeneratedValue(generator = "native")
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "pulish_date")
    public Date getPulishDate() {
        return pulishDate;
    }

    public void setPulishDate(Date pulishDate) {
        this.pulishDate = pulishDate;
    }

    @Column
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Column(name = "book_img")
    public Blob getBookImage() {
        return bookImage;
    }

    public void setBookImage(Blob bookImage) {
        this.bookImage = bookImage;
    }

    public Book() {
    }

    public Book(Integer id, String name, Date pulishDate, float price, Blob bookImage) {
        this.id = id;
        this.name = name;
        this.pulishDate = pulishDate;
        this.price = price;
        this.bookImage = bookImage;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pulishDate=" + pulishDate +
                ", price=" + price +
                ", bookImage=" + bookImage +
                '}';
    }
}
