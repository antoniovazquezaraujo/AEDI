package aed1.DoblementeEnlazadas;

public class DoblementeEnlazada<E> {
	// Crear la lista vac�a, es decir, sin nodos (m�todo constructor)
	// Contar el n�mero de veces que aparece un elemento en la lista
	// Insertar un elemento al principio de la lista
	// Insertar un elemento al final de la lista
	// Borrar un elemento que se pasa como par�metro

	public DoblementeEnlazada() {
		primero = ultimo = null;
	}

	public int contarApariciones(E elemento) {
		DobleNodo<E> actual;
		int cont = 0;
		actual = primero;
		while (actual != null) {
			if (actual.getElemento().equals(elemento)) {
				cont++;
			}
			actual = actual.getNext();
		}
		return cont;
	}

	public void insertarPrincipio(E elemento) {
		DobleNodo<E> nuevo = new DobleNodo<E>(primero, elemento, ultimo);
		if (primero == null && ultimo == null) {
			primero = nuevo;
			ultimo = nuevo;
		} else {
			nuevo.setNext(primero);
			nuevo.setPrev(null);
			primero.setPrev(nuevo);
			primero = nuevo;
		}
	}

	public void insertarFinal(E elemento) {
		DobleNodo<E> nuevo = new DobleNodo<E>(primero, elemento, ultimo);
		if (primero == null && ultimo == null) {
			primero = nuevo;
			ultimo = nuevo;
		} else {
			nuevo.setPrev(ultimo);
			nuevo.setNext(null);
			ultimo.setNext(nuevo);
			ultimo = nuevo;
		}

	}

	public boolean borrar(E elemento) {

		for (DobleNodo<E> actual = primero; actual != null; actual = actual
				.getNext()) {
			if (actual.getElemento().equals(elemento)) {
				actual.getPrev().setNext(actual.getNext());
				actual.getNext().setPrev(actual.getPrev());
				return true;
			}
		}
		return false;
	}

	private DobleNodo<E> primero, ultimo;
}
