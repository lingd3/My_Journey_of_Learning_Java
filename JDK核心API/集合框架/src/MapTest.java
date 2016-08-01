import java.util.*;
import java.util.Map.Entry;

public class MapTest {

	/*
	 * 用来乘装课程类型对象
	 */
	public Map<String, Course> courses;
	
	/*
	 * 在构造器中初始化courses属性
	 */
	public MapTest() {
		this.courses = new HashMap<String, Course>();
	}
	
	/*
	 * 测试添加：输入课程ID，判断是否被占用
	 * 若未被占用，输入课程名称，创建新课程对象，并且添加到courses中
	 */
	public void testPut() {
		//创建一个Scanner对象，用来获取输入的课程ID
		Scanner console = new Scanner(System.in);
		
		for (int i = 0; i < 3; i++) {
			System.out.println("请输入课程ID： ");
			String ID = console.next();
			//判断该ID是否被占用
			Course cr = courses.get(ID);
			if (cr == null) {
				//提示输入课程名称
				System.out.println("请输入课程名称：");
				String name = console.next();
				//创建新的课程对象
				Course newCourse = new Course(ID, name);
				//通过调用courses的put方法，添加ID-课程映射
				courses.put(ID, newCourse);
				System.out.println("成功添加课程：" + courses.get(ID).name);
			}
			else {
				System.out.println("该课程 ID 已被占用");
				continue;
			}
		}
	}
	
	/*
	 * 测试Map的keySet方法
	 */
	public void testKeySet() {
		//通过keySet方法，返回Map中的所有键的Set集合
		Set<String> keySet = courses.keySet();
		//遍历keySet，取得每一个建，再调用get方法取得每个键对应的value
		for (String crID: keySet) {
			Course cr = courses.get(crID);
			if (cr != null) {
				System.out.println("课程：" + cr.name);
			}
		}
	}
	
    /*
     * 测试删除 Map 中的映射
     */
    public void testRemove() {
        //获取从键盘输入的待删除课程 ID 字符串
        Scanner console = new Scanner(System.in);
        while(true){
            //提示输出待删除的课程 ID
            System.out.println("请输入要删除的课程 ID: ");
            String ID = console.next();
            //判断该 ID 是否对应的课程对象
            Course cr = courses.get(ID);
            if(cr == null) {
                //提示输入的 ID 并不存在
                System.out.println("该 ID 不存在！");
                continue;
            }
            courses.remove(ID);
            System.out.println("成功删除课程" + cr.name);
            break;
        }
    }

    /*
     * 通过 entrySet 方法来遍历 Map
     */
    public void testEntrySet() {
        //通过 entrySet 方法，返回 Map 中的所有键值对
        Set<Entry<String,Course>> entrySet = courses.entrySet();
        for(Entry<String,Course> entry: entrySet) {
            System.out.println("取得键：" + entry.getKey());
            System.out.println("对应的值为：" + entry.getValue().name);
        }
    }

    /*
     * 利用 put 方法修改Map 中的已有映射
     */
    public void testModify(){
        //提示输入要修改的课程 ID
        System.out.println("请输入要修改的课程 ID：");
        //创建一个 Scanner 对象，去获取从键盘上输入的课程 ID 字符串
        Scanner console = new Scanner(System.in);
        while(true) {
            //取得从键盘输入的课程 ID
            String crID = console.next();
            //从 courses 中查找该课程 ID 对应的对象
            Course course = courses.get(crID);
            if(course == null) {
                System.out.println("该 ID 不存在！请重新输入！");
                continue;
            }
            //提示当前对应的课程对象的名称
            System.out.println("当前该课程 ID，所对应的课程为：" + course.name);
            //提示输入新的课程名称，来修改已有的映射
            System.out.println("请输入新的课程名称：");
            String name = console.next();
            Course newCourse = new Course(crID,name);
            courses.put(crID, newCourse);
            System.out.println("修改成功！");
            break;
        }
    }

    public static void main(String[] args) {
        MapTest mt = new MapTest();
        mt.testPut();
        mt.testKeySet();
        mt.testRemove();
        mt.testModify();
        mt.testEntrySet();

    }
}
