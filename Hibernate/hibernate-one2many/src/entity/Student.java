package entity;

import java.io.Serializable;

public class Student implements Serializable {
	private int sid;
	private String sname;
	private String sex;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Student() {
		super();
	}

	public Student(String sname, String sex) {
		super();
		this.sname = sname;
		this.sex = sex;
	}

}
