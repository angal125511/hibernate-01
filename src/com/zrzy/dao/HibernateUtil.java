package com.zrzy.dao;

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
 * Time: 17:58
 */
public class HibernateUtil {
    public static SessionFactory getSessionFactory; //封装Jdbc

    private static SessionFactory sessionFactory=null;

    // 注册服务
    static {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        // 获取sessionFactory
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();


    }

    public static SessionFactory getSessionFactory(){
        return  sessionFactory;
    }

}
