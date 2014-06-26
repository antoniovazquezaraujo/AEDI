package aed2.arboles_generales;

public class NodoGeneral<E> {

	private E elemento;
	private NodoGeneral<E> hijo;
	private NodoGeneral<E> hermano;

	// constructores
	public NodoGeneral(E e, NodoGeneral<E> hi, NodoGeneral<E> he) {
		elemento = e;
		hijo = hi;
		hermano = he;
	}

	public NodoGeneral() {
		this(null, null, null);
	}

	// m�todos
	public E getElemento() {
		return elemento;
	}

	public NodoGeneral<E> getHijo() {
		return hijo;
	}

	public NodoGeneral<E> getHer() {
		return hermano;
	}

	public void setElemento(E e) {
		elemento = e;
	}

	public void setHijo(NodoGeneral<E> hi) {
		hijo = hi;
	}

	public void setHer(NodoGeneral<E> he) {
		hermano = he;
	}

}
