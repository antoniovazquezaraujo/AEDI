package aed1.DoblementeEnlazadas;

public class DobleEnlazadaCentinelas<E> {
	public DobleEnlazadaCentinelas() {
		primero = new DobleNodo<E>(null, null, null);
		ultimo = new DobleNodo<E>(primero, null, null);
		primero.setNext(ultimo);
	}

	public int numElementos() {
		int cont = 0;
		DobleNodo<E> actual = primero.getNext();
		while (actual != ultimo) {
			actual = actual.getNext();
			cont++;
		}
		return cont;
	}

	public int repeticiones(E elemento) {
		int cont = 0;
		DobleNodo<E> actual = primero.getNext();
		while (actual != ultimo) {
			if (actual.getElemento().equals(elemento)) {
				cont++;
			}
			actual = actual.getNext();
		}
		return cont;
	}

	public void insertarPrincipio(E elemento) {
		DobleNodo<E> nuevo = new DobleNodo<E>(primero, elemento,
				primero.getNext());
		primero.getNext().setPrev(nuevo);
		primero.setNext(nuevo);
	}

	public void insertarFinal(E elemento) {
		DobleNodo<E> nuevo = new DobleNodo<E>(ultimo.getPrev(), elemento,
				ultimo);
		ultimo.getPrev().setNext(nuevo);
		ultimo.setPrev(nuevo);
	}

	public boolean borrar(E elemento) {
		DobleNodo<E> actual = primero.getNext();
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

	private DobleNodo<E> primero, ultimo;
}
