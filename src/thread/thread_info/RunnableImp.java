package thread.thread_info;

public class RunnableImp implements Runnable{
	
	private boolean flag = true;

	private int runTimes = 0;
	
	@Override
	public void run() {
		while(flag){
			System.out.printf("%s run %d times.\n",
					Thread.currentThread().getName(), runTimes++);
		}
	}

	public void stop(){
		this.flag = false;
	}

	public int getRunTimes() {
		return runTimes;
	}
}
