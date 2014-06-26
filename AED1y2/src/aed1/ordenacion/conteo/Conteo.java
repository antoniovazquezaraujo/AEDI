package aed1.ordenacion.conteo;

public class Conteo {
	public static int menores(int[] a, int x) {
		int cont = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < x) {
				cont++;
			}
		}
		return cont;
	}

	public static void show(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
	}

	public static void ordenarConteo(int[] a) {
		int[] menores = new int[a.length];
		for (int i = 0; i < menores.length; i++) {
			menores[i] = menores(a, a[i]);
		}
		int[] ord = new int[a.length];
		for (int i = 0; i < menores.length; i++) {
			ord[menores[i]] = a[i];
		}
		for (int i = 0; i < menores.length; i++) {
			a[i] = ord[i];
		}
	}

	public static boolean arrayOrdenado(int[] v) {
		for (int n = 0; n < v.length - 1; n++) {
			if (v[n] > v[n + 1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] a = new int[10];
		a[0] = 5;
		a[1] = 4;
		a[2] = 3;
		a[3] = 7;
		a[4] = 8;
		a[5] = 9;
		a[6] = 1;
		a[7] = 2;
		a[8] = 6;
		a[9] = 0;

		show(a);
		assert (!arrayOrdenado(a));
		ordenarConteo(a);
		show(a);
		assert (arrayOrdenado(a));
		System.out.println("Ok");
	}
}
