package aed1.solitario.SolitarioScreen;

class Juego {
	// Colocacion de los montones en el array:
	// montones [BARAJA, DESCARTE, FINALES+0, FINALES+1, FINALES+2, FINALES+3,
	// INTERMEDIOS+0, INTERMEDIOS+1...]
	final int NUM_INTERMEDIOS = 7;
	final int NUM_FINALES = 4;
	final int BARAJA = 0;
	final int DESCARTE = 1;
	final int FINALES = 2;
	final int INTERMEDIOS = FINALES + NUM_FINALES;
	// BARAJA+DESCARTE = "1+1" contamos los dos al principio del array
	final int NUM_MONTONES = 1 + 1 + NUM_FINALES + NUM_INTERMEDIOS;
	boolean movingCard;
	Monton montonSeleccionado;
	Monton[] montones;

	Juego() {
		montones = new Monton[NUM_MONTONES];
		movingCard = false;
		montonSeleccionado = null;
		//baraja
		int numMonton=BARAJA;
		montones[numMonton]= new Monton();
		assert(getBaraja().isEmpty());
		getBaraja().reset();
		assert(!getBaraja().isEmpty());
		getBaraja().shuffle();
		//descarte
		numMonton=DESCARTE;
		montones[numMonton]= new Monton();

		//finales
		for (int n = FINALES; n < FINALES+NUM_FINALES; n++) {
			montones[n] = new Monton();
		}
		//intermedios
		for (int n = INTERMEDIOS; n < INTERMEDIOS+NUM_INTERMEDIOS; n++) {
			montones[n] = new Monton();
			for(int carta=0; carta<n-INTERMEDIOS;carta++){
				montones[n].addCard(getBaraja().extractCard());
			}
		}
	}

	Monton getBaraja() {
		return montones[BARAJA];
	}

	Monton getDescarte() {
		return montones[DESCARTE];
	}

	Monton getMontonFinal(int num) {
		return montones[FINALES + num];
	}

	Monton getMontonIntermedio(int num) {
		return montones[INTERMEDIOS + num];
	}

	boolean moveSelectedCardToDescarte() {
		Monton monton = getDescarte();
		if (!montonSeleccionado.isEmpty()) {
			if (monton.addCardDown(montonSeleccionado.getLastCard())) {
				montonSeleccionado.extractCard();
				return true;
			}
		}
		return false;
	}

	boolean moveSelectedCardToIntermedio(int num) {
		Monton monton = getMontonIntermedio(num);
		if (!montonSeleccionado.isEmpty()) {
			if (monton.addCardDown(montonSeleccionado.getLastCard())) {
				montonSeleccionado.extractCard();
				return true;
			}
		}
		return false;
	}

	boolean moveSelectedCardToFinal(int num) {
		Monton monton = getMontonFinal(num);
		Palo paloFinal = Carta.intToPalo(num);
		if (!montonSeleccionado.isEmpty()) {
			if ((montonSeleccionado.getLastCard().getPalo() == paloFinal)
					&& monton.addCardUp(montonSeleccionado.getLastCard())) {
				montonSeleccionado.extractCard();
				return true;
			}
		}
		return false;
	}
	public String toString(){
		String ret="";
		ret += getBaraja().toString();
		ret += getDescarte().toString();
		ret += "       ";
		for(int n=0; n<NUM_FINALES;n++){
			if(getMontonFinal(n).isEmpty()){
				ret+= "["+Carta.paloToChar(Carta.intToPalo(n))+"]";
			}else{
				ret += getMontonFinal(n).toString();
			}
		}
		ret += "\n";
		for(int n=0; n<NUM_INTERMEDIOS;n++){
			ret += getMontonIntermedio(n).toString();
			ret += " ";
		}
		ret += "\n";
		return ret;

	}
}