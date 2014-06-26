package aed2.grafos;

import grafo.*;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

public class Actividad7_Algoritmos {

	/*
	 * El Grafo debe estar bien construido, sino es posible que queden ciudades
	 * sin visitar �Un viajante debe recorrer una serie de ciudades
	 * interconectadas entre s�, de manera que recorra todas ellas con el menor
	 * n�mero de kil�metros posible�.
	 */

	public static <E> Grafo<E, Integer> viajante(Grafo<E, Integer> g,
			Vertice<E> v) {
		Vertice<E> nodoActual = v;
		Set<Vertice<E>> porVisitar = new HashSet<Vertice<E>>();
		Grafo<E, Integer> solucion = new ListaAdyacencia<E, Integer>();

		Iterator<Vertice<E>> it_v = g.vertices();

		while (it_v.hasNext()) {
			Vertice<E> vert = it_v.next();
			porVisitar.add(vert);
		}

		porVisitar.remove(nodoActual); // lo elimina del conjunto

		boolean continuar = true;

		while (!porVisitar.isEmpty() && continuar) {
			Arco<E, Integer> u = minimo(g.arcos(), nodoActual, porVisitar);
			if (u != null) {
				porVisitar.remove(u.getDestino());
				solucion.insertarArco(u);
				nodoActual = u.getDestino();
			} else
				continuar = false;
		}
		return solucion;
	}

	private static <E> Arco<E, Integer> minimo(Iterator<Arco<E, Integer>> arc,
			Vertice<E> v, Set<Vertice<E>> iPorVisitar) {
		int dist_v_min = 0;
		int min = Integer.MAX_VALUE;
		Arco<E, Integer> arco_min = null;
		while (arc.hasNext()) {
			Arco<E, Integer> a1 = arc.next();
			Vertice<E> w = a1.getDestino();
			if (a1.getOrigen().equals(v) && iPorVisitar.contains(w)) {
				dist_v_min = a1.getEtiqueta();
				if (dist_v_min < min) {
					arco_min = a1;
					min = dist_v_min;
				}

			}
		}
		return arco_min;

	}

	// Se desea implantar un tendido el�ctrico siguiendo los trazos de las
	// carreteras de manera que conecte todas las ciudades y que la longitud
	// total sea m�nima.
	public static <E> Grafo<E, Integer> prim(Grafo<E, Integer> g, Vertice<E> v) {
		Set<Vertice<E>> porVisitar = new HashSet<Vertice<E>>();
		Set<Vertice<E>> visitados = new HashSet<Vertice<E>>();
		Grafo<E, Integer> solucion = new ListaAdyacencia<E, Integer>();

		Iterator<Vertice<E>> it_v = g.vertices();

		while (it_v.hasNext()) {
			Vertice<E> vert = it_v.next();
			porVisitar.add(vert);
		}

		porVisitar.remove(v);
		visitados.add(v);

		while (!porVisitar.isEmpty()) {
			Arco<E, Integer> u = minimo(g.arcos(), porVisitar, visitados);
			Vertice<E> w = u.getDestino();
			porVisitar.remove(w);
			visitados.add(w);
			solucion.insertarArco(u);
		}
		return solucion;
	}

	private static <E> Arco<E, Integer> minimo(Iterator<Arco<E, Integer>> arc,
			Set<Vertice<E>> iPorVisitar, Set<Vertice<E>> iVisitados) {
		int dist_v_min = 0;
		int min = Integer.MAX_VALUE;
		Arco<E, Integer> arco_min = null;

		while (arc.hasNext()) {
			Arco<E, Integer> a1 = arc.next();
			Vertice<E> w = a1.getDestino();
			Vertice<E> v = a1.getOrigen();
			if (iVisitados.contains(v) && iPorVisitar.contains(w)) {
				dist_v_min = a1.getEtiqueta();
				if (dist_v_min < min) {
					arco_min = a1;
					min = dist_v_min;
				}

			}
		}
		return arco_min;
	}

	// /////////////////////////////////////////////////////
	public static <E> Map<Vertice<E>, Integer> dijkstra(Grafo<E, Integer> g,
			Vertice<E> v) {
		final int INFINITO = Integer.MAX_VALUE;
		Map<Vertice<E>, Integer> distancias = new HashMap<Vertice<E>, Integer>();
		Set<Vertice<E>> porVisitar = new HashSet<Vertice<E>>();

		Iterator<Vertice<E>> it_v = g.vertices();

		// Metemos en porVisitar todos los vertices del grafo
		// y en distancias los ponemos con distancia infinita
		// salvo la distancia de cada uno a s� mismo que ser� 0
		while (it_v.hasNext()) {
			Vertice<E> vert = it_v.next();
			Integer distanciaTeorica = vert.equals(v) ? new Integer(0)
					: new Integer(INFINITO);
			distancias.put(vert, distanciaTeorica);
			porVisitar.add(vert);
		}

		while (!porVisitar.isEmpty()) {
			Vertice<E> verticeMinimo = minimo(distancias, porVisitar.iterator());
			porVisitar.remove(verticeMinimo);
			int distanciaAlVerticeMinimo = distancias.get(verticeMinimo);

			if (distanciaAlVerticeMinimo != INFINITO) {
				Iterator<Vertice<E>> adyacentes = g.adyacentes(verticeMinimo);
				while (adyacentes.hasNext()) {
					Vertice<E> adyacente = adyacentes.next();
					if (porVisitar.contains(adyacente)) {
						Iterator<Arco<E, Integer>> arco = g.arcos();
						int distanciaAlAdyacente = 0;
						while (arco.hasNext()) {
							Arco<E, Integer> a1 = arco.next();
							if (a1.getOrigen().equals(verticeMinimo)
									&& a1.getDestino().equals(adyacente)) {
								distanciaAlAdyacente = a1.getEtiqueta();
							}
						}
						int distanciaAnterior = distancias.get(adyacente);
						int nuevaDistancia = distanciaAlVerticeMinimo
								+ distanciaAlAdyacente;
						if (nuevaDistancia < distanciaAnterior) {
							distancias.put(adyacente, new Integer(
									nuevaDistancia));
						}
					}
				}
			}
		}
		return distancias;
	}

	private static <E> Vertice<E> minimo(Map<Vertice<E>, Integer> distancias,
			Iterator<Vertice<E>> iPorVisitar) {
		Vertice<E> vertice = null;
		Vertice<E> verticeMasCercano = iPorVisitar.next();
		int distanciaAlVertice = 0;
		int distanciaAlVerticeMasCercano = distancias.get(verticeMasCercano);

		while (iPorVisitar.hasNext()) {
			vertice = iPorVisitar.next();
			distanciaAlVertice = distancias.get(vertice);
			if (distanciaAlVertice < distanciaAlVerticeMasCercano) {
				verticeMasCercano = vertice;
				distanciaAlVerticeMasCercano = distanciaAlVertice;
			}
		}
		return verticeMasCercano;
	}
}
