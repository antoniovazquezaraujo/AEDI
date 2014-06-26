package aed1.solitario.SolitarioScreen;

class Screen implements Output {
	public static final int ALTO = 20;
	public static final int ANCHO = 80;

	public static final int FILA_1 = 2;
	public static final int FILA_2 = 11;
	public static final int ANCHO_MONTON = 8;
	public static final int COL_BARAJA = 0;
	public static final int COL_DESCARTE = 10;
	public static final int COL_MONTONES_FINALES = 24;
	public static final int COL_MONTONES_INTERMEDIOS = 0;

	char[][] scr = new char[ALTO][ANCHO];

	public Screen() {
		clear();
	}
	@Override
	public void paint() {
		for (int fila = 0; fila < ALTO; fila++) {
			for (int col = 0; col < ANCHO; col++) {
				System.out.print(scr[fila][col]);
			}
			System.out.println();
		}
	}
	@Override
	public void paint(Juego juego) {
		paintKeys(juego);
		if (!juego.getBaraja().isEmpty()) {
			paintReversedCard(FILA_1, COL_BARAJA);
		}
		if (!juego.getDescarte().isEmpty()) {
			if (juego.montonSeleccionado == juego.getDescarte()) {
				paint(FILA_1, COL_DESCARTE, juego.getDescarte(), true);
			} else {
				paint(FILA_1, COL_DESCARTE, juego.getDescarte(), false);
			}
		}

		for (int n = 0; n < juego.NUM_FINALES; n++) {
			if (juego.getMontonFinal(n).isEmpty()) {
				paintReversedCard(FILA_1, COL_MONTONES_FINALES
						+ (n * ANCHO_MONTON), Carta.intToPalo(n));
			} else {
				paint(FILA_1, COL_MONTONES_FINALES + (n * ANCHO_MONTON), juego
						.getMontonFinal(n).getLastCard());
			}
		}
		for (int n = 0; n < juego.NUM_INTERMEDIOS; n++) {
			if (!juego.getMontonIntermedio(n).isEmpty()) {
				if (juego.montonSeleccionado == juego.getMontonIntermedio(n)) {
					paint(FILA_2, COL_MONTONES_INTERMEDIOS + (n * ANCHO_MONTON),juego.getMontonIntermedio(n), true);
				}else{
					paint(FILA_2, COL_MONTONES_INTERMEDIOS + (n * ANCHO_MONTON),juego.getMontonIntermedio(n), false);
				}
			}
		}
	}

	@Override
	public void clear() {
		clear(0, 0, ALTO, ANCHO);
	}

	///////////Parte privada//////////
	
	private void paintKeys(Juego juego) {
		paint(FILA_1 - 1, COL_BARAJA + ANCHO_MONTON / 2, 'q');
		paint(FILA_1 - 1, COL_DESCARTE + ANCHO_MONTON / 2, 'w');
		paint(FILA_1 - 1, COL_MONTONES_FINALES + (ANCHO_MONTON * 0)
				+ ANCHO_MONTON / 2, 'e');
		paint(FILA_1 - 1, COL_MONTONES_FINALES + (ANCHO_MONTON * 1)
				+ ANCHO_MONTON / 2, 'r');
		paint(FILA_1 - 1, COL_MONTONES_FINALES + (ANCHO_MONTON * 2)
				+ ANCHO_MONTON / 2, 't');
		paint(FILA_1 - 1, COL_MONTONES_FINALES + (ANCHO_MONTON * 3)
				+ ANCHO_MONTON / 2, 'y');

		paint(FILA_2 - 1, COL_MONTONES_INTERMEDIOS + (ANCHO_MONTON * 0)
				+ ANCHO_MONTON / 2, 'a');
		paint(FILA_2 - 1, COL_MONTONES_INTERMEDIOS + (ANCHO_MONTON * 1)
				+ ANCHO_MONTON / 2, 's');
		paint(FILA_2 - 1, COL_MONTONES_INTERMEDIOS + (ANCHO_MONTON * 2)
				+ ANCHO_MONTON / 2, 'd');
		paint(FILA_2 - 1, COL_MONTONES_INTERMEDIOS + (ANCHO_MONTON * 3)
				+ ANCHO_MONTON / 2, 'f');
		paint(FILA_2 - 1, COL_MONTONES_INTERMEDIOS + (ANCHO_MONTON * 4)
				+ ANCHO_MONTON / 2, 'g');
		paint(FILA_2 - 1, COL_MONTONES_INTERMEDIOS + (ANCHO_MONTON * 5)
				+ ANCHO_MONTON / 2, 'h');
		paint(FILA_2 - 1, COL_MONTONES_INTERMEDIOS + (ANCHO_MONTON * 6)
				+ ANCHO_MONTON / 2, 'j');
	}

	private void paint(int fila, int col, Monton monton, boolean selected) {
		if (selected) {
			paint(fila, col, monton.getLastCard(), Carta.ALTO + 2,
					Carta.ANCHO + 2);
		} else if (monton.getSize() > 1) {
			paint(fila, col, monton.getAnteLastCard());
			paint(fila + 2, col + 1, monton.getLastCard());
		} else {
			paint(fila, col, monton.getLastCard());
		}
	}


	private  void clear(int fila, int col, int alto, int ancho) {
		clear(fila, col, alto, ancho, ' ');
	}

	private  void clear(int fila, int col, int alto, int ancho, char theChar) {
		for (int f = 0; f < alto; f++) {
			for (int c = 0; c < ancho; c++) {
				scr[f + fila][c + col] = theChar;
			}
		}
	}

	private  void paint(int fila, int col, char c) {
		scr[fila][col] = c;
	}

	private  void border(int fila, int col, int alto, int ancho) {
		clear(fila, col, alto, ancho);
		for (int c = 0; c < ancho; c++) {
			paint(fila, col + c, '-');
			paint(fila + alto, col + c, '-');
		}
		for (int f = 0; f < alto; f++) {
			paint(fila + f, col, '|');
			paint(fila + f, col + ancho, '|');
		}
		paint(fila, col, '.');
		paint(fila, col + ancho, '.');
		paint(fila + alto, col, '`');
		paint(fila + alto, col + ancho, '\'');
	}

	private  void paint(int fila, int col, Carta carta) {
		paint(fila, col, carta, Carta.ALTO, Carta.ANCHO);
	}

	private  void paint(int fila, int col, Carta carta, int alto, int ancho) {
		border(fila, col, alto, ancho);
		paint(fila + 1, col + 1, carta.getSimbol());
		paint(fila + 1, col + 2, carta.getPaloChar());
	}

	private  void paintReversedCard(int fila, int col, Palo palo) {
		border(fila, col, Carta.ALTO, Carta.ANCHO);
		clear(fila + 1, col + 1, Carta.ALTO - 1, Carta.ANCHO - 1,
				Carta.paloToChar(palo));
	}

	private  void paintReversedCard(int fila, int col) {
		border(fila, col, Carta.ALTO, Carta.ANCHO);
		clear(fila + 1, col + 1, Carta.ALTO - 1, Carta.ANCHO - 1, '#');
	}

}