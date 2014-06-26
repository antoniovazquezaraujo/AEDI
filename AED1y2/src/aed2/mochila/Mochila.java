package aed2.mochila;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class Mochila {

	public static <E> Map<E, Integer> llenarMochila(int volMax,
			Map<E, Integer> cantidades, Map<E, Integer> volumenes) {
		int volRestante = volMax;
		Map<E, Integer> toret = new HashMap<E, Integer>();
		int numObj;
		boolean llenarMas = true;
		while (volRestante > 0 && llenarMas == true) {
			E candidato = objeto(volRestante, cantidades, volumenes);
			if (candidato != null) {
				numObj = volRestante / volumenes.get(candidato);
				if (numObj >= cantidades.get(candidato)) {
					toret.put(candidato, cantidades.get(candidato));
					volRestante = volRestante
							- (cantidades.get(candidato) * volumenes
									.get(candidato));
				} else {
					toret.put(candidato, numObj);
					volRestante = volRestante
							- (numObj * volumenes.get(candidato));
				}
			} else {
				llenarMas = false;
			}
		}
		return toret;
	}

	private static <E> E objeto(int volRestante, Map<E, Integer> cantidades,
			Map<E, Integer> volumenes) {
		E toret = null;
		Iterator<E> it = volumenes.keySet().iterator();
		int mayor = 0;
		while (it.hasNext()) {
			E obj = it.next();
			int vol = volumenes.get(obj);
			// if (!objUsados.contains(obj) && valor.get(obj) > 0 && vol > mayor
			if (vol > 0 && vol > mayor && vol <= volRestante) {
				mayor = vol;
				toret = obj;
			}
		}

		return toret;

	}

	public static void main(String[] args) {
		Map<String, Integer> cantidades = new HashMap<String, Integer>();
		Map<String, Integer> tamaños = new HashMap<String, Integer>();

		int volumenMochila = 32;

		cantidades.put("coche", 10);
		cantidades.put("bocadillo", 4);
		tamaños.put("coche", 30);
		tamaños.put("bocadillo", 2);

		Map<String, Integer> ret = llenarMochila(volumenMochila, cantidades,
				tamaños);
		visualizar(ret, tamaños, volumenMochila);

	}

	public static void visualizar(Map<String, Integer> cantidades,
			Map<String, Integer> tamaños, int volMochila) {
		Iterator<String> i = cantidades.keySet().iterator();
		int volumenLibre = volMochila;
		while (i.hasNext()) {
			String clave = i.next();
			System.out.println("Objeto: " + clave + " numero: "
					+ cantidades.get(clave));
			volumenLibre = volumenLibre
					- (cantidades.get(clave) * tamaños.get(clave));
		}
		System.out.println("Volumen libre despues de introducir: "
				+ volumenLibre);
	}

}
