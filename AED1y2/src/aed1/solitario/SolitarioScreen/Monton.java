package aed1.solitario.SolitarioScreen;

class Monton {
	static final int MAX_CARTAS_MONTON_FINAL = 10;
	public static final int MAX_CARTAS_BARAJA = 40;
	public Carta[] cartas = new Carta[MAX_CARTAS_BARAJA];
	int numCartas;

	public Monton() {
		numCartas = 0;
	}

	public int getSize() {
		return numCartas;
	}

	public boolean addCardUp(Carta c) {
		if (isEmpty() || (numCartas < MAX_CARTAS_MONTON_FINAL)
				&& (getLastCard().isApilable(c))) {
			addCard(c);
			return true;
		}
		return false;
	}

	public boolean addCardDown(Carta c) {
		if (isEmpty() || getLastCard().isApilable(c)) {
			addCard(c);
			return true;
		}
		return false;
	}

	void reset() {
		for (int n = 0; n < Carta.MAX_CARD; n++) {
			addCard(new Carta(1 + n, Palo.OROS));
		}
		for (int n = 0; n < Carta.MAX_CARD; n++) {
			addCard(new Carta(1 + n, Palo.COPAS));
		}
		for (int n = 0; n < Carta.MAX_CARD; n++) {
			addCard(new Carta(1 + n, Palo.ESPADAS));
		}
		for (int n = 0; n < Carta.MAX_CARD; n++) {
			addCard(new Carta(1 + n, Palo.BASTOS));
		}
	}

	private void swap(int a, int b) {
		Carta tmp = cartas[b];
		cartas[b] = cartas[a];
		cartas[a] = tmp;
	}

	void shuffle() {
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

	public Carta removeLastCard() {
		assert (!isEmpty());
		Carta ret = cartas[numCartas - 1];
		numCartas--;
		return ret;
	}

	void addCard(Carta carta) {
		assert (numCartas < MAX_CARTAS_BARAJA);
		cartas[numCartas++] = carta;
	}

	public Carta extractCard() {
		return removeLastCard();
	}

	public Carta getLastCard() {
		assert (numCartas > 0);
		return cartas[numCartas - 1];
	}

	public Carta getAnteLastCard() {
		assert (numCartas > 1);
		return cartas[numCartas - 2];
	}
	public String toString(){
		String ret="[";
		if(numCartas>1){
			ret+=getAnteLastCard().toString();
			ret+=",";
		}
		if(numCartas>0){
			ret+=getLastCard().toString();
		}
		ret += "]";
		return ret;
	}
}