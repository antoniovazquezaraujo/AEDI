package aed1.solitario.SolitarioDesdeCero;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Jugador {

	Accion getAccion(){
		Accion ret = Accion.SALIR;
		System.out.println("0:Salir, 1: Sacar de la baraja\n" +
				"2: Sacar del descarte");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		char c = ' ';
		try {
			c = Character.toLowerCase((char) reader.read());
		} catch (IOException e) {
			e.printStackTrace();
		}
		switch(c){
		case '0':
			ret = Accion.SACAR_DE_BARAJA;
			break;
			///
		}
		return ret;
	}
}
