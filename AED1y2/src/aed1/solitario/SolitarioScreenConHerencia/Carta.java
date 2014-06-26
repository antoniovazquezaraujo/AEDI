package aed1.solitario.SolitarioScreenConHerencia;

public class Carta {
	public static final int MAX_CARD = 10;

	public char getPaloChar() {
		return paloToChar(palo);
	}

	public Palo getPalo() {
		return palo;
	}

	public static int paloToInt(Palo palo) {
		int ret = 0;
		switch (palo) {
		case OROS:
			ret = 0;
			break;
		case COPAS:
			ret = 1;
			break;
		case ESPADAS:
			ret = 2;
			break;
		case BASTOS:
			ret = 3;
			break;
		}
		return ret;

	}

	public static Palo intToPalo(int n) {
		switch (n) {
		case 0:
			return Palo.OROS;
		case 1:
			return Palo.COPAS;
		case 2:
			return Palo.ESPADAS;
		case 3:
			return Palo.BASTOS;
		}
		// No es ninguno????
		return Palo.OROS;
	}

	public static char paloToChar(Palo palo) {
		char ret = ' ';
		switch (palo) {
		case OROS:
			ret = '*';
			break;
		case COPAS:
			ret = 'Y';
			break;
		case ESPADAS:
			ret = '/';
			break;
		case BASTOS:
			ret = ')';
			break;
		}
		return ret;
	}

	public char getSimbol() {
		char ret;
		switch (valor) {
		case 8:
			ret = 'S';
			break;
		case 9:
			ret = 'C';
			break;
		case 10:
			ret = 'R';
			break;
		default:
			ret = (char) ('0' + valor);
		}
		return ret;
	}

	public static final int ALTO = 5;
	public static final int ANCHO = 6;
	public int valor;
	public Palo palo;

	public Carta() {
		this(0, Palo.OROS);
	}

	public Carta(int valor, Palo palo) {
		this.valor = valor;
		this.palo = palo;
	}

	public boolean isApilable(Carta c) {
		return valor+1 == c.valor && palo == c.palo;
	}
	@Override
	public boolean equals(Object c){
		return valor == ((Carta)c).valor && palo == ((Carta)c).palo;
	}
	public String toString(){
		return ""+getSimbol()+getPaloChar(); 
	}

}