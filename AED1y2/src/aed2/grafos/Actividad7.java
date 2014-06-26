package aed2.grafos;

import grafo.*;
import java.util.Iterator;
import java.util.Vector;

public class Actividad7 {

	// Ejercicio 1
	public static <E, T> Iterator<Vertice<E>> predecesores(Grafo<E, T> g,
			Vertice<E> v) {
		Vector<Vertice<E>> pred = new Vector<Vertice<E>>();
		Iterator<Arco<E, T>> i = g.arcos();
		while (i.hasNext()) {
			Arco<E, T> a = i.next();
			if (a.getDestino().equals(v)) {
				pred.add(a.getOrigen());
			}
		}
		return pred.iterator();
	}

	public static <E, T> Iterator<Vertice<E>> predecesores2(Grafo<E, T> g,
			Vertice<E> v) {
		Vector<Vertice<E>> pred = new Vector<Vertice<E>>();
		Iterator<Vertice<E>> i = g.vertices();
		while (i.hasNext()) {
			Vertice<E> w = i.next();
			Iterator<Vertice<E>> i2 = g.adyacentes(w);
			while (i2.hasNext()) {
				if (i2.next().equals(v)) {
					pred.add(w);
				}
			}
		}
		return pred.iterator();
	}

	// Ejercicio 2
	public static <E, T> boolean sumidero(Grafo<E, T> g, Vertice<E> v) {
		// numero de v�rtices
		Iterator<Vertice<E>> itVer = g.vertices();
		int numVertices = 0;
		while (itVer.hasNext()) {
			itVer.next();
			numVertices++;
		}
		// grado de entrada
		itVer = predecesores(g, v);
		int numPred = 0;
		while (itVer.hasNext()) {
			itVer.next();
			numPred++;
		}
		// grado de salida
		itVer = g.adyacentes(v);
		int numAdy = 0;
		while (itVer.hasNext()) {
			itVer.next();
			numAdy++;
		}
		return numAdy == 0 && numPred == numVertices - 1;
	}

	// Ejercicio 3

	public static <E, T> boolean hayCaminoEntreDos(Grafo<E, T> g,
			Vertice<E> v1, Vertice<E> v2) {
		Vector<Vertice<E>> visitados = new Vector<Vertice<E>>();
		return caminoEntreDos(g, v1, v2, visitados);
	}

	private static <E, T> boolean caminoEntreDos(Grafo<E, T> g, Vertice<E> v1,
			Vertice<E> v2, Vector<Vertice<E>> visitados) {
		boolean encontrado = false;
		visitados.add(v1);
		if (v1.equals(v2))
			return true;
		else {
			Iterator<Vertice<E>> adys = g.adyacentes(v1);
			while (adys.hasNext() && !encontrado) {
				Vertice<E> w = adys.next();
				if (!visitados.contains(w)) {
					encontrado = caminoEntreDos(g, w, v2, visitados);
				}
			}
			return encontrado;
		}
	}

	// Ejercicio 4

	public static <E, T> boolean conexo(Grafo<E, T> g) {
		Iterator<Vertice<E>> itVer1 = g.vertices();
		while (itVer1.hasNext()) {
			Vertice<E> v = itVer1.next();
			Iterator<Vertice<E>> itVer2 = g.vertices();
			while (itVer2.hasNext()) {
				Vertice<E> w = itVer2.next();
				if (!w.equals(v)) {
					if (!hayCaminoEntreDos(g, v, w)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	// Ejercicio 5.

	private static <E, T> void escribirCamino(Vector<E> c) {
		for (int i = 0; i < c.size(); i++)
			System.out.print((c.elementAt(i)) + " ");
		System.out.println();
	}

	private static <E, T> void caminos(Grafo<E, T> g, Vertice<E> v,
			Vertice<E> w, Vector<Vertice<E>> visitados) {
		visitados.add(v);
		if (v.equals(w))
			escribirCamino(visitados);
		else {
			Iterator<Vertice<E>> adys = g.adyacentes(v);
			while (adys.hasNext()) {
				Vertice<E> u = adys.next();
				if (!visitados.contains(u))
					caminos(g, u, w, visitados);
			}
		}
		visitados.removeElementAt(visitados.size() - 1);
	}

	public static <E, T> void caminos(Grafo<E, T> g, Vertice<E> v, Vertice<E> w) {
		Vector<Vertice<E>> visitados = new Vector<Vertice<E>>();
		System.out.println("Los caminos entre " + v.getEtiqueta() + " y "
				+ w.getEtiqueta() + " son:");
		caminos(g, v, w, visitados);
		System.out.println();
	}

}
