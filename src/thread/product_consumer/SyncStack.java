package thread.product_consumer;

public class SyncStack {
	
	int index = 0;
	
	ManTou[] mtArr = new ManTou[10];
	
	public synchronized void push(ManTou m){
		if(this.index == mtArr.length){
			try {
				System.out.println("馒头栈已满，请等待。");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("馒头栈有空余位置，请push。");
		mtArr[this.index] = m;
		this.index++;
		this.notify();
	}
	
	public synchronized ManTou pop(){
		if(this.index == 0){
			try {
				System.out.println("馒头栈已空，请等待。");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("馒头栈有馒头，请pop。");
		this.index--;
		this.notify();
		return mtArr[this.index];
	}
	
}