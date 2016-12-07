package com.dan.hibernate.many2one.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dan.hibernate.many2one.entity.Group;
import com.dan.hibernate.many2one.entity.User;

public class UserTest {

	public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Group group = new Group();
        group.setGroupname("LOL_Group");

        User user1 = new User();
        user1.setUsername("Levis");
        user1.setPassword("111");

        User user2 = new User();
        user2.setUsername("Lee");
        user2.setPassword("222");

        // 设置多个用户都对应该群组（多对一）
        user1.setGroup(group);
        user2.setGroup(group);

        // 保存相关对象
        session.save(user1);
        session.save(user2);
        session.save(group);

        session.getTransaction().commit();
        session.close();
        sf.close(); 
	}
}
