package aed1.doblementeEnlazadas;

public class EnlazadaCircular<E> {

	// Crear la estructura vac�a (m�todo constructor)
	public EnlazadaCircular() {
		fin = null;
	}

	// Contar el n�mero de veces que aparece un elemento en la lista
	public int contar(E elemento) {
		int cont = 0;
		if (fin != null) {
			Nodo<E> actual = fin;
			do {
				if (actual.getDato().equals(elemento)) {
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
			ret = fin.getNext().getDato();
		}
		return ret;
	}

	// Insertar un elemento al final de la lista
	public void insertar(E elemento) {
		Nodo<E> nuevo = new Nodo<E>(elemento, null);
		if (fin != null) {
			nuevo.setNext(fin.getNext());
			fin.setNext(nuevo);
		} else {
			nuevo.setNext(nuevo);
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
			}
		}
	}

	private Nodo<E> fin;

	// /////////////////////////////////////////////////
	public Nodo<E> getFin() {
		return fin;
	}

	public boolean isEmpty() {
		return fin == null;
	}
}
