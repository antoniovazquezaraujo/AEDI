package aed2.mochila;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MochilaFormatic {
	public static void main(String[] args) {
		Map<String, Integer> cantidades = new HashMap<String, Integer>();
		Map<String, Integer> volumenes = new HashMap<String, Integer>();
		Integer volumenMochila = 100;
		cantidades.put("Bocata", 12);
		cantidades.put("Botella", 5);

		volumenes.put("Bocata", 3);
		volumenes.put("Botella", 7);

		Map<String, Integer> res = llenarMochila(volumenMochila, cantidades,
				volumenes);
		System.out.println(res);

	}

	public static <E> Map<E, Integer> llenarMochila(Integer volumenMaximo,
			Map<E, Integer> cantidades, Map<E, Integer> volumenes) {
		Map<E, Integer> contenidoMochila = new HashMap<E, Integer>();
		Integer volumenResto = volumenMaximo;
		boolean llenarMas = true;
		while (volumenResto > 0 && llenarMas) {
			E objeto = seleccion(volumenResto, cantidades, volumenes);
			if (objeto != null) {
				int volumenObjeto = volumenes.get(objeto);
				int entran = volumenResto / volumenObjeto;
				if (entran > 0) {
					int cantidadActual = cantidades.get(objeto);
					cantidades.put(objeto, cantidadActual - entran);
					contenidoMochila.put(objeto, entran);
					volumenResto -= (entran * volumenObjeto);
				}
			} else {
				llenarMas = false;
			}
		}
		return contenidoMochila;
	}

	private static <E> E seleccion(Integer volumenRestante,
			Map<E, Integer> cantidades, Map<E, Integer> volumenes) {
		E objetoMasAbundante = null;
		int cantidadDeMayorObjeto = 0;
		Iterator<E> objetos = cantidades.keySet().iterator();
		while (objetos.hasNext()) {
			E objeto = objetos.next();
			int cantidadObjeto = cantidades.get(objeto);
			if (cantidades.get(objeto) > 0
					&& cantidadObjeto > cantidadDeMayorObjeto
					&& cantidadObjeto * volumenes.get(objeto) <= volumenRestante) {
				cantidadDeMayorObjeto = cantidadObjeto;
				objetoMasAbundante = objeto;
			}
		}
		return objetoMasAbundante;
	}

}
