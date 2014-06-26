package aed1.solitario.SolitarioConArrays;
public class Juego {
	public static void main(String[] args) {
		Juego juego = new Juego();
		juego.jugar();
	}

	private Mesa mesa;

	public Juego() {
		mesa = new Mesa();
	}

	public void cls() {
		for (int i = 0; i <= 100; i++) {
			System.out.println();
		}
	}

	public void jugar() {

		// -----------------------------------

		int accion;
		int tipoMontonMeter;
		int numMontonDesde;
		int numMontonHasta;
		String error = "";
		Carta carta;

		// ----------------------------------

		do {
			cls();
			if (!error.equals("")) {
				System.out.println(error);
				error = "";
			}
			System.out.println(mesa.toString());
			accion = getTipoMonton("De qu� tipo de mont�n desea coger una carta?");
			switch (accion) {
			case 3:// desde monton Final
				numMontonDesde = getNumMonton();
				carta = mesa.getMontonFinal(numMontonDesde).extraerCarta();
				if (carta != null) {
					System.out
							.println("En qu� monton intemedio metemos la carta?\n");
					numMontonHasta = getNumMonton();
					if (!mesa.insertarMontonIntermedio(carta, numMontonHasta)) {
						mesa.insertarMontonFinal(carta, numMontonDesde);
						error = "No puedes insertar ah�!";
					}
				} else {
					error = "No hay Cartas en el monton final "
							+ numMontonDesde;
				}
				break;
			case 2: // monton Intermedio
				numMontonDesde = getNumMonton();
				tipoMontonMeter = getTipoMontonMeter("En qu� monton metemos la carta?\n");
				switch (tipoMontonMeter) {
				case 1:// monton Intermedio
					numMontonHasta = getNumMonton();
					carta = mesa.getMontonIntermedio(numMontonDesde).extraerCarta();
					if (carta != null) {
						if (!mesa.insertarMontonIntermedio(carta,
								numMontonHasta)) {
							error = "No puedes insertar ah�!";
							mesa.insertarMontonIntermedio(carta, numMontonDesde);
						}
					} else {
						error = "No hay Cartas en el monton final "
								+ numMontonDesde;
					}
					break;
				case 2:// monton Final
					numMontonHasta = getNumMonton();
					carta = mesa.getMontonIntermedio(numMontonDesde).extraerCarta();
					if (carta != null) {
						if (!mesa.insertarMontonFinal(carta, numMontonHasta)) {
							mesa.insertarMontonIntermedio(carta, numMontonDesde);
							error = "No puedes insertar ah�!";
						}
					} else {
						error = "No hay Cartas en el monton final "
								+ numMontonDesde;
					}
					break;
				}
				break;
			case 1: // descarte
				tipoMontonMeter = getTipoMontonMeter("Estas sacando una carta de descarte.\n Donde la quieres meter?");
				switch (tipoMontonMeter) {
				case 1: // Intermedio
					numMontonHasta = getNumMonton();
					carta = mesa.getDescarte().extraerCarta();
					if (carta != null) {
						if (!mesa.insertarMontonIntermedio(carta,
								numMontonHasta)) {
							error = "No puedes insertar ah�";
							mesa.insertarDescarte(carta);
						}
					} else {
						error = "No hay cartas en tu descarte";
					}
					break;
				case 2: // Final
					numMontonHasta = getNumMonton();
					carta = mesa.getDescarte().extraerCarta();
					if (carta != null) {
						if (!mesa.insertarMontonFinal(carta, numMontonHasta)) {
							error = "No la puedes insertar ah�!";
							mesa.insertarDescarte(carta);
						}
					} else {
						error = "No hay cartas en tu descarte!";
					}
					break;
				}
				break;
			case 0: // baraja
				mesa.sacarBarajaADescarte();
				break;
			}

		} while (accion != 4 && !mesa.ganar() && !mesa.tablas());
		if(mesa.tablas()){
			System.out.println("Podr�a haber tablas.");
		}else if(mesa.ganar()){
			System.out.println("Has ganado!");
		}else{
			System.out.println("Adi�s");
		}
	}

	public int getNumMonton() {

		int num = 0;
		num = ES.pideNumero("1.- Monton 1\n" + "2.- Monton 2\n"
				+ "3.- Monton 3\n4.-Monton 4\n: ");
		return num - 1;
	}

	public int getTipoMonton(String mensaje) {

		int num;
		System.out.println(mensaje);
		System.out.println("0.- Baraja\n" + "1.- Descarte\n"
				+ "2.- Monton Intermedio\n" + "3.- Monton Final\n"
				+ "4.- Salir");
		num = ES.pideNumero("\n: ");

		return num;
	}

	public int getTipoMontonMeter(String mensaje) {

		int num;
		System.out.println(mensaje);
		System.out.println("1.- Monton Intermedio\n" + "2.- Monton Final");
		num = ES.pideNumero("\n: ");
		return num;
	}

}
