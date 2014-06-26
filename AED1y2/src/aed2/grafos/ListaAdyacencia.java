package aed2.grafos;

import lista.*;
import java.util.Iterator;
import java.util.Vector;

public class ListaAdyacencia<E, T> implements Grafo<E, T> {
	private Lista<VerticeConLista<E, T>> listaVertices;
	private int numVertices;

	public ListaAdyacencia() {
		listaVertices = new ListaEnlazada<VerticeConLista<E, T>>();
		numVertices = 0;
	}

	public boolean esVacio() {
		return numVertices == 0;
	}

	public boolean estaVertice(Vertice<E> v) {
		for (VerticeConLista<E, T> p : listaVertices)
			if (p.getEtiqueta().equals(v.getEtiqueta()))
				return true;
		return false;
	}

	public boolean estaArco(Arco<E, T> a) {
		for (VerticeConLista<E, T> p : listaVertices) {
			if (p.getEtiqueta().equals(a.getOrigen().getEtiqueta())) {
				Lista<VerticeAdyacente<E, T>> l = p.getLista();
				for (VerticeAdyacente<E, T> q : l) {
					if (q.getVertice().equals(a.getDestino())
							&& q.getEtiqueta().equals(a.getEtiqueta())) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public Iterator<Vertice<E>> vertices() {
		Vector<Vertice<E>> vertices = new Vector<Vertice<E>>();
		for (VerticeConLista<E, T> p : listaVertices) {
			vertices.add(new Vertice<E>(p.getEtiqueta()));
		}
		return vertices.iterator();
	}

	public Iterator<Arco<E, T>> arcos() {
		Vector<Arco<E, T>> arcos = new Vector<Arco<E, T>>();
		for (VerticeConLista<E, T> p : listaVertices) {
			Vertice<E> origen = new Vertice<E>(p.getEtiqueta());
			Lista<VerticeAdyacente<E, T>> l = p.getLista();
			for (VerticeAdyacente<E, T> q : l) {
				Vertice<E> destino = q.getVertice();
				T etiqueta = q.getEtiqueta();
				arcos.add(new Arco<E, T>(origen, destino, etiqueta));
			}
		}
		return arcos.iterator();
	}

	public Iterator<Vertice<E>> adyacentes(Vertice<E> v) {
		Vector<Vertice<E>> vertices = new Vector<Vertice<E>>();
		for (VerticeConLista<E, T> p : listaVertices) {
			if (p.getEtiqueta().equals(v.getEtiqueta())) {
				Lista<VerticeAdyacente<E, T>> l = p.getLista();
				for (VerticeAdyacente<E, T> q : l) {
					vertices.add(q.getVertice());
				}
			}
		}

		return vertices.iterator();
	}

	public void insertarVertice(Vertice<E> v) {
		if (!estaVertice(v)) {
			VerticeConLista<E, T> vl = new VerticeConLista<E, T>(
					v.getEtiqueta());
			numVertices++;
			listaVertices.insertarFinal(vl);
		}
	}

	public void insertarArco(Arco<E, T> a) {

		if (!estaArco(a)) {
			// mirar si los v�rtices origen y destino est�n en el grafo
			if (!estaVertice(a.getOrigen()))
				insertarVertice(a.getOrigen());
			if (!estaVertice(a.getDestino()))
				insertarVertice(a.getDestino());
			// inserta el arco
			for (VerticeConLista<E, T> p : listaVertices)
				if (p.getEtiqueta().equals(a.getOrigen().getEtiqueta())) {
					Lista<VerticeAdyacente<E, T>> l = p.getLista();
					l.insertarFinal(new VerticeAdyacente<E, T>(a.getDestino(),
							a.getEtiqueta()));
				}
		}
	}

	public void eliminarVertice(Vertice<E> v) {

		// actualiza listVertices
		Iterator<VerticeConLista<E, T>> itr = listaVertices.iterator();
		while (itr.hasNext()) {
			VerticeConLista<E, T> p = itr.next();
			if (p.getEtiqueta().equals(v.getEtiqueta())) {
				listaVertices.suprimir(p);
				numVertices--;
			} else {
				Lista<VerticeAdyacente<E, T>> l = p.getLista();
				Iterator<VerticeAdyacente<E, T>> itr2 = l.iterator();
				while (itr2.hasNext()) {
					VerticeAdyacente<E, T> q = itr2.next();
					if (q.getEtiqueta().equals(v.getEtiqueta()))
						l.suprimir(q);
				}
			}
		}
	}

	public void eliminarArco(Arco<E, T> a) {
		for (VerticeConLista<E, T> p : listaVertices)
			if (p.getEtiqueta().equals(a.getOrigen().getEtiqueta())) {
				Lista<VerticeAdyacente<E, T>> l = p.getLista();
				Iterator<VerticeAdyacente<E, T>> itr = l.iterator();
				while (itr.hasNext()) {
					VerticeAdyacente<E, T> q = itr.next();
					if (q.getVertice().equals(a.getDestino()))
						l.suprimir(q);
				}
			}
	}

}
