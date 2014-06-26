package aed1.solitario.SolitarioConArrays;
public class Descarte extends Monton {

	public Descarte() {
	
	}
	
	public Carta extraerCarta() {
			return super.extraerCarta();
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


	public boolean insertarCarta(Carta c) {
		cartas[numCartas++] = c;
		return true;
	}

}
