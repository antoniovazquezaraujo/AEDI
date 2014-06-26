package aed2.dar_cambio;

import java.util.Iterator;
import java.util.Map;

public class DarCambio {

	public static void main(String[] args) {
		

	}

	// Dar el cambio
	public static boolean darCambio(int importeDevolver,
			Map<Integer, Integer> cambio, Map<Integer, Integer> solucion) {
		boolean objetivo = false;
		Iterator<Integer> it = cambio.keySet().iterator();

		// Mientras no se hayan mirado todas las posibilidades o alcanzado el
		// objetivo
		while (it.hasNext() && !objetivo) {
			int moneda = it.next();
			if (cambio.get(moneda) > 0 && importeDevolver >= moneda) {
				cambio.put(moneda, cambio.get(moneda) - 1);
				if (moneda == importeDevolver) {
					solucion.put(moneda, solucion.get(moneda) + 1);
					objetivo = true;
				} else {
					objetivo = darCambio(importeDevolver - moneda, cambio,
							solucion);
					if (objetivo)
						solucion.put(moneda, solucion.get(moneda) + 1);
					else {
						cambio.put(moneda, cambio.get(moneda) + 1);
					}
				}
			}
		}
		return objetivo;
	}
}
