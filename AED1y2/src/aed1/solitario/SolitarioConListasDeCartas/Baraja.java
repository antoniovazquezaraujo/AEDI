package aed1.solitario.SolitarioConListasDeCartas;
public class Baraja extends Monton {

	public Baraja() {
		for (int i = 1; i <= 12; i++) {
			insertarCarta(new Carta(i, Palo.OROS));
			insertarCarta(new Carta(i, Palo.ESPADAS));
			insertarCarta(new Carta(i, Palo.BASTOS));
			insertarCarta(new Carta(i, Palo.COPAS));
		}
		barajar();
	}

	private void barajar() {
		Carta[] temporal = new Carta[48];
		while (!cartas.esVacio()) {
			int r = (int) (Math.random() * 48);
			if (temporal[r] == null) {
				temporal[r] = extraerCarta();
			}
		}
		for (int i = 0; i < temporal.length; i++) {
			insertarCarta(temporal[i]);
		}

	}

	public boolean insertarCarta(Carta c) {
		if (puedoInsertar(c)) {
			cartas.insertarFinal(c);
			return true;
		}
		return false;
	}

	public boolean puedoInsertar(Carta c) {
		return true;
	}
}
