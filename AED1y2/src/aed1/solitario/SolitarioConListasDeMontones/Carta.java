package aed1.solitario.SolitarioConListasDeMontones;
public class Carta {// listo
	// Atributos
	private int num; // <=12
	private Palo palo; // Bastos, Espadas, Oros, Copas.

	public Carta(int num, Palo palo) {
		this.num = num;
		this.palo = palo;
	}

	public int getNum() {
		return num;
	}

	public Palo palo() {
		return palo;
	}

	public String toString() {
		return "[" + num + " , " + palo + "]";
	}

}
