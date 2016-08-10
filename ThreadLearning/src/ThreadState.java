
public class ThreadState implements Runnable {
	
	public synchronized void waitForAMoment() throws InterruptedException {
		//使用wait()方法使当前线程等待500毫秒
        //或者等待其他线程调用notify()或notifyAll()方法来唤醒
		wait(500);
	}
	
	public synchronized void waitForever() throws InterruptedException {
		//不填入时间就意味着使当前线程永久等待，
        //只能等到其他线程调用notify()或notifyAll()方法才能唤醒
        wait(); 
    }
	
	public synchronized void notifyNow() throws InterruptedException {
		//使用notify()方法来唤醒那些因为调用了wait()方法而进入等待状态的线程
        notify(); 
    }
	
	public void run() {
		//这里用异常处理是为了防止可能的中断异常
        //如果任何线程中断了当前线程，则抛出该异常

        try {
            waitForAMoment(); 
            // 在新线程中运行waitMoment()方法

            waitForever(); 
            // 在新线程中运行waitForever()方法

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}












