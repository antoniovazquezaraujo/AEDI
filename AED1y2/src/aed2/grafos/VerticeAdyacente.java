package aed2.grafos;

public class VerticeAdyacente<E, T> {
	private Vertice<E> v;
	private T etiqueta;

	VerticeAdyacente(Vertice<E> v, T etiqueta) {
		this.v = v;
		this.etiqueta = etiqueta;
	}

	Vertice<E> getVertice() {
		return v;
	}

	T getEtiqueta() {
		return etiqueta;
	}
}