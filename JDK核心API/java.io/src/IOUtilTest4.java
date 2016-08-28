import java.io.File;
import java.io.IOException;

public class IOUtilTest4 {

	public static void main(String[] args) {
		try {
			long start = System.currentTimeMillis();
			IOUtil.copyFileByBuffer(new File("/Users/gd/Desktop/tornado/tornado/string_service.py"), new File("demo/copyByBuffer.dat"));
			long end = System.currentTimeMillis();
			System.out.println(end-start);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
