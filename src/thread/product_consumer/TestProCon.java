package thread.product_consumer;

import org.junit.Test;

/**
 * 需求：生产者消费者模式demo
 * 功能：无（不对外提供功能）
 * 实现：
 * 	馒头类：
 * 	馒头生产类：
 * 	馒头消费类；
 * 	馒头栈：
 * 		馒头数组
 * 		栈顶馒头的数组序号
 * 		push方法（馒头）
 * 			同步方法，防止index越界
 * 			if index == arrLength
 * 				this.wait()
 * 			xxx
 * 		pop方法
 * 			同步方法：防止index越界
 * 			if index == 0
 * 				this.wait()
 * 			xxx 
 * 	测试类
 */
public class TestProCon {
	@Test
	public void test(){
		SyncStack ss = new SyncStack();
		MTProducer mp = new MTProducer(ss);
		MTConsumer mc = new MTConsumer(ss);
		
		mc.start();
		mp.start();
	}
}
