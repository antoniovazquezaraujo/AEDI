package aed1.ejercicios;

import java.util.Iterator;

import lista.Lista;
import lista.ListaEnlazada;

public class IgualNumeroDeVeces {
	public static <E> int numCopias(Lista<E> l, E elemento) {
		int copias = 0;
		Iterator<E> i1 = l.iterator();
		while (i1.hasNext()) {
			if (i1.next().equals(elemento)) {
				copias++;
			}
		}
		return copias;
	}

	public static <E> boolean todosIgualNumeroDeCopias(Lista<E> l) {
		int numVeces = 0;
		Iterator<E> i = l.iterator();
		if (i.hasNext()) {
			numVeces = numCopias(l, i.next());
		}
		while (i.hasNext()) {
			if (numVeces != numCopias(l, i.next())) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Lista<Integer> l = new ListaEnlazada<Integer>();
		for (int n = 0; n < 10; n++) {
			l.insertarPrincipio(n);
		}
		for (int n = 0; n < 10; n++) {
			l.insertarPrincipio(n);
		}
		assert (todosIgualNumeroDeCopias(l));
		System.out.println("Ok");

	}
}
