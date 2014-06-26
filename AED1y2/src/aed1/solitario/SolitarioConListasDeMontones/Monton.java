package aed1.solitario.SolitarioConListasDeMontones;
import lista.IteradorLista;
import lista.Lista;
import lista.ListaEnlazada;

public abstract class Monton {
	Lista<Carta> cartas;

	public Monton() {
		cartas = new ListaEnlazada<Carta>();
	}

	public Carta getCarta() {
		IteradorLista<Carta> it=cartas.iteradorLista();
		if(it.hasPrevious()){
			return it.previous();
		}
		return null;
	}

	public Carta extraerCarta() {
		IteradorLista<Carta> it = cartas.iteradorLista();
		if(it.hasPrevious()){
			Carta ret = it.previous();
			cartas.suprimir(ret);
			return ret;
		}
		return null;
	}

	public abstract boolean insertarCarta(Carta c);

	public int getNumCartas() {
		return cartas.tamaño();
	}

	public boolean esVacio() {
		return cartas.esVacio();
	}

	public boolean estaLleno() {
		return false;
	}
	public String toString() {
		String ret = "";
		if (esVacio()) {
			ret = "[ ' , ' ]";
		} else {
			ret = getCarta().toString();
		}
		return ret;
	}
}
