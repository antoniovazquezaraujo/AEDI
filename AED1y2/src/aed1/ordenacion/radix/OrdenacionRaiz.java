package aed1.ordenacion.radix;

import java.lang.reflect.Array;

import cola.Cola;
import cola.EnlazadaCola;

public class OrdenacionRaiz {

	// Calcula la cifra que le pidas de esa cantidad
	private static int indice(int numero, int cifra) {
		return (numero / ((int) Math.pow(10, cifra))) % 10;
	}

	public static void ordenacionRaiz(int[] numeros) {
		int canDig = 4;
		int num;
		int cifra = 0;
		// Crear un array de Colas de enteros.
		// En cada cola se meter�n los que terminan por esa cifra
		// Luego se vuelven a meter en el array y se meten los que
		// tenga esa posici�n como segunda cifra, luego como tercera...
		@SuppressWarnings("unchecked")
		Cola<Integer>[] colas = (Cola<Integer>[]) Array.newInstance(
				EnlazadaCola.class, 10);
		for (int n = 0; n < 10; n++) {
			// Metemos una cola nueva y vacia en cada pos del array
			colas[n] = new EnlazadaCola<Integer>();
		}

		do {
			// Para cada n�mero buscamos su �ndice y lo metemos en esa cola
			for (int i = 0; i < numeros.length; i++) {
				num = indice(numeros[i], cifra);
				colas[num].insertar(numeros[i]);
			}
			// en la siguiente vuelta se usar� la siguiente cifra
			cifra++;

			// Volvemos a meter todos los n�meros al array de vuelta
			// pero cada vez estar�n m�s ordenados
			for (int j = 0, k = 0; j < colas.length; j++) {
				while (!colas[j].esVacio()) {
					numeros[k++] = colas[j].suprimir();
				}
			}
			// La cantidad de digitos va decreciendo
			// hasta que se acaban todos.
			canDig--;
		} while (canDig > 0);
	}

	public static void main(String[] args) {
		int[] listaNum = { 7843, 4568, 8765, 6543, 7865, 4532, 9987, 3241,
				6589, 6622, 1211 };
		ordenacionRaiz(listaNum);
		for (int i = 0; i < listaNum.length; i++)
			System.out.print(listaNum[i] + ", ");
	}
}
