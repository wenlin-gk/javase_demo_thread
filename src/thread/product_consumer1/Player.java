package thread.product_consumer1;

public class Player implements Runnable{
	private MovieHouse mh;

	public Player(MovieHouse mh) {
		super();
		this.mh = mh;
	}

	@Override
	public void run() {
		for(int i=0; i<20; i++){
			//String movie = i%2 == 0 ? "movie1" : "movie2";
			String movie = String.format("movie%d", i);
			mh.play(movie);
		}
	}
}
