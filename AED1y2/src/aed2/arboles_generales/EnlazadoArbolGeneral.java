package aed2.arboles_generales;

public class EnlazadoArbolGeneral<E> implements ArbolGeneral<E> {
	private NodoGeneral<E> raiz;

	// constructores
	public EnlazadoArbolGeneral() {
		raiz = null;
	}

	public EnlazadoArbolGeneral(E elemRaiz, ArbolGeneral<E>... hijos)
			throws NullPointerException {
		if (hijos == null)
			throw new NullPointerException();
		if (hijos.length == 0)
			raiz = new NodoGeneral<E>(elemRaiz, null, null);
		else {
			EnlazadoArbolGeneral<E>[] datos = (EnlazadoArbolGeneral<E>[]) hijos;
			for (int i = 0; i < datos.length - 1; i++) {
				datos[i].raiz.setHer(datos[i + 1].raiz);
			}
			raiz = new NodoGeneral<E>(elemRaiz, datos[0].raiz, null);
		}
	}

	private EnlazadoArbolGeneral(NodoGeneral<E> raiz) {
		this.raiz = raiz;
	}

	public boolean esVacio() {
		return raiz == null;
	}

	public E raiz() throws ArbolVacioExcepcion {
		if (esVacio())
			throw new ArbolVacioExcepcion("raiz: �rbol vac�o");
		return raiz.getElemento();
	}

	public boolean esta(E elemento) {
		return esta(raiz, elemento);
	}

	private boolean esta(NodoGeneral<E> raiz, E elemento) {
		if (raiz == null)
			return false;
		if (raiz.getElemento().equals(elemento))
			return true;
		NodoGeneral<E> hijo = raiz.getHijo();
		while (hijo != null) {
			if (esta(hijo, elemento))
				return true;
			else
				hijo = hijo.getHer();
		}
		return false;
	}

	public ArbolGeneral<E> hijoMasIzq() throws ArbolVacioExcepcion {
		return hijoMasIzq(raiz);
	}

	private ArbolGeneral<E> hijoMasIzq(NodoGeneral<E> r) {
		if (esVacio()) {
			throw new ArbolVacioExcepcion("hijoIzq: �rbol vac�o");
		}
		if (r.getHijo() != null) {
			return hijoMasIzq(r);
		} else {
			return new EnlazadoArbolGeneral<E>(r);
		}
	}

	public ArbolGeneral<E> hermanoDer() throws ArbolVacioExcepcion {
		return hermanoDer(raiz);
	}

	private ArbolGeneral<E> hermanoDer(NodoGeneral<E> r) {
		if (esVacio())
			throw new ArbolVacioExcepcion("hijoDer: �rbol vac�o");
		if (r.getHer() == null) {
			return new EnlazadoArbolGeneral<E>(r);
		}
		return hermanoDer(r.getHer());
	}

	public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion {
		if (esVacio())
			throw new ArbolVacioExcepcion("raiz: �rbol vac�o");
		raiz.setElemento(elemRaiz);
	}

	public void setHijo(ArbolGeneral<E> hijo) throws ArbolVacioExcepcion,
			NullPointerException {
		if (hijo == null)
			throw new NullPointerException();
		if (esVacio())
			throw new ArbolVacioExcepcion("setHijoIzq: �rbol vac�o");
		if (hijoMasIzq().esVacio())
			raiz.setHijo(((EnlazadoArbolGeneral<E>) hijo).raiz);
		else {
			NodoGeneral<E> aux = raiz.getHijo();
			while (aux.getHer() != null) {
				aux = aux.getHer();
			}
			aux.setHer(((EnlazadoArbolGeneral<E>) hijo).raiz);
		}
	}

	public void suprimir() {
		raiz = null;
	}

}
