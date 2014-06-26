package aed1.ejercicios;

public class Borrador {

	public static void borrar(int datos[], int pos) {
		for (int i = pos; i < datos.length - 1; i++) {
			datos[i] = datos[i + 1];
		}
	}

	public static void main(String[] args) {
		int datos[] = new int[5];
		for (int n = 0; n < 5; n++) {
			datos[n] = n;
		}
		assert (datos[0] == 0);
		assert (datos[1] == 1);
		assert (datos[2] == 2);
		assert (datos[3] == 3);
		assert (datos[4] == 4);
		borrar(datos, 1);
		assert (datos[0] == 0);
		assert (datos[1] == 2);
		assert (datos[2] == 3);
		assert (datos[3] == 4);
		assert (datos[4] == 4);
		System.out.println("OK");
	}
}
