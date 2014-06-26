package aed1.solitario.SolitarioDesdeCero;

public class Carta {
	Carta(){
		this(0,0);
	}
	Carta(int numero, int palo){
		this.numero = numero;
		this.palo = palo;
	}
	int numero;
	int palo;
}
