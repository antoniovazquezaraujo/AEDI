package aed2.colas_de_prioridad;

public class Heap<E, T extends Comparable<T>> implements ColaPrioridad<E, T> {
	private static final int CAPACIDAD = 25;
	Par<E, T>[] elementos; // el vector del mont�culo
	int numElem; // n�mero de elementos del mont�culo.
	boolean ordenado; // cumple la propiedad de ordenaci�n

	@SuppressWarnings("unchecked")
	public Heap(T superior) {
		ordenado = true;
		numElem = 0;
		// vector=(Par<E,T>[]) new Object[CAPACIDAD+1];
		elementos = (Par<E, T>[]) new Par[CAPACIDAD + 1];
		elementos[0] = new Par<E, T>(null, superior);
	}

	// m�todos de la interface
	public boolean esVacio() {
		return numElem == 0;
	}

	public int tamaño() {
		return numElem;
	}

	public Par<E, T> primero() throws ColaPriorVaciaExcepcion {
		if (esVacio())
			throw new ColaPriorVaciaExcepcion("primero: Heap vac�o");
		if (!ordenado)
			arreglarHeap();
		return elementos[1];
	}

	public void insertar(Par<E, T> elemento) {
		if (!ordenado)
			introducir(elemento);
		else {
			if (numElem == elementos.length - 1)
				duplicarVector();
			int hueco = ++numElem;
			while ((elementos[hueco / 2].getPrioridad()).compareTo(elemento
					.getPrioridad()) < 0) {
				elementos[hueco] = elementos[hueco / 2];
				hueco /= 2;
			}
			elementos[hueco] = elemento;
		}
	}

	public Par<E, T> suprimir() throws ColaPriorVaciaExcepcion {
		if (esVacio()) {
			throw new ColaPriorVaciaExcepcion("suprimir: Heap vac�o");
		}
		if (!ordenado) {
			arreglarHeap();
		}
		Par<E, T> par = elementos[1];
		elementos[1] = elementos[numElem];
		elementos[numElem--] = null;
		hundir(1);
		return par;
	}

	private void hundir(int hueco) {
		int hijo = hueco * 2;
		Par<E, T> temp = elementos[hueco];
		while (hijo <= numElem) {
			if (hijo < numElem
					&& (elementos[hijo + 1].getPrioridad())
							.compareTo(elementos[hijo].getPrioridad()) > 0)
				hijo++;
			if ((elementos[hijo].getPrioridad()).compareTo(temp.getPrioridad()) > 0) {
				elementos[hueco] = elementos[hijo];
				hueco = hijo;
				hijo = hueco * 2;
			} else
				break;
		}
		elementos[hueco] = temp;
	}

	@SuppressWarnings("unchecked")
	private void duplicarVector() {
		Par<E, T>[] nuevoVector;
		nuevoVector = (Par<E, T>[]) new Par[elementos.length * 2];
		for (int i = 0; i < elementos.length; i++) {
			nuevoVector[i] = elementos[i];
		}
		elementos = nuevoVector;
	}

	// m�todos para mejorar la eficiencia del Heap
	public void introducir(Par<E, T> elemento) {
		// inserta en la cola sin mantener el orden del heap
		if (numElem == elementos.length - 1) {
			duplicarVector();
		}
		elementos[++numElem] = elemento;
		if ((elementos[numElem / 2].getPrioridad()).compareTo(elemento
				.getPrioridad()) < 0) {
			ordenado = false;
		}
	}

	private void arreglarHeap() {
		for (int i = numElem / 2; i > 0; i--) {
			hundir(i);
		}
		ordenado = true;
	}

	public String toString() {
		String toret = " ";
		for (int i = 1; i <= numElem; i++) {
			toret = toret + elementos[i].getPrioridad() + " ";
		}
		return toret;
	}

}