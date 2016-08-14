import java.io.*;

public class FileDemo {

	public static void main(String[] args) {
		//构造函数File(String pathname)
        File f1 = new File("/Users/gd/Desktop/1.txt");
        //File(String parent,String child)
        File f2 = new File("/Users/gd/","2.txt");
        //separator 跨平台分隔符
        File f3 = new File("/Users"+File.separator+"gd");
        File f4 = new File(f3,"3.txt");

        try {
            System.out.println(f1);
            //当文件存在时返回 false；不存在时返回 true
            System.out.println(f2.createNewFile());
            //当文件不存在时返回 false
            System.out.println(f3.delete());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //列出磁盘下的文件和文件夹
        File[] files = File.listRoots();
        for (File file:files) {
            System.out.println(file);
            if(file.length()>0){
                String[] filenames =file.list();
                for(String filename:filenames){
                    System.out.println(filename);
                }
            }
        }		
	}

}
