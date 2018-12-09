package thread.multithread_operator;

public class Web12306 implements Runnable {
	private int num = 50;
	
	@Override
	public void run() {
		while(true){
			if(num <= 0){
				break;
			}
			System.out.println(Thread.currentThread().getName() + "抢到票" + num--);
		}
	}
	
	/**
	 * 多个线程 操作 同一个数字：数据竞争
	 * @param args
	 */
	public static void main(String[] args) {
		Web12306 web = new Web12306();
		
		Thread t1 = new Thread(web, "man1");
		Thread t2 = new Thread(web, "man2");
		Thread t3 = new Thread(web, "man3");
		
		t1.start();
		t2.start();
		t3.start();
	}

}
