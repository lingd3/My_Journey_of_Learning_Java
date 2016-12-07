package entity;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

/*
 * 单向一对多关系映射(班级-->学生)
 */
public class Test {
	public static void main(String[] args) {
		add();
	}
	
	//将学生添加到班级
	public static void add() {
		Grade g = new Grade("Java一班", "Java软件开发一班");
		Student stu1 = new Student("张三", "男");
		Student stu2 = new Student("小丽", "女");
		
		//如果希望在学生表中添加对应的班级编号，需要在班级中添加学生，建立关联关系
		g.getStudents().add(stu1);
		g.getStudents().add(stu2);
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(g);
		session.save(stu1);
		session.save(stu2);
		tx.commit();
		HibernateUtil.closeSession(session);
	}
}












