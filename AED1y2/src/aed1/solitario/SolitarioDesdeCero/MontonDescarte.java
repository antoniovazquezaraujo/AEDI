package aed1.solitario.SolitarioDesdeCero;

public class MontonDescarte {
	Carta[] cartas;
	int numCartas;
	void agregarCarta(Carta carta){
		cartas[numCartas++] = carta;
	}
	Carta sacarCarta(){
		return cartas[numCartas--];
	}
	void volcar(Baraja baraja){
		for(int n=0;n<numCartas;n++){
			baraja.meterCarta(cartas[n]);
			sacarCarta();
		}
	}
	
}
