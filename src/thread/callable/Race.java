package thread.callable;

import java.util.concurrent.Callable;

public class Race implements Callable<Integer>{
	private String name;
	private long dt;
	private int stepNum;
	private boolean flag = true;
	
	public Race(String name) {
		super();
		this.name = name;
		this.dt = 500;
	}

	public Race(String name, long dt) {
		super();
		this.name = name;
		this.dt = dt;
	}

	@Override
	public Integer call() throws Exception {
		while(flag){
			Thread.sleep(this.dt);
			this.stepNum++;
		}
		return this.stepNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getDt() {
		return dt;
	}

	public void setDt(long dt) {
		this.dt = dt;
	}

	public int getStepNum() {
		return stepNum;
	}

	public void setStepNum(int stepNum) {
		this.stepNum = stepNum;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
