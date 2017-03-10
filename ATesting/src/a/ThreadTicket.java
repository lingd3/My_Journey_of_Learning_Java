package a;

class MyThread extends Thread{  
	private int ticket=10;  
	public void run(){  
		for(int i=0;i<20;i++){  
			if(this.ticket>0){  
				System.out.println("卖票：ticket"+this.ticket--);  
			}  
		}  
	}  
}; 

public class ThreadTicket {  
	public static void main(String[] args) {  
	MyThread mt1=new MyThread();  
	MyThread mt2=new MyThread();  
	MyThread mt3=new MyThread();  
	mt1.start();//每个线程都各卖了10张，共卖了30张票  
	mt2.start();//但实际只有10张票，每个线程都卖自己的票  
	mt3.start();//没有达到资源共享  
	}  
} 