package aed1.ejercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lista.Lista;
import lista.ListaEnlazada;

public class MezclaListas {
	public static <E> Lista<E> mezclar(Lista<E> l1, Lista<E> l2) {
		Lista<E> ret = new ListaEnlazada<E>();
		Iterator<E> i1 = l1.iterator();
		Iterator<E> i2 = l1.iterator();
		while (i1.hasNext() && i2.hasNext()) {
			ret.insertarFinal(i1.next());
			ret.insertarFinal(i2.next());
		}
		while (i1.hasNext()) {
			ret.insertarFinal(i1.next());
		}
		while (i2.hasNext()) {
			ret.insertarFinal(i2.next());
		}
		return ret;
	}
}
