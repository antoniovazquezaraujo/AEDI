package aed1.ejercicios;

import java.util.Iterator;

import lista.Lista;
import lista.ListaEnlazada;

public class ListaInversa {
	public static <E> Lista<E> invertir(Lista<E> l) {
		Lista<E> ret = new ListaEnlazada<E>();
		Iterator<E> i = l.iterator();
		while (i.hasNext()) {
			ret.insertarPrincipio(i.next());
		}
		Iterator<E> i2 = l.iterator();
		while (i2.hasNext()) {
			ret.insertarPrincipio(i2.next());
		}
		return ret;
	}

	public static void main(String[] args) {
		Lista<Integer> i = new ListaEnlazada<Integer>();
		for (int n = 0; n < 10; n++) {
			i.insertarPrincipio(n);
		}
		invertir(i);
		Iterator<Integer> it = i.iterator();
		int n = 9;
		while (it.hasNext()) {
			assert (it.next() == n--);
		}
		System.out.println("OK");
	}
}
