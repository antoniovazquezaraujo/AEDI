package aed1.solitario.SolitarioConArrays;
public class Mesa {
	private Baraja baraja;
	private Descarte descarte;
	private Monton[] montonesFinales;
	private Monton[] montonesIntermedios;
	private final int MAX_MONTONES;
	private int numCartasFinal;
	private boolean tablas;

	public Mesa() {
		MAX_MONTONES = 4;
		baraja = new Baraja();
		descarte = new Descarte();
		montonesFinales = new Monton[MAX_MONTONES];
		for (int i = 0; i < MAX_MONTONES; i++) {
			montonesFinales[i] = new MontonFinal();
		}
		montonesIntermedios = new Monton[MAX_MONTONES];
		for (int i = 0; i < MAX_MONTONES; i++) {
			montonesIntermedios[i] = new MontonIntermedio();
		}
		numCartasFinal = 0;
		tablas = false;
	}

	public Monton getMontonIntermedio(int pos) {
		return montonesIntermedios[pos];
	}

	public Monton getMontonFinal(int pos) {
		return montonesFinales[pos];
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
		return montonesFinales[pos].extraerCarta();
	}

	public Carta extraerCartaDeMontonIntermedio(int pos) {
		return montonesIntermedios[pos].extraerCarta();
	}

	public boolean insertarDescarte(Carta c) {
		return descarte.insertarCarta(c);
	}

	public boolean insertarMontonFinal(Carta c, int pos) {
		return montonesFinales[pos].insertarCarta(c);
	}

	public boolean insertarMontonIntermedio(Carta c, int pos) {
		return montonesIntermedios[pos].insertarCarta(c);
	}

	public boolean ganar() {
		for (int i = 0; i < MAX_MONTONES; i++) {
			if (!montonesFinales[i].estaLleno()) {
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
			ret += montonesFinales[i].toString() + "\t";
		}
		ret += "\n\n\t\t    Montontes Intermedios\n";
		for (int i = 0; i < MAX_MONTONES; i++) {
			ret += montonesIntermedios[i].toString() + "\t";
		}
		return ret;
	}
}
