package aed1.ordenacion.conteo;

public class Ejercicio {
	static int posicionCorrecta(int[] datos, int numero) {
		int numMenores = 0;
		for (int i = 0; i < datos.length; i++) {
			if (datos[i] < numero) {
				numMenores++;
			}
		}
		return numMenores;
	}

	static int[] ordenar(int[] datos) {
		int[] ret = new int[datos.length];
		for (int i = 0; i < datos.length; i++) {
			ret[posicionCorrecta(datos, datos[i])] = datos[i];
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] datos = { 3, 4, 23, 5, 6, 1 };
		int[] ordenados = ordenar(datos);
		assert (!sorted(datos));
		assert (sorted(ordenados));
		System.out.println("OK");

	}

	public static boolean sorted(int[] a) {
		for (int n = 0; n < a.length - 1; n++) {
			if (!(a[n] < a[n + 1])) {
				return false;
			}
		}
		return true;
	}
}
