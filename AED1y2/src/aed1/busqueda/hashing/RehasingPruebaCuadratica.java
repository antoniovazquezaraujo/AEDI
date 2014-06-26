package aed1.busqueda.hashing;

public class RehasingPruebaCuadratica {
	public static int insert(int elemento, int[] datos) {
		int m = datos.length;
		int hash = elemento % m;
		if (datos[hash] == 0) {
			datos[hash] = elemento;
			return hash;
		}
		int i = 1;
		int cont = 0;
		int rehash = (hash + 1) % m;
		while ((datos[rehash] != 0) && (rehash != hash) && (cont < m * 10)) {
			i++;
			rehash = (hash + (i * i)) % m;
			cont++;
		}
		if ((datos[rehash] == 0) && (rehash != hash)) {
			datos[hash] = elemento;
			return rehash;
		}
		return -1;
	}

	public static int search(int elemento, int[] array) {
		int m = array.length;
		int hash = elemento % m;
		if (array[hash] == elemento)
			return hash;
		else {
			int i = 1;
			int cont = 0;
			int rehash = (hash + 1) % m;
			while ((array[rehash] != elemento) && (array[rehash] != 0)
					&& (cont < m * 10)) {
				i++;
				rehash = (hash + (i * i)) % m;
				cont++;
			}
			if (array[rehash] == elemento)
				return rehash;
			else
				return -1;
		}
	}

	public static void main(String[] args) {
		int a[] = new int[10];
		for (int n = 0; n < 10; n++) {
			insert(n * 3, a);
		}
		for (int n = 0; n < 10; n++) {
			assert (search(n * 3, a) != -1);
		}
		for (int n = 1000; n < 10000; n++) {
			assert (search(n, a) == -1);
		}
		System.out.println("OK");
	}

}
