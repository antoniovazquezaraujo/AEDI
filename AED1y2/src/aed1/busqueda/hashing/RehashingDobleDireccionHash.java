package aed1.busqueda.hashing;

public class RehashingDobleDireccionHash {
	public static int insert(int elemento, int R, int[] datos) {
		int m = datos.length;
		int hash = elemento % m;
		if (datos[hash] == 0) {
			datos[hash] = elemento;
			return hash;
		}
		int dirHash2 = R - (elemento % R);
		int i = 1;
		int rehash = (hash + dirHash2) % m;
		while ((datos[rehash] != 0)) {
			i++;
			rehash = (hash + i * dirHash2) % m;
		}
		if ((datos[rehash] == 0)) {
			datos[hash] = elemento;
			return rehash;
		}
		return -1;
	}

	public static int search(int elemento, int primo, int[] datos) {
		int m = datos.length;
		int dirHash = elemento % m;
		if (datos[dirHash] == elemento)
			return dirHash;
		else {
			int dirHash2 = primo - (elemento % primo);
			int i = 1;
			int dirReh = (dirHash + dirHash2) % m;
			while ((datos[dirReh] != elemento) && (datos[dirReh] != 0)) {
				i++;
				dirReh = (dirHash + i * dirHash2) % m;
			}
			if (datos[dirReh] == elemento)
				return dirReh;
			else
				return -1;
		}
	}

	public static void main(String[] args) {
		int primo = 3;
		int a[] = new int[10];
		for (int n = 0; n < 10; n++) {
			insert(n * 3, primo, a);
		}
		for (int n = 0; n < 10; n++) {
			assert (search(n * 3, primo, a) != -1);
		}
		for (int n = 1000; n < 10000; n++) {
			assert (search(n, primo, a) == -1);
		}
		System.out.println("OK");
	}

}
