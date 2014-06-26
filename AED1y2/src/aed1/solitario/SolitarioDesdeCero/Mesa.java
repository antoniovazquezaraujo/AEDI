package aed1.solitario.SolitarioDesdeCero;

public class Mesa {
	final int NUM_MONTONES_FINALES = 4;
	final int NUM_MONTONES_INTERMEDIOS = 4;
	
	Baraja baraja;
	MontonFinal[] montonesFinales;
	MontonIntermedio[] montonesIntermedios;
	MontonDescarte descarte;
	Mesa(){
		baraja = new Baraja();
		descarte = new MontonDescarte();
		for(int i = 0; i< NUM_MONTONES_FINALES; i++){
			montonesFinales[i] = new MontonFinal();
		}
		for(int i = 0; i< NUM_MONTONES_INTERMEDIOS; i++){
			montonesIntermedios[i] = new MontonIntermedio();
		}
	}
	Carta extraerBaraja(){
		return baraja.sacarCarta();
	}
	Carta extraerMontonFinal(int numMonton){
		return montonesFinales[numMonton].sacarCarta();
	}
	boolean agregarMontonFinal(int numMonton, Carta carta){
		return montonesFinales[numMonton].agregarCarta(carta);
	}
	Carta extraerMontonIntermedio(int numMonton){
		return montonesIntermedios[numMonton].sacarCarta();
	}
	boolean agregarMontonIntermedio(int numMonton, Carta carta){
		return montonesIntermedios[numMonton].agregarCarta(carta);
	}
	Carta extraerDescarte(){
		return descarte.sacarCarta();
	}
	void agregarDescarte(Carta carta){
		descarte.agregarCarta(carta);
	}
	public String toString(){
		return "toString de mesa";
	}
}
