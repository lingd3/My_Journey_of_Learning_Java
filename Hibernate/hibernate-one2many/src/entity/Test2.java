package entity;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

/*
 * 单向多对一（学生 --> 班级）
 */
public class Test2 {
	public static void main(String[] args) {
//		save();
		findGradeByStudent();
	}
	
	//保存
	public static void save() {
		Grade g = new Grade("c", "language");
		Student stu1 = new Student("Gordan", "man");
		Student stu2 = new Student("linqiao", "women");
		//设置关联信息
		g.getStudents().add(stu1);
		g.getStudents().add(stu2);
		stu1.setGrade(g); //级联操作
		stu2.setGrade(g);
		
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(g);
//		session.save(stu1);
//		session.save(stu2);
		transaction.commit();
		HibernateUtil.closeSession(session);
	}
	
	//查询学所在班级信息
	public static void findGradeByStudent() {
		Session session = HibernateUtil.getSession();
		Student stu = (Student)session.get(Student.class, 5);
		System.out.println(stu.getSid()+","+stu.getSname()+","+stu.getSex());
		Grade g = stu.getGrade();
		System.out.println(g.getGid()+","+g.getGname()+","+g.getGdesc());
		HibernateUtil.closeSession(session);
	}

}
