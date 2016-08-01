public class ClassDemo {
	/*
	 *  演示Class类的访问方法
	 */
	
	public static void main(String[] args) throws ClassNotFoundException {
		String objString = new String();
		Class objClass;
		objClass = objString.getClass();
		System.out.println("String 对象的类型是： " + objClass.getName());
		objClass = Integer.class;
		System.out.println("Integer 对象的类型是: " + objClass.getName());
		objClass = Class.forName("java.lang.String");
		System.out.println("Character 对象的类型是： " + objClass.getName());
		objClass = objClass.getSuperclass();
		System.out.println("Character 对象的父亲是： " + objClass.getName());
	}

}
