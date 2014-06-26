package aed2.colas_de_prioridad;

public class Par<E, T extends Comparable<T>> {
	private E elemento;
	private T prioridad;

	public Par(E e, T p) {
		elemento = e;
		prioridad = p;
	}

	public E getElemento() {
		return elemento;
	}

	public T getPrioridad() {
		return prioridad;
	}

	public void setElemento(E e) {
		elemento = e;
	}

	public void setPrioridad(T p) {
		prioridad = p;
	}
}
