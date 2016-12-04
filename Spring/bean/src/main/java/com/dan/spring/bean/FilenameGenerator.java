package com.dan.spring.bean;

public class FilenameGenerator {

	private String name;
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
    /*
    *打印文件名和文件类型的方法
    */
    public void printFileName() {
       System.out.println("FileName & FileType is : " + name + " & " + type);
    }
}
