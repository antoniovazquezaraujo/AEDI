package aed1.solitario.SolitarioScreenConHerencia;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
enum Action {
	BARAJA, DESCARTE, FIN1, FIN2, FIN3, FIN4, M1, M2, M3, M4, M5, M6, M7, FIN, NO_ACTION
}

enum Palo {
	OROS, COPAS, ESPADAS, BASTOS
}
public class Solitario {
	public static void main(String[] args) {
		Juego juego = new Juego();
		Jugador jugador = new Jugador(juego);
		Output screen = new Screen();
		Action action = Action.NO_ACTION;
		while (action != Action.FIN) {
			screen.clear();
			screen.paint(juego);
			screen.paint();
			action = jugador.jugar();
		}
	}
}


