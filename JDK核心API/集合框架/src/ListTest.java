import java.util.*;
/*
 * 管理学生类
 */

public class ListTest {
	
	/*
	 * 用于存放学生的List
	 */
	public List students;
	
	public ListTest() {
		this.students = new ArrayList();
	}
	
	/*
	 * 用于往students中添加学生
	 */
	public void testAdd() {
		//创建一个学生对象，并通过调用add方法，添加到学生管理List中
		Student st1 = new Student("1", "张三");
		students.add(st1);
		
		//添加到List中的类型均为Object,所以取出时还需要强转
		Student temp = (Student)students.get(0);
		System.out.println("添加了学生： " + temp.id + ":" + temp.name);
		
		Student st2 = new Student("2", "李四");
		students.add(0, st2);
		Student temp2 = (Student)students.get(0);
		System.out.println("添加了学生： " + temp2.id + ":" + temp2.name);

        Student[] student = {new Student("3", "王五"),new Student("4", "马六")};
        students.addAll(Arrays.asList(student));
        Student temp3 = (Student)students.get(2);
        Student temp4 = (Student)students.get(3);
        System.out.println("添加了学生：" + temp3.id + ":" +temp3.name);
        System.out.println("添加了学生：" + temp4.id + ":" +temp4.name);
        Student[] student2 = {new Student("5", "周七"),new Student("6", "赵八")};
        students.addAll(2,Arrays.asList(student2));
        Student temp5 = (Student)students.get(2);
        Student temp6 = (Student)students.get(3);
        System.out.println("添加了学生：" + temp5.id + ":" +temp5.name);
        System.out.println("添加了学生：" + temp6.id + ":" +temp6.name);
        
	}
	
	/*
	 *  取得List中的元素的方法
	 */
	public void testGet() {
        int size = students.size();
        for(int i = 0;i<size;i++){
            Student st = (Student)students.get(i);
            System.out.println("学生：" + st.id+":"+ st.name);

        }	
	}
	
    /*
     * 通过迭代器来遍历
     */
    public void testIterator() {
        //通过集合的iterator方法，取得迭代器实例
        Iterator it = students.iterator();
        System.out.println("有如下学生（通过迭代器访问）：");
        while(it.hasNext()){

            Student st = (Student)it.next();
            System.out.println("学生" + st.id + ":" +st.name);
        }
    }

    /*
     * 通过for each 方法访问集合元素
     */
    public void testForEach() {
        System.out.println("有如下学生（通过for each）：");
        for(Object obj:students){
            Student st = (Student)obj;
            System.out.println("学生：" + st.id + ":" + st.name);
        }
    }

    /*
     * 修改List中的元素
     */
    public void testModify(){
        students.set(4,new Student("3","吴酒"));
    }

    /*
     * 删除List中的元素
     */
    public void  testRemove() {
        Student st = (Student)students.get(4);
        System.out.println("我是学生：" + st.id + ":" + st.name + "，我即将被删除");
        students.remove(st);
        System.out.println("成功删除学生！");
        testForEach();

    }

    public static void main(String[] args) {
        ListTest lt =  new ListTest();
        lt.testAdd();
        lt.testGet();
        lt.testIterator();
        lt.testModify();
        lt.testForEach();
        lt.testRemove();

    }

}
