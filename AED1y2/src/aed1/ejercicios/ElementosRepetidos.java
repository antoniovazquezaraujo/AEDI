package aed1.ejercicios;

import java.util.Iterator;

import lista.Lista;
import lista.ListaEnlazada;

public class ElementosRepetidos {
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

	public static <E> Lista<E> elementosRepetidos(Lista<E> l) {
		Lista<E> ret = new ListaEnlazada<E>();
		Iterator<E> i1 = l.iterator();
		while (i1.hasNext()) {
			E elemento = i1.next();
			if (numCopias(l, elemento) > 1) {
				ret.insertarFinal(elemento);
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		Lista<Integer> l = new ListaEnlazada<Integer>();
		for (int n = 0; n < 10; n++) {
			l.insertarPrincipio(n);
		}
		for (int n = 0; n < 5; n++) {
			l.insertarPrincipio(n);
		}

		l.insertarPrincipio(3);

		Lista<Integer> repetidos = elementosRepetidos(l);
		Iterator<Integer> it = repetidos.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
