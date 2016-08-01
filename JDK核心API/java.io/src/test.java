import java.io.*;

public class test {

	/*
	 * 把输入流中的所有内容赋值到输出流中
	 */
	public void copy(InputStream in, OutputStream out) throws IOException {
		byte[] buf = new byte[4096];
		int len = in.read(buf);
		//read是一个字节一个字节地读，字节流的结尾标志是01
		while (len != -1) {
			out.write(buf, 0, len);
			len = in.read(buf);
		}
	}
	
	public static void main(String[] args) throws IOException {
		test t = new test();
		System.out.println("输入字符： ");
		t.copy(System.in, System.out);
	}

}
