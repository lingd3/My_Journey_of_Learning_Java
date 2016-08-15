import java.io.IOException;

public class IOUtilTest1 {

	public static void main(String[] args) {
		try {
			IOUtil.printHex("/Users/gd/Desktop/tornado/tornado/1.py");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
