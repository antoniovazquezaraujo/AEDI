package aed1.tads;

import pila.EnlazadaPila;
import pila.Pila;

public class Pilas {
	public static void main(String[] args) {
		System.out.println("Hola");
		Conjunto<Integer> p;
		Conjunto<Character> q;
	}
}

class Conjunto<E> {
	Pila<E> pila;

	public Conjunto() {
		pila = new EnlazadaPila<E>();
	}

	public boolean esVacio() {
		return pila.esVacio();
	}

	public void push(E elemento) {
		pila.push(elemento);
	}

	public String toString() {
		String ret = null;
		Pila<E> aux = new EnlazadaPila<E>();
		while (!pila.esVacio()) {
			ret += pila.top().toString();
			aux.push(pila.pop());
		}
		for (; !aux.esVacio(); aux.pop()) {
			pila.push(aux.top());
		}
		return ret;
	}
}
