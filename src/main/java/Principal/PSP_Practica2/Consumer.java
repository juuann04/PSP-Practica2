package Principal.PSP_Practica2;

public class Consumer extends Thread {
	static TaskManager taskManager;

	public Consumer(TaskManager taskManager) {
		this.taskManager = taskManager;
	}

	@Override
	public void run() {
		taskManager.write();
		try {
			wait();
		} catch (InterruptedException ie) {
			
		}
	}
}