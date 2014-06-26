package aed1.ejercicios;

public class ContarIntervalos {
	public static int menoresA(int min, int datos[]) {
		for (int n = 0; n < datos.length; n++) {
			if (datos[n] >= min) {
				return n;
			}
		}
		return datos.length;
	}

	public static int mayoresA(int max, int datos[]) {
		for (int n = 0; n < datos.length; n++) {
			if (datos[n] > max) {
				return datos.length - n;
			}
		}
		return 0;
	}

	public static int entreIntervalo(int desde, int hasta, int datos[]) {
		return datos.length - menoresA(desde, datos) - mayoresA(hasta, datos);
	}

	public static void main(String[] args) {
		/*
		 * int datos[] = new int[1000]; for (int n = 0; n < 1000; n++) {
		 * datos[n] = (n / 10) % 100; System.out.println(n+ ":" + datos[n] +
		 * ", "); }
		 */
		int datos[] = new int[10];
		datos[0] = 1;
		datos[1] = 1;
		datos[2] = 1;
		datos[3] = 2;
		datos[4] = 2;
		datos[5] = 3;
		datos[6] = 4;
		datos[7] = 4;
		datos[8] = 5;
		datos[9] = 6;
		assert (menoresA(2, datos) == 3);
		assert (mayoresA(4, datos) == 2);
		assert (entreIntervalo(2, 4, datos) == 5);
		System.out.println("Ok");
	}
}
