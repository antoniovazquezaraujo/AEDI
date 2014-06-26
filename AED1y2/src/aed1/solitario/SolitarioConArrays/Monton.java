package aed1.solitario.SolitarioConArrays;


public abstract class Monton {
	Carta[] cartas;
	int numCartas;

	public Monton() {
		numCartas = 0;
		cartas = new Carta[48];
	}

	public Carta getCarta() {
		if (numCartas > 0) {
			return cartas[numCartas];
		}
		return null;
	}

	public Carta extraerCarta() {
		if (numCartas > 0) {
			Carta ret = cartas[numCartas];
			numCartas--;
			return ret;
		}
		return null;
	}

	public abstract boolean insertarCarta(Carta c);

	public int getNumCartas() {
		return numCartas;
	}

	public boolean esVacio() {
		return numCartas == 0;
	}

	public boolean estaLleno() {
		return numCartas == 48;
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
