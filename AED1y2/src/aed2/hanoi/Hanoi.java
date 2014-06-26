package aed2.hanoi;

import java.util.Iterator;
import java.util.Map;


public class Hanoi {
	private static int cont = 0;



	// Hanoi
	private static int movimiento(int n, char origen, char destino) {
		System.out.println("Mover disco " + n + " de " + origen + " a "
				+ destino);
		return 1;
	}

	public static int hanoi(int n, char origen, char auxiliar, char destino) {
		if (n == 1) {
			cont += movimiento(n, origen, destino);
		} else {
			hanoi(n - 1, origen, destino, auxiliar);
			cont += movimiento(n, origen, destino);
			hanoi(n - 1, auxiliar, origen, destino);
		}
		return cont;
	}

	public static void main(String[] args) {
		 System.out.println("\n ------ Torres de Hanoi ----");
		 int cont = Hanoi.hanoi(3, 'O', 'A', 'D');
		 System.out.println("Movimientos :" + cont);
	}
}
