
public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		//声明并实例化一个ThreadState对象
		ThreadState state = new ThreadState();
		
		//利用这个名为state的ThreadState对象来创建Thread对象
		Thread thread = new Thread(state);
		
		//使用getState()方法来获得线程的状态，并进行输出
		System.out.println("Create new thread: " + thread.getState());

		//使用thread对象的start()方法来启动新的线程
        thread.start(); 
        
        //输出线程的状态
        System.out.println("Start the thread: " + thread.getState());
        
        //通过调用sleep()方法使当前这个线程休眠100毫秒，从而使新的线程运行waitForAMoment()方法
        Thread.sleep(100); 

        //输出线程的状态
        System.out.println("Waiting for a moment (time): " + thread.getState());

        //使当前这个线程休眠1000毫秒，从而使新的线程运行waitForever()方法
        Thread.sleep(1000); 
        
        //输出线程的状态
        System.out.println("Waiting for a moment: " + thread.getState());

        // 调用state的notifyNow()方法
        state.notifyNow(); 
        
        //输出线程的状态
        System.out.println("Wake up the thread: " + thread.getState());
        
        //使当前线程休眠1000毫秒，使新线程结束
        Thread.sleep(1000); 
        
        //输出线程的状态
        System.out.println("Terminate the thread: " + thread.getState());
        
	}

}
