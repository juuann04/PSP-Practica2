package Principal.PSP_Practica2;

public class Producer extends Thread{
	static TaskManager taskManager;

	public Producer(TaskManager taskManager) {
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