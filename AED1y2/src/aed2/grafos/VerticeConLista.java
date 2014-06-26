package aed2.grafos;

import lista.*;

public class VerticeConLista<E, T> extends Vertice<E> {
	private Lista<VerticeAdyacente<E, T>> lisAdy;

	public VerticeConLista(E etiqueta) {
		super(etiqueta);
		lisAdy = new ListaEnlazada<VerticeAdyacente<E, T>>();
	}

	public Lista<VerticeAdyacente<E, T>> getLista() {
		return lisAdy;
	}

}
