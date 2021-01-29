package Principal.PSP_Practica2;

import java.util.ArrayList;
import java.util.List;

public class App {

	private final static int productoresTotales = 10;
	private final static int consumidoresTotales = 10;

	public static void main(String[] args) {

		Monitor miMonitor = new Monitor();
		List<Productor> miProductor = new ArrayList<Productor>();
		List<Consumidor> miConsumidor = new ArrayList<Consumidor>();

		for (int i = 0; i < productoresTotales; i++) {
			miProductor.add(new Productor(i, miMonitor));
		}

		for (int i = 0; i < consumidoresTotales; i++) {
			miConsumidor.add(new Consumidor(i, miMonitor));
		}

		for (Consumidor c : miConsumidor) {
			c.start();
		}

		for (Productor p : miProductor) {
			p.start();
		}

		for (Consumidor c : miConsumidor) {
			try {
				c.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (Productor p : miProductor) {
			try {
				p.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(miMonitor);
		System.out.println("Programa terminado");
	}
}