package thread.thread_info;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 工具：
 *	（查询线程相关信息的）方法
 * 		new Thread(Runnable target, String name);
 * 		Thread.setName();
 * 		Thread.getName();
 * 		Thread.isAlive();
 * 		Thread.setPriority();
 * 		Thread.MIN_PRIORITY
 * 		Thread.MAX_PRIORITY
 * 
 * 工具使用样例：
 * 	xxx
 * 
 * 样例实现：
 * 	线程类：
 * 		继承Runnable接口
 * 		flag: boolean
 * 		run()
 * 		stop():设置进程状态为false
 * 	测试流程1：
	 * 	创建一个线程类
	 * 	setName()设置线程名称
	 * 	getName()查询线程名称
	 * 	查看线程状态
	 * 	运行
	 * 	查看线程状态
	 * 	stop()
	 * 	查看线程状态
 * 	测试流程2：
 * 		创建线程1,2
 * 		设置线程1,2的运行优先级
 * 		运行（查看运行效果）
 * 
 * @author 飞扬
 */
public class GetThreadInfo {
	
	@Test
	public void test_thread_info() throws Exception {
		RunnableImp t = new RunnableImp();
		Thread proxy = new Thread(t, "Original Name");
		System.out.println(proxy.getName());
		
		proxy.setName("Name2");
		System.out.println(proxy.getName());
		System.out.println(Thread.currentThread().getName());
		
		proxy.start();
		System.out.println(proxy.isAlive());
		t.stop();
		Thread.sleep(1000);
		System.out.println(proxy.isAlive());
	}
	
	@Test
	public void test_thread_priority() throws Exception {
		RunnableImp t1 = new RunnableImp();
		RunnableImp t2 = new RunnableImp();
		Thread proxy1 = new Thread(t1, "线程1");
		Thread proxy2 = new Thread(t2, "线程2");
		
		proxy1.setPriority(Thread.MAX_PRIORITY);
		proxy2.setPriority(Thread.MIN_PRIORITY);
		
		proxy1.start();
		proxy2.start();
		
		Thread.sleep(100);
		t1.stop();
		t2.stop();
		System.out.printf(t1.getRunTimes() + " " + t2.getRunTimes());
		assertEquals(true, t1.getRunTimes() > t2.getRunTimes());
	}
}
