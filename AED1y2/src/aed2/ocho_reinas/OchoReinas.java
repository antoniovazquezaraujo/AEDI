package aed2.ocho_reinas;

import java.util.Iterator;
import java.util.Map;

class DoblePos {
	Pos p1, p2;
}

class Pos {
	public Pos(int fila, int col) {
		this.fila = fila;
		this.col = col;
	}

	int fila, col;
}

public class OchoReinas {
	private static int cont = 0;

	static DoblePos buscaT(char[][] lab) {
		DoblePos dp = new DoblePos();
		for (int fila = 0; fila < lab.length; fila++) {
			for (int col = 0; col < lab[0].length; col++) {
				if (lab[fila][col] == 'T') {
					dp.p1 = new Pos(fila, col);
					for (int fila2 = fila; fila2 < lab.length; fila2++) {
						for (int col2 = col; col2 < lab[0].length; col2++) {
							if (lab[fila2][col2] == 'T') {
								dp.p2 = new Pos(fila2, col2);
								return dp;
							}
						}
					}
				}
			}
		}
		return null;
	}

	static String labToString(char[][] lab) {
		String ret = "";
		for (int fila = 0; fila < lab.length; fila++) {
			ret += "|";
			for (int col = 0; col < lab[0].length; col++) {
				ret += lab[fila][col];
				ret += "|";
			}
			ret += "\n";
		}
		return ret;

	}

	// Laberinto
	public static boolean ensayar(char[][] lab, int fila, int col) {
		final char camino = 'c';
		final char obstaculo = 'X';
		final char imposible = '*';
		final char libre = ' ';

		int labSize = lab.length;
		boolean encontrado;
		if ((fila < 0) || (fila > labSize - 1) || (col < 0)
				|| (col > labSize - 1))
			encontrado = false;
		else {
			if (lab[fila][col] != libre) {
				encontrado = false;
			} else {
				if ((fila == labSize - 1) && (col == labSize - 1)) {
					encontrado = true;
					lab[fila][col] = camino;
				} else {
					encontrado = true;
					lab[fila][col] = camino;
					if (!ensayar(lab, fila - 1, col)) {
						if (!ensayar(lab, fila + 1, col)) {
							if (!ensayar(lab, fila, col + 1)) {
								if (!ensayar(lab, fila, col - 1)) {
									lab[fila][col] = imposible;
									encontrado = false;
								}
							}
						}
					}
				}
			}
		}
		System.out.println(labToString(lab));
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encontrado;
	}

	// Laberinto
	public static boolean ensayar3D(char[][][] lab, int fila, int col, int piso) {
		final char camino = 'c';
		final char obstaculo = 'X';
		final char imposible = '*';
		final char libre = ' ';

		int labSize = lab.length;
		boolean encontrado;
		if ((fila < 0) || (fila > labSize - 1) || (col < 0)
				|| (col > labSize - 1) || (piso < 0) || (piso > labSize - 1))
			encontrado = false;
		else {
			if (lab[fila][col][piso] != libre) {
				encontrado = false;
			} else {
				if ((fila == labSize - 1) && (col == labSize - 1)
						&& (piso == labSize - 1)) {
					encontrado = true;
					lab[fila][col][piso] = camino;
				} else {
					encontrado = true;
					lab[fila][col][piso] = camino;
					if (!ensayar3D(lab, fila + 1, col, piso)) {
						if (!ensayar3D(lab, fila, col + 1, piso)) {
							if (!ensayar3D(lab, fila - 1, col, piso)) {
								if (!ensayar3D(lab, fila, col - 1, piso)) {
									if (!ensayar3D(lab, fila, col, piso + 1)) {
										if (!ensayar3D(lab, fila, col, piso - 1)) {
											lab[fila][col][piso] = imposible;
											encontrado = false;
										}
									}
								}
							}
						}
					}
				}

			}
		}

		return encontrado;
	}

	// Laberinto
	public static boolean ensayarConTeleTransporte(char[][] lab, int fila,
			int col) {
		final char camino = 'c';
		final char obstaculo = 'X';
		final char imposible = '*';
		final char libre = ' ';
		int filaT1 = -1, colT1 = -1;
		int filaT2 = -1, colT2 = -1;

		if (filaT1 == -1) {
			DoblePos dp = buscaT(lab);
			filaT1 = dp.p1.fila;
			colT1 = dp.p1.col;
			filaT2 = dp.p2.fila;
			colT2 = dp.p2.col;
		}
		if (fila == filaT1 && col == colT1) {
			fila = filaT2;
			col = colT2;
		}

		if (fila == filaT2 && col == colT2) {
			fila = filaT1;
			col = colT1;
		}
		int labSize = lab.length;
		boolean encontrado;
		if ((fila < 0) || (fila > labSize - 1) || (col < 0)
				|| (col > labSize - 1))
			encontrado = false;
		else {
			if (lab[fila][col] != libre) {
				encontrado = false;
			} else {
				if ((fila == labSize - 1) && (col == labSize - 1)) {
					encontrado = true;
					lab[fila][col] = camino;
				} else {
					encontrado = true;
					lab[fila][col] = camino;
					if (!ensayar(lab, fila + 1, col)) {
						if (!ensayar(lab, fila, col + 1)) {
							if (!ensayar(lab, fila - 1, col)) {
								if (!ensayar(lab, fila, col - 1)) {
									lab[fila][col] = imposible;
									encontrado = false;
								}
							}
						}
					}
				}

			}
		}

		return encontrado;
	}

	// 8 reinas
	private static boolean buenSitio(int j, int[] tabl) {
		int i;
		for (i = 0; i < j; ++i) {
			if ((tabl[i] == tabl[j])
					|| (Math.abs(tabl[i] - tabl[j]) == Math.abs(i - j))) {
				break;
			}
		}
		return (i == j);
	}

	public static boolean colocarReinas(int j, int[] tablero) {
		boolean colocadas = false;
		for (int i = 0; i < tablero.length && !colocadas; ++i) {
			tablero[j] = i;
			if (buenSitio(j, tablero)) {
				if (j == tablero.length - 1) {
					colocadas = true;
				} else {
					if (colocarReinas(j + 1, tablero)) {
						colocadas = true;
					}
				}
			}
		}
		return colocadas;
	}

	public static void main(String[] args) {

		
		 System.out.println("\n ----- Problema de las 8 reinas ----");
		
		 int[] reinas = new int[8];
		
		 OchoReinas.colocarReinas(0, reinas);
		
		 for (int i = 0; i < reinas.length; i++)
		 System.out.println("La reina " + i + " se coloca en la fila " + i
		 + " en la columna " + reinas[i]);
		
		 System.out.println("\n------- Laberinto ------");

		char[][] lab = { { ' ', ' ', ' ', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ ' ', ' ', 'X', ' ', ' ', ' ', 'X' },
				{ ' ', ' ', 'X', ' ', 'X', ' ', ' ' } };

		boolean r = OchoReinas.ensayar(lab, 0, 0);

		System.out.println(r);

		for (int i = 0; i < lab.length; i++) {
			for (int j = 0; j < lab[i].length; j++)
				System.out.print(lab[i][j] + " ");
			System.out.println();
		}

	}

}
