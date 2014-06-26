package aed2.arboles_generales;

import arbolGeneral.*;
import cola.*;

public class Actividad4 {

	public static <E> void preorden(ArbolGeneral<E> a) {
		if (!a.esVacio()) {
			System.out.print(" " + a.raiz());
			ArbolGeneral<E> aux = a.hijoMasIzq();
			while (!aux.esVacio()) {
				preorden(aux);
				aux = aux.hermanoDer();
			}
		}
	}

	public static <E> void inorden(ArbolGeneral<E> a) {
		if (!a.esVacio()) {
			ArbolGeneral<E> aux = a.hijoMasIzq();
			inorden(aux);
			System.out.print(" " + a.raiz());
			if (!aux.esVacio()) {
				aux = aux.hermanoDer();
				while (!aux.esVacio()) {
					inorden(aux);
					aux = aux.hermanoDer();
				}
			}
		}
	}

	// Ejercicio 1
	public static <E> int numNodos(ArbolGeneral<E> a) {
		if (a.esVacio())
			return 0;
		else {
			int cont = 1;
			ArbolGeneral<E> hijo = a.hijoMasIzq();
			while (!hijo.esVacio()) {
				cont += numNodos(hijo);
				hijo = hijo.hermanoDer();
			}
			return cont;
		}
	}

	// Ejercicio 2

	public static <E> int numHojas(ArbolGeneral<E> a) {
		if (a.esVacio())
			return 0;
		else if (a.hijoMasIzq().esVacio())
			return 1;
		else {
			ArbolGeneral<E> hijo = a.hijoMasIzq();
			int cont = 0;
			while (!hijo.esVacio()) {
				cont += numHojas(hijo);
				hijo = hijo.hermanoDer();
			}
			return cont;
		}
	}

	// Ejercicio 3

	public static <E> boolean arbolDosTres(ArbolGeneral<E> a) {
		if (a.esVacio())
			return true;
		ArbolGeneral<E> hijo = a.hijoMasIzq();
		if (hijo.esVacio()) {
			return true;
		}
		int cont = 0;
		while (!hijo.esVacio() && arbolDosTres(hijo)) {
			cont++;
			hijo = hijo.hermanoDer();
		}
		if (cont == 2 || cont == 3) {
			return true;
		}
		return false;
	}

	// Otros m�todos

	public static int numNodosPares(ArbolGeneral<Integer> a) {
		if (a.esVacio())
			return 0;

		else {
			int cont = 0;
			if (a.raiz() % 2 == 0)
				cont++;
			ArbolGeneral<Integer> hijo = a.hijoMasIzq();
			while (!hijo.esVacio()) {
				cont += numNodosPares(hijo);
				hijo = hijo.hermanoDer();
			}
			return cont;
		}
	}

	// Ejercicio 3
	public static int sumaNodos(ArbolGeneral<Integer> a) {
		if (a.esVacio())
			return 0;
		else {
			int cont = a.raiz();
			ArbolGeneral<Integer> hijo = a.hijoMasIzq();
			while (!hijo.esVacio()) {
				cont += sumaNodos(hijo);
				hijo = hijo.hermanoDer();
			}
			return cont;
		}
	}

	// Ejercicio 4
	public static <E> void nivelN(ArbolGeneral<E> a, int nivel) {
		if (!a.esVacio()) {
			if (nivel == 0)
				System.out.print(a.raiz() + " ");
			ArbolGeneral<E> hijo = a.hijoMasIzq();
			while (!hijo.esVacio()) {
				nivelN(hijo, nivel - 1);
				hijo = hijo.hermanoDer();
			}
		}
	}

	// Ejercicio 5
	public static <E> int grado(ArbolGeneral<E> a) {
		if (a.esVacio())
			return 0;
		else {
			int num = 0;
			ArbolGeneral<E> hijo = a.hijoMasIzq();
			while (!hijo.esVacio()) {
				num++;
				hijo = hijo.hermanoDer();
			}
			int maxGrado = num;
			hijo = a.hijoMasIzq();
			while (!hijo.esVacio()) {
				int gradoAct = grado(hijo);
				if (gradoAct > maxGrado)
					maxGrado = gradoAct;
				hijo = hijo.hermanoDer();
			}
			return maxGrado;
		}
	}

	// Ejercicio 6
	public static <E> void anchura(ArbolGeneral<E> a) {
		Cola<ArbolGeneral<E>> c = new EnlazadaCola<ArbolGeneral<E>>();
		c.insertar(a);
		do {
			a = c.suprimir();
			if (!a.esVacio()) {
				System.out.print(a.raiz() + " ");
				ArbolGeneral<E> hijo = a.hijoMasIzq();
				while (!hijo.esVacio()) {
					c.insertar(hijo);
					hijo = hijo.hermanoDer();
				}
			}
		} while (!c.esVacio());
	}

	// Ejercicio 7
	public static <E> boolean identicos(ArbolGeneral<E> a, ArbolGeneral<E> b) {
		if (a.esVacio() && b.esVacio())
			return true;
		if (!a.esVacio() && !b.esVacio())
			if (!a.raiz().equals(b.raiz()))
				return false;
			else {
				ArbolGeneral<E> ha = a.hijoMasIzq();
				ArbolGeneral<E> hb = b.hijoMasIzq();
				while (!ha.esVacio() && !hb.esVacio()) {
					if (!identicos(ha, hb))
						return false;
					ha = ha.hermanoDer();
					hb = hb.hermanoDer();
				}
				return ha.esVacio() && hb.esVacio();
			}
		return false;
	}

	// Ejercicio 8

	public static <E> int altura(ArbolGeneral<E> a) {
		if (a.esVacio())
			return 0;
		int cont = 0;
		int maxGrado = 0;
		ArbolGeneral<E> hijo = a.hijoMasIzq();
		// if(!hijo.esVacio())cont=1;
		while (!hijo.esVacio()) {
			cont = altura(hijo);
			if (cont > maxGrado)
				maxGrado = cont;
			hijo = hijo.hermanoDer();
		}
		return maxGrado + 1;
	}

	// Ejercicio 8
	/*
	 * public static <E> int altura (ArbolGeneral<E> arbol){ if
	 * (arbol.esVacio()) return 0; if (arbol.hijoMasIzq().esVacio()) return 0;
	 * int max = 0; ArbolGeneral <E> hijo = arbol.hijoMasIzq();
	 * while(!hijo.esVacio()){ int h = altura(hijo); if (h>max) max = h; hijo =
	 * hijo.hermanoDer(); } return max + 1; }
	 */

	// otros aed1.ejercicios no propuestos

	/*
	 * public static ArbolGeneral<Integer> duplicar (ArbolGeneral<Integer> a){
	 * if (a.esVacio()) return new EnlazadoArbolGeneral<Integer>(); int
	 * numSubArboles = subArboles(a); ArbolGeneral<Integer> [] copias = new
	 * ArbolGeneral[numSubArboles] ; ArbolGeneral<Integer> hijo =
	 * a.hijoMasIzq(); int i = 0; while (!hijo.esVacio()){ copias[i++] =
	 * duplicar(hijo); hijo=hijo.hermanoDer(); } return new
	 * EnlazadoArbolGeneral<Integer>(a.raiz()*2, copias); }
	 */

	public static <E> boolean igualEstructura(ArbolGeneral<E> a,
			ArbolGeneral<E> b) {
		if (a.esVacio() && b.esVacio())
			return true;
		if (a.esVacio() || b.esVacio())
			return false;
		ArbolGeneral<E> ha = a.hijoMasIzq();
		ArbolGeneral<E> hb = b.hijoMasIzq();
		while (!ha.esVacio() && !hb.esVacio()) {
			if (!igualEstructura(ha, hb))
				return false;
			ha = ha.hermanoDer();
			hb = hb.hermanoDer();
		}
		return ha.esVacio() && hb.esVacio();
	}

	public static <E> int subArboles(ArbolGeneral<E> a) {
		if (a.esVacio())
			return 0;
		else {
			int cont = 0;
			ArbolGeneral<E> hijo = a.hijoMasIzq();
			while (!hijo.esVacio()) {
				cont++;
				hijo = hijo.hermanoDer();
			}
			return cont;
		}
	}

	public static <E> boolean equilibrado(ArbolGeneral<E> a) {
		if (a.esVacio())
			return true;
		else {
			int numSub = subArboles(a);
			ArbolGeneral<E> hijo = a.hijoMasIzq();
			while (!hijo.esVacio()) {
				if (numSub != subArboles(hijo))
					return false;
				hijo = hijo.hermanoDer();
			}
			return true;
		}
	}

	public static <E> int numHijosPares(ArbolGeneral<E> a) {
		if (a.esVacio())
			return 0;
		int contNodos = 0, contHijos = 0;
		ArbolGeneral<E> hijo = a.hijoMasIzq();
		while (!hijo.esVacio()) {
			contHijos++;
			hijo = hijo.hermanoDer();
		}
		if (contHijos % 2 == 0)
			contNodos = 1;
		hijo = a.hijoMasIzq();
		while (!hijo.esVacio()) {
			contNodos += numHijosPares(hijo);
			;
			hijo = hijo.hermanoDer();
		}
		return contNodos;
	}

	public static void main(String[] args) {
		// Construccion de un �rbol general, arbol4, para probar los metodos:
		System.out.println("�rboles generales");
		// construyo el �rbol 1
		ArbolGeneral<Character> arbol1 = new EnlazadoArbolGeneral<Character>(
				'4', new EnlazadoArbolGeneral<Character>('2'));
		ArbolGeneral<Character> arbol2 = new EnlazadoArbolGeneral<Character>(
				'3', new EnlazadoArbolGeneral<Character>('1'));
		ArbolGeneral<Character> arbol3 = new EnlazadoArbolGeneral<Character>(
				'6', arbol1, arbol2, new EnlazadoArbolGeneral<Character>('5'));
		ArbolGeneral<Character> arbol4 = new EnlazadoArbolGeneral<Character>(
				'7', arbol3);

		System.out.println("Recorrido en preorden del arbol4:");
		preorden(arbol4);
		System.out.println();
		System.out.println("Recorrido en inorden del �rbol4");
		inorden(arbol4);
		System.out.println();

		// Ejercicio 1: cuento el n�mero de nodos
		System.out.println("1. Numero de nodos: " + numNodos(arbol4));

		// Ejercicio 2: calcula n�mero de hojas
		System.out.println("2. N�mero de hojas del �rbol 4: "
				+ numHojas(arbol4));

		// Arbol nuevo
		ArbolGeneral<Character> arbola = new EnlazadoArbolGeneral<Character>(
				'a');
		ArbolGeneral<Character> arbolb = new EnlazadoArbolGeneral<Character>(
				'b', arbola);
		ArbolGeneral<Character> arbolc = new EnlazadoArbolGeneral<Character>(
				'c', arbolb);
		ArbolGeneral<Character> arbold = new EnlazadoArbolGeneral<Character>(
				'd', arbolc);
		ArbolGeneral<Character> arbolv = new EnlazadoArbolGeneral<Character>(
				'4', new EnlazadoArbolGeneral<Character>('2'));
		ArbolGeneral<Character> arbolw = new EnlazadoArbolGeneral<Character>(
				'8', new EnlazadoArbolGeneral<Character>('1'));
		ArbolGeneral<Character> arbolx = new EnlazadoArbolGeneral<Character>(
				'6', arbolv, arbolw, new EnlazadoArbolGeneral<Character>('5'));
		ArbolGeneral<Character> arbolz = new EnlazadoArbolGeneral<Character>(
				'7', arbolx);

		// Ejercicio 3:
		System.out.println("3. �Es �rbol 2-3 el arbol4: "
				+ arbolDosTres(arbol4));
		System.out.println("3. �Es �rbol 2-3 el arbolz: "
				+ arbolDosTres(arbolz));
		System.out.println("3. �Es �rbol 2-3 el arbold: "
				+ arbolDosTres(arbold));

		// Ejercicio 4: nivel
		System.out.print("13. El nivel 2 del arbol4 es : ");
		nivelN(arbol4, 2);
		System.out.println();
		System.out.print("13. El nivel 3 del arbolz es : ");
		nivelN(arbolz, 3);
		System.out.println();
		System.out.print("13. El nivel 0 del arbold es : ");
		nivelN(arbold, 0);
		System.out.println();

		// Ejercicio 5: Calculo el grado
		System.out.println("5. Grado del arbol4: " + grado(arbol4));

		// Ejercicio 6: anchura
		System.out.print("6. Recorrido en anchura del arbol4: ");
		anchura(arbol4);
		System.out.println();

		// Ejercicio 7: Miro si son identicos
		System.out.println("7. Identicos: " + identicos(arbol1, arbol2));

		// Ejercicio 8: altura del �rbol
		System.out.println("8. La altura del �rbol 4 es :" + altura(arbol4));
		System.out.println("8. La altura del �rbol d es :" + altura(arbold));
		System.out.println("8. La altura del �rbol z es :" + altura(arbolz));

		/*
		 * ArbolGeneral<Integer> arbolDoble = duplicar(arbol13);
		 * System.out.println("Recorrido en preorden del arbolDoble:");
		 * preorden(arbolDoble); System.out.println();
		 * System.out.println("Recorrido en inorden del �rbolDoble");
		 * inorden(arbolDoble); System.out.println();
		 */

	}

}
