
public class CreateThread {

	public static void main(String[] args) {
		//声明一个Thread1对象，这个Thread1类继承自Thread类的
		Thread1 thread1 = new Thread1();
		
		//这里用到了匿名内部类
		Thread thread2 = new Thread(new Thread2());
		
		//启动线程
		thread1.start();
		thread2.start();
	}

}

class Thread1 extends Thread {
	public void run() {
		//在run（）方法中放入线程要完成的工作
		
		//这里我们把两个线程各自的共组设置为打印100此信息
		for (int i = 0; i < 100; i++) {
			System.out.println("Hello! This is " + i);
		}
		//在这个循环结束后，线程便会自动结束
	}
}

class Thread2 implements Runnable {
	//与Thread1不同，如果当一个线程已经继承了另一个类时，就建议通过实现Runnable接口来构造
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Thanks. There is " + i);
		}
	}

}