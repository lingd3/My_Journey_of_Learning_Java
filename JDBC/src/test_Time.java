
public class test_Time {

	public static void main(String[] args) {
		//获取日期和时间
		//为了和下面SQL的日期做对比所以直接写明是java.util.Date
		//我们也可以引入java.util.Date包，然后声明为Date类
		java.util.Date javaDate = new java.util.Date();
		long javaTime = javaDate.getTime();
		System.out.println("The Java Date is: " + javaDate.toString());
		
		//获取SQL的日期
		java.sql.Date sqlDate = new java.sql.Date(javaTime);
		System.out.println("The SQL DATE is: " + sqlDate.toString());
		
		//获取SQL的时间
		java.sql.Time sqlTime = new java.sql.Time(javaTime);
		System.out.println("The SQL TIME is: " + sqlTime.toString());

		//获取SQL的时间戳
		java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(javaTime);
		System.out.println("The SQL TIMESTAMP is: " + sqlTimestamp.toString());
	}
}
