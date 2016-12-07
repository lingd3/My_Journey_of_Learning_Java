package com.dan.hibernate.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dan.hibernate.entity.User;

public class Test {

	/*
	//增
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//获取Hibernate配置信息
		Configuration configuration = new Configuration().configure();
		//根据configuration建立sessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//开启session（相当于开启JDBC的connection）
		Session session = sessionFactory.openSession();
		//创建并开启事务对象
		session.beginTransaction();
		//新建对象，并赋值
		User user = new User(1, "admin", "admin");
		User user1 = new User(2, "user1", "123456");
		User user2 = new User(3, "user2", "helloworld");
		//保存对象
		session.save(user);
		session.save(user1);
		session.save(user2);
		//提交事务
		session.getTransaction().commit();
		//关闭session和sessionFactory
		session.close();
		sessionFactory.close();
	} */
	
	/*
	//查
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//利用StringBuilder来连接查询语句
        StringBuilder hq = new StringBuilder();

        //从User里面查找（注意from后有空格）
        //相当于 "select * from user_info;"
		hq.append("from ").append(User.class.getName());
//		System.out.println(hq.toString());
		
		//利用sess建立query
		Query query = session.createQuery(hq.toString());
		
		//序列化query的结果为一个list集合
		List<User> users = query.list();
		
		// 打印每一个User信息
        for (User user : users) {
            System.out.println(user.getId()+":"+user.getUsername());
        }
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	} 
	*/
	
	/*
	//改
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
        StringBuilder hq = new StringBuilder();

        //注意from、where的空格，":name"表示一个参数
        hq.append("from ").append(User.class.getName()).append(" where user_username=:name");
		
		//利用sess建立query
		Query query = session.createQuery(hq.toString());
		
		//设定参数name的值为"user1"
		query.setString("name", "user1");
		List<User> users = query.list();
        for (User user : users) {
        	//修改User1的密码
        	user.setPassword("123qwe");
        	//注意这里是update
        	session.update(user);
        }
		
        //或
//		User user = new User(2, "user1", "123asd");
//		session.update(user);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	} 
	*/
	
	//删
	public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        StringBuilder hq = new StringBuilder();

        //注意from、wher 的空格，":name" 表示一个参数
        hq.append("from ").append(User.class.getName()).append(" where user_username=:name");

        Query query = session.createQuery(hq.toString());

        query.setString("name","user1"); 
        List<User> users = query.list();
        for (User user : users) {
            // 注意这里是 delete
            session.delete(user);
        }

        //或
//        User user = new User();
//        user.setId(3);
//        session.delete(user);
        
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
	
}


