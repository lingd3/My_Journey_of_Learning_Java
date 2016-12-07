package com.dan.hibernate.ejb3;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test {

	/*
	//增
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		User user = new User(1, "admin", "admin");
		User user1 = new User(2, "user1", "123456");
		User user2 = new User(3, "user2", "helloworld");
		session.save(user);
		session.save(user1);
		session.save(user2);

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
	*/
	
	/*
	//查
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
        StringBuilder hq = new StringBuilder();
		hq.append("from ").append(User.class.getName());
		Query query = session.createQuery(hq.toString());
		
		List<User> users = query.list();
		
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
		
//        StringBuilder hq = new StringBuilder();
//        hq.append("from ").append(User.class.getName()).append(" where username=:name");
//		Query query = session.createQuery(hq.toString());
//		
//		//设定参数name的值为"user1"
//		query.setString("name", "user1");
//		List<User> users = query.list();
//        for (User user : users) {
//        	user.setPassword("123qwe");
//        	session.update(user);
//        }
		
        //或
		User user = new User(2, "user1", "123asd");
		session.update(user);
		
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
        hq.append("from ").append(User.class.getName()).append(" where username=:name");
        Query query = session.createQuery(hq.toString());
        query.setString("name","user1"); 
        List<User> users = query.list();
        for (User user : users) {
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


