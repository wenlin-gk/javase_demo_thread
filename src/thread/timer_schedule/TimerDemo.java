package thread.timer_schedule;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.junit.Test;

public class TimerDemo {

	@Test
	public void test(){
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("定时器任务。");
			}
		},
		new Date(System.currentTimeMillis() + 1000),
		2000
		);
	}
	
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("定时器任务。");
			}
		},
		new Date(System.currentTimeMillis()),
		2000
		);
	}
	
}
