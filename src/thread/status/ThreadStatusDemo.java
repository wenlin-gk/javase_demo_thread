package thread.status;

/**
 * void Thread#join() 等待该线程终止
 * void Thread#sleep()
 * void Thread#yield(); 将cpu使用权让给其他线程
 *
 */
public class ThreadStatusDemo {

	public static void main(String[] args)
			throws InterruptedException {
		//joinTest();
		//sleepTest();
		//stopTest();
		yieldTest();
	}
	
	private static void joinTest() throws InterruptedException {
		RunnableDemo runObj = new RunnableDemo();
		Thread demo = new Thread(runObj);
		demo.start();
		
		for(int i=0; i<50; i++){
			if(10 == i){
				demo.join();//等待该线程终止
				runObj.stop();
			}
			System.out.println(
			  String.format("main: %d", i)
			);
		}
	}
	
	private static void sleepTest() throws InterruptedException{
		int num = 3;
		while(true){
			System.out.println(num--);
			Thread.sleep(1000);
			if(num<=0){
				break;
			}
		}
	}
	
	private static void stopTest() throws InterruptedException{
		RunnableDemo runObj = new RunnableDemo();
		Thread demo = new Thread(runObj);
		demo.start();
		
		for(int i=0; i<50; i++){
			if(10 == i){
				runObj.stop();
			}
			System.out.println(
			  String.format("main: %d", i)
			);
		}
	}

	private static void yieldTest() throws InterruptedException{
		RunnableDemo runObj = new RunnableDemo();
		Thread demo = new Thread(runObj);
		demo.start();
		
		for(int i=0; i<50; i++){
			Thread.yield();
			System.out.println(
			  String.format("main: %d", i)
			);
		}
	}
}

class RunnableDemo implements Runnable{
	private boolean flag = true;
	
	@Override
	public void run() {
		for(int i=0; i<50; i++){
			if(flag == true){
				System.out.println(
						String.format("ThreadDemo: %d", i)
				);
			}else{
				break;
			}
		}
	}
	
	public void stop(){
		this.flag = false;
	}
}
