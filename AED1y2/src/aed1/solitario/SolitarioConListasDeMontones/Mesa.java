package aed1.solitario.SolitarioConListasDeMontones;

import java.util.Iterator;

import lista.Lista;
import lista.ListaEnlazada;

public class Mesa {
	private Baraja baraja;
	private Descarte descarte;
	private Lista<Monton> montonesFinales;
	private Lista<Monton> montonesIntermedios;
	private final int MAX_MONTONES;
	private int numCartasFinal;
	private boolean tablas;

	public Mesa() {
		MAX_MONTONES = 4;
		baraja = new Baraja();
		descarte = new Descarte();
		montonesFinales = new ListaEnlazada<Monton>();
		for (int i = 0; i < MAX_MONTONES; i++) {
			montonesFinales.insertarFinal(new MontonFinal());
		}
		montonesIntermedios= new ListaEnlazada<Monton>();
		for (int i = 0; i < MAX_MONTONES; i++) {
			montonesIntermedios.insertarFinal(new MontonIntermedio());
		}
		numCartasFinal = 0;
		tablas = false;
	}

	public Monton getMontonIntermedio(int pos) {
		int numMonton = 0;
		Monton ret= null;
		Iterator<Monton> i = montonesIntermedios.iterator();
		while(i.hasNext() && numMonton++ <= pos){
			ret = i.next();
		}
		return ret;
	}

	public Monton getMontonFinal(int pos) {
		int numMonton = 0;
		Monton ret= null;
		Iterator<Monton> i = montonesFinales.iterator();
		while(i.hasNext() && numMonton++ <= pos){
			ret = i.next();
		}
		return ret;
	}

	public Monton getDescarte() {
		return descarte;
	}

	public Carta extraerCartaDeBaraja() {
		return baraja.extraerCarta();
	}

	public Carta extraerCartaDeDescarte() {
		return descarte.extraerCarta();
	}

	public Carta extraerCartaDeMontonFinal(int pos) {
		return getMontonFinal(pos).extraerCarta();
	}

	public Carta extraerCartaDeMontonIntermedio(int pos) {
		return getMontonIntermedio(pos).extraerCarta();
	}

	public boolean insertarDescarte(Carta c) {
		return descarte.insertarCarta(c);
	}

	public boolean insertarMontonFinal(Carta c, int pos) {
		return getMontonFinal(pos).insertarCarta(c);
	}

	public boolean insertarMontonIntermedio(Carta c, int pos) {
		return getMontonIntermedio(pos).insertarCarta(c);
	}

	public boolean ganar() {
		for (int i = 0; i < MAX_MONTONES; i++) {
			if (!getMontonFinal(i).estaLleno()) {
				return false;
			}
		}
		return true;
	}

	public boolean tablas() {
		return tablas;
	}

	public void volcar() {
		int numCartasEnDescarte = descarte.getNumCartas();
		if (numCartasFinal == numCartasEnDescarte) {
			tablas = true;
		} else {
			numCartasFinal = numCartasEnDescarte;
			for (int i = 0; i < numCartasEnDescarte; i++) {
				baraja.insertarCarta(descarte.extraerCarta());
			}
		}
	}

	public int getNumCartasBaraja() {
		return baraja.getNumCartas();
	}

	public void sacarBarajaADescarte() {
		int numCartas = 3;
		if(getNumCartasBaraja() < 3){
			numCartas = getNumCartasBaraja();
		}
		if(numCartas > 0){
			for(int n=0; n<numCartas; n++){
				insertarDescarte(extraerCartaDeBaraja());
			}
		} else {
			volcar();
		}
	}

	public String toString() {//
		String ret;
		ret = " Baraja" + "\t\t" + "Descarte:\n" + "[ ' , ' ]\t"
				+ descarte.toString() + "\n\n\t\t    Montones Finales\n";

		for (int i = 0; i < MAX_MONTONES; i++) {
			ret += getMontonFinal(i).toString() + "\t";
		}
		ret += "\n\n\t\t    Montontes Intermedios\n";
		for (int i = 0; i < MAX_MONTONES; i++) {
			ret += getMontonIntermedio(i).toString() + "\t";
		}
		return ret;
	}
}
