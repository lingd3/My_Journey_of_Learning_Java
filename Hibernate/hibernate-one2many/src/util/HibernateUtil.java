package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	private static Session session;
	
	static {
		//创建Configuration对象，读取hibernate.cfg.xml文件，完成初始化
		Configuration config = new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//创建会话工厂对象
		sessionFactory = config.buildSessionFactory(sr);
	}
	
	//获取SessionFactory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	//获取Session
	public static Session getSession() {
		session = sessionFactory.openSession();
		return session;
	}
	
	//关闭Session
	public static void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}
}
















