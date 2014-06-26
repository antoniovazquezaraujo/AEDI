package aed1.solitario.SolitarioConArrays;
public class MontonFinal extends Monton {

	public boolean estaLleno() {
		return !esVacio() && getCarta().getNum() == 12;
	}

	public boolean insertarCarta(Carta c) {
		if (puedoInsertar(c)) {
			cartas[numCartas++] =c;
			return true;
		}
		return false;
	}

	public boolean puedoInsertar(Carta c) {
		if (esVacio()) {
			if (c.getNum() == 1) {
				return true;
			}
		} else {
			if (c.getNum() == getCarta().getNum()+ 1 
					&& c.palo().equals(getCarta().palo())) {
				return true;
			}
		}
		return false;
	}
}
