package com.dan.hibernate.entity;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class Test {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        
        //1.普通查询
        Query q = session.createQuery(" from User u");
        
        //2.条件查询
//        Query q = session.createQuery(" from User u where u.username = ?");
//        q.setParameter(0, "Jack");
        
        //3.原生SQL查询
//        SQLQuery q = session.createSQLQuery("select * from user_info").addEntity(User.class);
        
        //4.criteria查询
//        Criteria q = session.createCriteria(User.class);
//        Criterion cc = Restrictions.between("id", 1, 3);
//        Criterion cc1 =  Restrictions.idEq(2);
//        q.add(cc);
//        q.add(cc1);
        
        List<User> list = q.list();
        for (User e : list) {
            System.out.println(e.getUsername() + ", password: " + e.getPassword());
        }

        session.getTransaction().commit();
        session.close();
        sf.close();
	}
	
}
