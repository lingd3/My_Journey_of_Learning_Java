import java.io.File;
import java.io.IOException;

public class IOUtilTest3 {

	public static void main(String[] args) {
		try {
			IOUtil.copyFile(new File("/Users/gd/Desktop/tornado/tornado/string_service.py"), 
					new File("demo/copy.dat"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
