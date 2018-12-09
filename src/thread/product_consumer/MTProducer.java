package thread.product_consumer;

public class MTProducer extends Thread{
	SyncStack ss = null;

	public MTProducer(SyncStack ss) {
		super();
		this.ss = ss;
	}

	@Override
	public void run() {
		for(int i = 0; i< 20; i++){
			ManTou m = new ManTou(i);
			ss.push(m);
			System.out.println(
					String.format("做馒头%d", m.getId()));
		}
	}
}
