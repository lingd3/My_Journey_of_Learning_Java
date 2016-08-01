import java.sql.*;

/*	PreparedStatement pstmt = null;
	try {
	
	//在JDBC中所有的参数都被代表？符号，这是已知的参数标记。在执行SQL语句之前，必须提供值的每一个参数。
	
	   String SQL = "Update Students SET age = ? WHERE id = ?";
	   pstmt = conn.prepareStatement(SQL);
	   . . .
	}
	
	
	//setXXX()方法将值绑定到参数，其中XXX表示希望绑定到输入参数值的 Java 数据类型。如果忘了提供值，将收到一个 SQLException。
	
	catch (SQLException e) {
	   . . .
	}
	finally {
	//同理，我们需要关闭 PreparedStatement 对象
	   pstmt.close();
	}
*/


public class test_PreparedStatement {

	//JDBC驱动器名称和数据库地址
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	//数据库的名称为 EXAMPLE
	static final String DB_URL = "jdbc:mysql://localhost/EXAMPLE";
	
	//数据库用户和密码
	static final String USER = "root";
	
	static final String PASS = "8815517"; 
		
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			//注册JDBC驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			
			//打开连接
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			//执行查询
			System.out.println("Creating statement...");
			
			//这里我们要更改一个同学的年龄，参数待定
			String sql = "UPDATE Students set age=? WHERE id=?";
			stmt = conn.prepareStatement(sql);
			
			//将值绑定到参数，参数从左至右序号为1，2...
			stmt.setInt(1, 22);  // 绑定 age 的值(序号为1)
			stmt.setInt(2, 1); // 绑定 ID 的值

			// 更新 ID 为1的同学的年龄
			int rows = stmt.executeUpdate();
			System.out.println("被影响的行数 : " + rows );

			// 查询所有记录，并显示.
			sql = "SELECT id, name, age FROM Students";
			ResultSet rs = stmt.executeQuery(sql);
			
			//处理结果集
			while (rs.next()) {
				// 检索
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String name = rs.getString("name");
				
				//显示
				System.out.print("ID: " + id);
				System.out.print(", Age: " + age);
				System.out.print(", Name: " + name);
				System.out.println();
			}
			
			//清理环境
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			//JDBC操作错误
			se.printStackTrace();
		} catch (Exception e) {
			//Class.forName错误
			e.printStackTrace();
		} finally {
			//这里一般用来关闭资源的
			try {
				if (stmt != null) stmt.close();
			} catch (SQLException se2) {
			}
			
			try {
				if (conn != null) conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
	}
}
