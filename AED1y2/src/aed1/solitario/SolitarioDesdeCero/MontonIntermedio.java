package aed1.solitario.SolitarioDesdeCero;
public class MontonIntermedio {
	Carta[] cartas;
	int numCartas;
	boolean agregarCarta(Carta carta){
		if(
				(isEmpty()) 
				||
				(carta.numero > getLastCard().numero 
						&&
				 carta.palo != getLastCard().palo)
			){
			cartas[numCartas++] = carta;
			return true;
		}
		return false;
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
	boolean isEmpty(){
		return numCartas == 0;
	}
	Carta getLastCard(){
		return cartas[numCartas-1];
	}
}