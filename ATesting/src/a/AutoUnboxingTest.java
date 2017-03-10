package a;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;

public class AutoUnboxingTest {
	public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = 3;                  // 将3自动装箱成Integer类型
        int c = 3;
        System.out.println(a == b);     // false 两个引用没有引用同一对象
        System.out.println(a == c);     // true a自动拆箱成int类型再和c比较
        System.out.println(c == a);
        
        int[] z = new int[10];
        System.out.println(z.length);
        String zz = "asdads";
        System.out.println(zz.length());
        
        A:
        for( int i = 0; i < 5; i++) {
        	for (int j = 0; j < 5; j++) {
        		System.out.println(i + " " + j);
        	}
        	break A;
        }
        
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
        
        char aaa = '你';
        System.out.println(aaa);
        
//        String q = "123.21";
//        int qq = Integer.parseInt(q);
//        double qq = Double.valueOf(q);
//        int q = 123;
//        String qq = String.valueOf(q);
//        System.out.println(qq);
        String q = "ÄãºÃ";
        try {
			String qq = new String(q.getBytes("ISO-8859-1"), "GB2312");
			System.out.println(qq);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH));    // 0 - 11
        System.out.println(cal.get(Calendar.DATE));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));
        System.out.println(cal.getTimeInMillis());
        System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        
        final int op;
        op = 1;
        System.out.println(op);
        
	}
}










