import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class SessionTest {
	
	@Test
	public void testOpenSession() {
		//获得配置对象
		Configuration config = new Configuration().configure(); 
		//获得服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//获得sessionFactory对象
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		//获得session对象
		Session session = sessionFactory.openSession();
		if (session != null) {
			System.out.println("session创建成功！");
		}
		else {
			System.out.println("session创建失败!");
		}
	}
	
	@Test
	public void testGetCurrentSession() {
		//获得配置对象
		Configuration config = new Configuration().configure(); 
		//获得服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//获得sessionFactory对象
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		//获得session对象
		Session session = sessionFactory.getCurrentSession();
		if (session != null) {
			System.out.println("session创建成功！");
		}
		else {
			System.out.println("session创建失败!");
		}
	}
	
	@Test
	public void testSaveStudentsWithOpenSession() {
		//获得配置对象
		Configuration config = new Configuration().configure(); 
		//获得服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//获得sessionFactory对象
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		//获得session对象
		Session session1 = sessionFactory.openSession();
		//开启事务
		Transaction transaction = session1.beginTransaction();
		//生成一个学生对象
		Students s = new Students(1, "张三", "男", new Date(), "北京");
		session1.doWork(new Work() {
			
			@Override
			public void execute(Connection connection) throws SQLException {
				System.out.println("connection hashCode: " + connection.hashCode());
			}
		});
		session1.save(s);
		//session1.close();
		transaction.commit(); //提交事务
		
		Session session2 = sessionFactory.openSession();
		transaction = session2.beginTransaction();
		s = new Students(2, "李四", "男", new Date(), "上海");
		session2.doWork(new Work() {
			
			@Override
			public void execute(Connection connection) throws SQLException {
				System.out.println("connection hashCode: " + connection.hashCode());
			}
		});
		session2.save(s);
		transaction.commit();
	}
	
	@Test
	public void testSaveStudentsWithGetCurrentSession() {
		//获得配置对象
		Configuration config = new Configuration().configure(); 
		//获得服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//获得sessionFactory对象
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		//获得session对象
		Session session1 = sessionFactory.getCurrentSession();
		//开启事务
		Transaction transaction = session1.beginTransaction();
		//生成一个学生对象
		Students s = new Students(1, "张三", "男", new Date(), "北京");
		session1.doWork(new Work() {
			
			@Override
			public void execute(Connection connection) throws SQLException {
				System.out.println("connection hashCode: " + connection.hashCode());
			}
		});
		session1.save(s);
		//session1.close();
		transaction.commit(); //提交事务
		
		Session session2 = sessionFactory.getCurrentSession();
		transaction = session2.beginTransaction();
		s = new Students(2, "李四", "男", new Date(), "上海");
		session2.doWork(new Work() {
			
			@Override
			public void execute(Connection connection) throws SQLException {
				System.out.println("connection hashCode: " + connection.hashCode());
			}
		});
		session2.save(s);
		transaction.commit();
	}
	
}


















