package thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService serv = Executors.newFixedThreadPool(2);
		
		Race tort = new Race("tort", 200);
		Race rabbit = new Race("rabbit", 10);
		Future<Integer> result1 = serv.submit(tort);
		Future<Integer> result2 = serv.submit(rabbit);
		
		Thread.sleep(2000);
		tort.setFlag(false);
		rabbit.setFlag(false);
		
		Thread.sleep(5);
		System.out.println(tort.getStepNum());
		System.out.println(result1.get());
		
		System.out.println(rabbit.getStepNum());
		System.out.println(result2.get());
		
		serv.shutdownNow();
	}
}
