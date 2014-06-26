package aed1.solitario.SolitarioDesdeCero;
public class Juego {
	Mesa mesa;
	Jugador jugador;
	public static void main(String[] args) {
		Juego juego = new Juego();
		juego.start();
	}
	public void start(){
		mesa = new Mesa();
		jugador = new Jugador();
		Accion accion = Accion.SALIR;
		do{
			System.out.println(mesa.toString());
			accion = jugador.getAccion();
			resolver(accion);
		}while(accion != Accion.SALIR);
		
	}
	void resolver(Accion accion){
		switch(accion){
		case METER_EN_DESCARTE:
			break;
			
		}
	}
}
