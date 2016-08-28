import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable {
	private String stuId;
	private String stuName;
	private transient int stuAge;//该元素不会进行jvm默认的序列化，也可以自己完成这个元素的序列化
	
	public Student() {
	}
	
	public Student(String stuId, String stuName, int stuAge) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuAge = stuAge;
	}
	
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuAge=" + stuAge + "]";
	}
	
	private void writeObject(ObjectOutputStream s) throws IOException {
		s.defaultWriteObject();//把jvm能默认序列化的元素进行序列化操作
		s.writeInt(stuAge);//自己完成stuAge的序列化
	}
	
	private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
		s.defaultReadObject();//把jvm能默认反序列化的元素进行反序列化操作
		this.stuAge = s.readInt();//自己完成stuAge的反序列化操作
	}

}
