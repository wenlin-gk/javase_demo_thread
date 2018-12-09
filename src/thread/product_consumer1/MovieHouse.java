package thread.product_consumer1;

public class MovieHouse {
	private String pic;
	
	private boolean isUp = false;
	
	public synchronized void play(String pic){
		if(this.isUp){
			try {
				System.out.println("Play wait.");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Play begin.");
		this.pic = pic;
		this.isUp = true;
		this.notify();
	}
	
	public synchronized String watch(){
		if(!this.isUp){
			try {
				System.out.println("Watch wait.");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Watch begin.");
		this.isUp = false;
		this.notify();
		return this.pic;
	}
}
