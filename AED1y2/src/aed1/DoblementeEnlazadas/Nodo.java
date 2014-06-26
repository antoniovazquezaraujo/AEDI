package aed1.DoblementeEnlazadas;

public class Nodo<T> {
	public Nodo(T dato, Nodo<T> next) {
		this.dato = dato;
		this.next = next;
	}

	public Nodo<T> getNext() {
		return next;
	}

	public void setNext(Nodo<T> next) {
		this.next = next;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	Nodo<T> next;
	T dato;
}
