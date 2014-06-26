package aed2.grafos;

public class Vertice<E> {
	private E etiqueta;

	public Vertice(E etiqueta) {
		this.etiqueta = etiqueta;
	}

	public E getEtiqueta() {
		return etiqueta;
	}

	public boolean equals(Vertice<E> v) {
		return etiqueta.equals(v.getEtiqueta());
	}

	public String toString() {
		return " " + etiqueta;
	}
}
