import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/*
 * InetAddress类
 */
public class Test01 {

	public static void main(String[] args) throws UnknownHostException {
		//获取本机的InetAddress实例
		 InetAddress address = InetAddress.getLocalHost();
		 System.out.println("计算机名：" + address.getHostName());
		 System.out.println("IP地址：" + address.getHostAddress());
		 
		 //获取字节数组形式的IP地址
		 byte[] bytes = address.getAddress();
		 System.out.println("字节数组形式的IP地址：" + Arrays.toString(bytes));
		 //直接输出InetAddress对象
		 System.out.println(address);
		 
		 //根据机器名获取InetAddress实例
		 InetAddress address2 = InetAddress.getByName("gddeMacBook-Air.local");
//		 InetAddress address2 = InetAddress.getByName("192.168.0.101");
		 System.out.println("计算机名：" + address2.getHostName());
		 System.out.println("IP地址：" + address2.getHostAddress());
	}

}









