package aed1.solitario.SolitarioDesdeCero;

public class Baraja {
	Carta[] cartas;
	int numCartas;
	Baraja(){
		reset();
	}
	private void reset() {
		numCartas = 0;
		cartas = new Carta[48];
		for(int palo=0; palo<4;palo++){
			for(int carta= 0; carta<12; carta++){
				cartas[palo*12+carta]= new Carta(palo, carta);
				numCartas++;
			}
		}
	}
	private void swap(int a, int b) {
		Carta tmp = cartas[b];
		cartas[b] = cartas[a];
		cartas[a] = tmp;
	}

	void barajar() {
		for (int n = 0; n < numCartas; n++) {
			int rndPos = rndPos();
			swap(n, rndPos);
		}
	}
	boolean isEmpty() {
		return numCartas == 0;
	}
	private int rndPos() {
		return (int) (Math.random() * numCartas);
	}
	Carta sacarCarta(){
		return cartas[numCartas--];
	}
	void meterCarta(Carta carta){
		cartas[numCartas++]= carta;
	}
	
}
