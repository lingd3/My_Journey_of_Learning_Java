import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class BrAndBwOrPwDemo {

	public static void main(String[] args) throws IOException {
		//对文件进行读写操作
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream("/Users/gd/Desktop/tornado/tornado/string_service.py")));
		/*BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream("demo/copy2.dat"))); */
		PrintWriter pw = new PrintWriter("demo/copy3.dat");
		//PrintWriter pw1 = new PrintWriter(outputStream, boolean autoFlush);
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);//一次读一行，并不能识别换行
			/*bw.write(line);
			//单独写出换行操作
			bw.newLine();
			bw.flush();*/
			pw.println(line);
			pw.flush();
		}
		br.close();
		//bw.close();
		pw.close();
	}

}








