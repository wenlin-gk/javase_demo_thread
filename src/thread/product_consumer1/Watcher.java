package thread.product_consumer1;

public class Watcher implements Runnable{
	private MovieHouse mh;

	public Watcher(MovieHouse mh) {
		super();
		this.mh = mh;
	}

	@Override
	public void run() {
		for(int i=0; i<20; i++){
			String movie = mh.watch();
			System.out.println("播放" + movie);
		}
	}
}
