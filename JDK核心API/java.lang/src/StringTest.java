
public class StringTest {

	public static void main(String[] args) {
        String s = new String("Java");
        String m = "java";
        System.out.println("用equals()比较，java和Java结果为"+s.equals(m));
        System.out.println("用equalsIgnoreCase()比较，java和Java结果为"+s.equalsIgnoreCase(m));

        //定义和初始化一个StringBuffer类的字串s
        StringBuffer s1 = new StringBuffer("I");
        //在s后面添加字串" java"
        s1.append(" java");
        //在s[1]的位置插入字串
        s1.insert(1, " love");
        String t = s1.toString(); //转为字符串
        System.out.println(t);
	}

}
