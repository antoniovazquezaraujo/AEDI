package aed1.doblementeEnlazadas;

public class DobleNodo<E> {

	public DobleNodo(DobleNodo<E> prev, E elemento, DobleNodo<E> next) {
		this.prev = prev;
		this.elemento = elemento;
		this.next = next;
	}

	public E getElemento() {
		return elemento;
	}

	public void setElemento(E elemento) {
		this.elemento = elemento;
	}

	public DobleNodo<E> getNext() {
		return next;
	}

	public void setNext(DobleNodo<E> next) {
		this.next = next;
	}

	public DobleNodo<E> getPrev() {
		return prev;
	}

	public void setPrev(DobleNodo<E> prev) {
		this.prev = prev;
	}

	private E elemento;
	private DobleNodo<E> next, prev;
}
