package collection_map;

import java.util.HashSet;
import java.util.Set;

/**
 * 学生类
 * @author gd
 *
 */
public class Student {
	public String id;
	public String name;
	public Set courses;
	
	public Student(String id, String name) {
		this.id = id;
		this.name = name;
		this.courses = new HashSet();
	}
}
