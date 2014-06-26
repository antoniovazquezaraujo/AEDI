package aed1.DoblementeEnlazadas;

public class DobleEnlazadaCentinelasCircular<E> {
	public DobleEnlazadaCentinelasCircular() {
		ultimo = new DobleNodo<E>(null, null, null);
	}

	public int numElementos() {
		int cont = 0;
		DobleNodo<E> actual = ultimo.getNext();
		while (actual != ultimo) {
			actual = actual.getNext();
			cont++;
		}
		return cont;
	}

	public int repeticiones(E elemento) {
		int cont = 0;
		DobleNodo<E> actual = ultimo.getNext();
		while (actual != ultimo) {
			if (actual.getElemento().equals(elemento)) {
				cont++;
			}
			actual = actual.getNext();
		}
		return cont;
	}

	public void insertarPrincipio(E elemento) {
		DobleNodo<E> nuevo = new DobleNodo<E>(ultimo, elemento,
				ultimo.getNext());
		ultimo.getNext().setPrev(nuevo);
		ultimo.setNext(nuevo);
	}

	public void insertarFinal(E elemento) {
		DobleNodo<E> nuevo = new DobleNodo<E>(ultimo.getPrev(), elemento,
				ultimo);
		ultimo.getPrev().setNext(nuevo);
		ultimo.setPrev(nuevo);
	}

	public boolean borrar(E elemento) {
		DobleNodo<E> actual = ultimo.getNext();
		while (actual != ultimo) {
			if (actual.getElemento().equals(elemento)) {
				actual.getPrev().setNext(actual.getNext());
				actual.getNext().setPrev(actual.getPrev());
				return true;
			}
			actual = actual.getNext();
		}
		return false;
	}

	private DobleNodo<E> ultimo;
}
