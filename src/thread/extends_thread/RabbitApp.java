package thread.extends_thread;

public class RabbitApp {

	public static void main(String[] args) throws InterruptedException {
		Rabbit rab = new Rabbit();
		Tortois tor = new Tortois();
		
//		rab.run();
//		tor.run();
		
		//启动新线程
		rab.start();
		tor.start();
		
		for(int i=0; i<100; i++){
			System.out.println("main==>" + i);
			Thread.sleep(100);
		}
	}
}