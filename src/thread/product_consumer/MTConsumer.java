package thread.product_consumer;

public class MTConsumer extends Thread{
	SyncStack ss = null;

	public MTConsumer(SyncStack ss) {
		super();
		this.ss = ss;
	}

	@Override
	public void run() {
		for(int i = 0; i< 20; i++){
			ManTou m = ss.pop();
			System.out.println(
					String.format("吃馒头%d", m.getId()));
		}
	}
}
