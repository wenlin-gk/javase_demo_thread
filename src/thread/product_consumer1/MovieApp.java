package thread.product_consumer1;

import org.junit.Test;

/**
 * 需求：生产者消费者模式demo
 * 功能：无（不对外提供功能）
 * 实现：
 * 	电影院类：
 * 	电影生产类：
 * 	电影消费类：
 * 	测试类
 */
public class MovieApp {

	@Test
	public void test(){
		MovieHouse mh = new MovieHouse();
		Player p = new Player(mh);
		Watcher w = new Watcher(mh);
		
		new Thread(p).start();
		new Thread(w).start();
	}
	
}
