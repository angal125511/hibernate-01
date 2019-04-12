package com.zrzy.dao;

import com.zrzy.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: 徐大伟
 * User: ${和敬清寂}
 * Date: 2019/4/8
 * Time: 17:58
 */
public class JunitTest { //测试StudentDao添加

    private SessionFactory sessionFactory;
    private Session session=null;

    @Before
    public void Tobefore(){ //之前
        System.out.println("提交之前-----");
        // 获取sessionFactory工厂
        sessionFactory = HibernateUtil.getSessionFactory();

        // 获取seesion
        session = sessionFactory.openSession();
        session.beginTransaction(); //开启事物

    }

    @After
    public void Toafter(){ //之后
        System.out.println("提交之后-----");
        session.getTransaction().commit();//事物提交
        session.close();
        sessionFactory.close();
    }

    @Test
    public void add(){ //添加
        Student student = new Student();
        student.setName("诗颖");
        student.setAge(22);

        session.save(student);
    }

    @Test
    public void update(){ //修改

        Student student = session.get(Student.class,1);
        student.setName("shiying");
        student.setAge(22);

        session.save(student);
    }

    @Test
    public void delete(){ //删除

        Student student = session.get(Student.class,2);
        if(student!=null){
            session.delete(student);
        }

    }

    @Test
    public void query(){ //查询

        String hql = "from Student"; // hql语句

        Query query = session.createQuery(hql); // 放入hql

        List<Student> list = query.list();
        for (Student s:list
             ) {
            System.out.println(s);
            
        }
    }

}

