package com.zrzy.dao;

import com.zrzy.entity.Book;
import org.hibernate.LobHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: 徐大伟
 * User: ${和敬清寂}
 * Date: 2019/4/8
 * Time: 17:57
 */
public class BookDao {

    private static Session session=null;
    private static SessionFactory sessionFactory=null;
    private static Transaction transaction=null;
    public static void main(String[] args) throws Exception {

        //获取sessionFactory工厂

        sessionFactory = HibernateUtil.getSessionFactory();

        //获取session
        session = sessionFactory.openSession();

        //开启事物
        transaction = session.beginTransaction();


        System.out.println("------------");


        add();
    }

    private static void add() throws Exception {
        Book book = new Book();
        book.setId(1);
        book.setName("后来的我们");
        book.setPrice(99.9f); //设置价格
        book.setPulishDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-4-8 19:07:01"));

        // 提供LobHelper解析
        LobHelper lobHelper = session.getLobHelper();

        InputStream inputStream = new FileInputStream("E:\\angal.mig\\angal.jpg"); // 放入图片
        book.setBookImage(lobHelper.createBlob(inputStream,inputStream.available()));

        session.save(book);
        // 事物提交
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}

