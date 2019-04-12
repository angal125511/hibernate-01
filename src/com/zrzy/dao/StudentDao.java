package com.zrzy.dao;

import com.zrzy.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: 徐大伟
 * User: ${和敬清寂}
 * Date: 2019/4/8
 * Time: 17:57
 */
public class StudentDao {

    public static void main(String[] args) {

        // 注册服务
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        // 获取sessionFactory
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        // 获取session
        Session session = sessionFactory.openSession();

        // 开启事物
        session.beginTransaction();

        Student student = new Student();
        student.setName("张杰");
        student.setAge(25);

        session.save(student); //添加
        session.getTransaction().commit(); // 获取事物并提交

        session.close(); // 关闭session
    }


}
