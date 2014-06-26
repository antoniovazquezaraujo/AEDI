package aed1.doblementeEnlazadas;

public class DobleEnlazadaCircular<E> {

	// Crear la estructura vac�a (m�todo constructor)
	public DobleEnlazadaCircular() {
		fin = null;
	}

	// Contar el n�mero de veces que aparece un elemento en la lista
	public int contar(E elemento) {
		int cont = 0;
		if (fin != null) {
			DobleNodo<E> actual = fin;
			do {
				if (actual.getElemento().equals(elemento)) {
					cont++;
				}
				actual = actual.getNext();
			} while (actual != fin);
		}
		return cont;
	}

	// Devolver el elemento que est� de primero en la lista; si la lista est�
	// vac�a devuelve null.
	public E primero() {
		E ret = null;
		if (fin != null) {
			ret = fin.getNext().getElemento();
		}
		return ret;
	}

	// Insertar un elemento al final de la lista
	public void insertar(E elemento) {
		DobleNodo<E> nuevo = new DobleNodo<E>(null, elemento, null);
		if (fin != null) {
			nuevo.setPrev(fin);
			nuevo.setNext(fin.getNext());
			fin.setNext(nuevo);
		} else {
			nuevo.setNext(nuevo);
			nuevo.setPrev(fin);
		}
		fin = nuevo;
	}

	// Borrar el elemento al principio de la lista
	public void borrarPrimero() {
		if (fin != null) {
			if (fin.getNext() == fin) {
				fin = null;
			} else {
				fin.setNext(fin.getNext().getNext());
				fin.getNext().setPrev(fin);
			}
		}
	}

	private DobleNodo<E> fin;

	// /////////////////////////////////////////////////
	public DobleNodo<E> getFin() {
		return fin;
	}

	public boolean isEmpty() {
		return fin == null;
	}
}
