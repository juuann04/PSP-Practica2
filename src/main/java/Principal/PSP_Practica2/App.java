package Principal.PSP_Practica2;

import java.util.ArrayList;
import java.util.List;

import javax.management.monitor.Monitor;

public class App {
	
	static final int NUM_CONSUMERS = 100;
	static final int NUM_PRODUCERS = 100;
	static final int LOOPS = 1;
	
	public static void main(String[] args) {
		
		final Monitor monitor = new Monitor(28);
		final TaskManager taskManager = new TaskManager();
		List<Consumer> consumers = new ArrayList<>();
		List<Producer> producers = new ArrayList<>();

		for (int i = 0; i < NUM_CONSUMERS; i++) {
			consumers.add(new Consumer(taskManager));
		}

		for (int i = 0; i < NUM_PRODUCERS; i++) {
			producers.add(new Producer(taskManager));
		}

		for (Consumer c : consumers) {
			c.start();
		}
		

		for (Producer p : producers) {
			p.start();
		}
	}
}