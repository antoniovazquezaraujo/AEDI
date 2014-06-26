package aed1.solitario.SolitarioConListasDeMontones;
public class MontonIntermedio extends Monton {
	public boolean insertarCarta(Carta c) {
		if (puedoInsertar(c)) {
			cartas.insertarFinal(c);
			return true;
		}
		return false;
	}

	public boolean puedoInsertar(Carta c) {
		return (esVacio() || getCarta().getNum() + 1 == c.getNum()
				&& !getCarta().palo().equals(c.palo()));
	}

	public String toString() {
		String ret = "";
		if (esVacio()) {
			ret = "[ ' , ' ]";
		} else {
			if (getNumCartas() > 1) {
				Carta ultima = extraerCarta();
				Carta penultima = getCarta();
				ret = "{" + penultima.toString() + ",  " + ultima.toString()
						+ "}";
				insertarCarta(ultima);
			} else {
				ret = getCarta().toString();
			}
		}
		return ret;
	}
}
