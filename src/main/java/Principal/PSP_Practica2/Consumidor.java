package Principal.PSP_Practica2;

public class Consumidor extends Thread {

	private int id;
	private Monitor miMonitor;

	public Consumidor(int id, Monitor miMonitor) {
		this.id = id;
		this.miMonitor = miMonitor;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100 ; i++) {
			System.out.println("Soy el consumidor " + id + " y voy a consumir " + miMonitor.decrementar());
		}
	}
}