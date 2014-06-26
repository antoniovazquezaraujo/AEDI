package aed1.solitario.SolitarioScreenConHerencia;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Jugador {
	String menu = "QW ERTY ASDFGHJ X";
	Juego juego;

	Jugador(Juego juego) {
		this.juego = juego;
	}

	public Action jugar() {
		Action action = getAction(menu);
		Monton montonSeleccionado = null;
		int numMonton = 0;
		switch (action) {
		case BARAJA:
			montonSeleccionado = juego.getBaraja();
			if (!juego.movingCard && !montonSeleccionado.isEmpty()) {
				juego.getDescarte().addCard(montonSeleccionado.extractCard());
			}
			juego.movingCard = false;
			juego.montonSeleccionado = null;
			break;
		case DESCARTE:
			if (juego.movingCard) {
				if(juego.moveSelectedCardToDescarte()){
					juego.movingCard = false;
					juego.montonSeleccionado = null;
				}
			} else if (!juego.getDescarte().isEmpty()) {
				juego.montonSeleccionado = juego.getDescarte();
				juego.movingCard = true;
			}
			break;
		case FIN1:
		case FIN2:
		case FIN3:
		case FIN4:
			numMonton = action.ordinal() - 2;
			Monton monton = juego.getMontonFinal(numMonton);
			if (!juego.movingCard) {
				if (!monton.isEmpty()) {
					juego.montonSeleccionado = monton;
					juego.movingCard = true;
				}
			} else {
				if(juego.moveSelectedCardToFinal(numMonton)){
					juego.montonSeleccionado = null;
					juego.movingCard = false;
				}
			}
			break;
		case M1:
		case M2:
		case M3:
		case M4:
		case M5:
		case M6:
		case M7:
			numMonton = action.ordinal() - 6;
			monton = juego.getMontonIntermedio(numMonton);
			if (!juego.movingCard) {
				if (!monton.isEmpty()) {
					juego.montonSeleccionado = monton;
					juego.movingCard = true;
				}
			} else {
				if(juego.moveSelectedCardToIntermedio(numMonton)){
					juego.montonSeleccionado = null;
					juego.movingCard = false;
				}
			}
			break;
		case FIN:
			break;
		}
		return action;
	}

	Action getAction(String prompt) {
		System.out.println(prompt);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		Action ret = Action.NO_ACTION;
		char c = ' ';
		try {
			c = Character.toLowerCase((char) reader.read());
		} catch (IOException e) {
			e.printStackTrace();
		}
		switch (c) {
		case 'q':
			ret = Action.BARAJA;
			break;
		case 'w':
			ret = Action.DESCARTE;
			break;
		case 'e':
			ret = Action.FIN1;
			break;
		case 'r':
			ret = Action.FIN2;
			break;
		case 't':
			ret = Action.FIN3;
			break;
		case 'y':
			ret = Action.FIN4;
			break;
		case 'a':
			ret = Action.M1;
			break;
		case 's':
			ret = Action.M2;
			break;
		case 'd':
			ret = Action.M3;
			break;
		case 'f':
			ret = Action.M4;
			break;
		case 'g':
			ret = Action.M5;
			break;
		case 'h':
			ret = Action.M6;
			break;
		case 'j':
			ret = Action.M7;
			break;
		case 'x':
			ret = Action.FIN;
			break;
		}
		return ret;
	}
}