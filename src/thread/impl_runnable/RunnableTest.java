package thread.impl_runnable;

public class RunnableTest {
	public static void main(String[] args) {
		Rabbit rab = new Rabbit();
		Thread proxy = new Thread(rab);
		proxy.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("Runnable#run(): i = " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
