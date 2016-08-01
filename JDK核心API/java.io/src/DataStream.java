import java.io.*;

public class DataStream {

	public static void main(String[] args) throws IOException {
		//向文件a.txt写入
		FileOutputStream fos = new FileOutputStream("a.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		try {
			dos.writeBoolean(true);
			dos.writeByte((byte)123);
			dos.writeChar('J');
			dos.writeDouble(3.1415926);
			dos.writeFloat(2.122f);
			dos.writeInt(123);
		} finally {
			dos.close();
		}
		//从文件a.txt读出
		FileInputStream fis = new FileInputStream("a.txt");
		DataInputStream dis = new DataInputStream(fis);
        try {
            System.out.println("\t" + dis.readBoolean());
            System.out.println("\t" + dis.readByte());
            System.out.println("\t" + dis.readChar());
            System.out.println("\t" + dis.readDouble());
            System.out.println("\t" + dis.readFloat());
            System.out.println("\t" + dis.readInt());
        } finally {
            dis.close();
        }
	}

}
