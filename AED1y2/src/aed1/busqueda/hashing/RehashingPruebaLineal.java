package aed1.busqueda.hashing;

public class RehashingPruebaLineal {
	public static int insert(int elemento, int[] datos) {
		int m = datos.length;
		int hash = elemento % m;
		if (datos[hash] == 0) {
			datos[hash] = elemento;
			return hash;
		}
		int rehash = (hash + 1) % m;
		while ((datos[rehash] != 0) && (rehash != hash)) {
			rehash = (rehash + 1) % m;
		}
		if ((datos[rehash] == 0) && (rehash != hash)) {
			datos[hash] = elemento;
			return rehash;
		}
		return -1;
	}

	public static int search(int X, int[] A) {
		int m = A.length;
		int dirHash = X % m;
		if (A[dirHash] == X)
			return dirHash;
		else {
			int dirReh = (dirHash + 1) % m;
			while ((A[dirReh] != X) && (A[dirReh] != 0) && (dirReh != dirHash))
				dirReh = (dirReh + 1) % m;
			if (A[dirReh] == X)
				return dirReh;
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
