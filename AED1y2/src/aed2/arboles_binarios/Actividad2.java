package aed2.arboles_binarios;

import java.io.*;
import lista.*;
import arbolBinario.*;

public class Actividad2 {

	// Ejercicio 1
	public static int sumaElementos(ArbolBinario<Integer> a) {
		if (a.esVacio())
			return 0;
		return a.raiz() + sumaElementos(a.hijoIzq())
				+ sumaElementos(a.hijoDer());
	}

	// Ejercicio 2
	public static int numNodos(ArbolBinario<Integer> a) {
		if (a.esVacio())
			return 0;
		return 1 + numNodos(a.hijoIzq()) + numNodos(a.hijoDer());
	}

	public static double promedio(ArbolBinario<Integer> a) {
		if (a.esVacio())
			return 0;
		if (a.hijoIzq().esVacio() && a.hijoDer().esVacio())
			return a.raiz();
		else {
			double suma = a.raiz() + promedio(a.hijoIzq())
					+ promedio(a.hijoDer());
			return suma / numNodos(a);
		}
	}

	// Ejercicio 3
	public static <E> ArbolBinario<E> copia(ArbolBinario<E> a) {
		if (a.esVacio())
			return new EnlazadoArbolBinario<E>();
		else
			return new EnlazadoArbolBinario<E>(a.raiz(), copia(a.hijoIzq()),
					copia(a.hijoDer()));
	}

	// Ejercicio 4
	public static <E> int numHojas(ArbolBinario<E> a) {
		if (a.esVacio())
			return 0;
		if (a.hijoIzq().esVacio() && a.hijoDer().esVacio())
			return 1;
		return numHojas(a.hijoIzq()) + numHojas(a.hijoDer());
	}

	// Ejercicio 5
	public static <E> ArbolBinario<E> eliminarHojas(ArbolBinario<E> arbol) {
		if (arbol.esVacio())
			return new EnlazadoArbolBinario<E>();
		else if (arbol.hijoIzq().esVacio() && arbol.hijoDer().esVacio())
			return new EnlazadoArbolBinario<E>();
		else
			return new EnlazadoArbolBinario<E>(arbol.raiz(),
					eliminarHojas(arbol.hijoIzq()),
					eliminarHojas(arbol.hijoDer()));
	}

	// Ejercicio 6
	public static <E> void frontera(ArbolBinario<E> a, Lista<E> l) {
		if (!a.esVacio()) {
			ArbolBinario<E> hi = a.hijoIzq();
			ArbolBinario<E> hd = a.hijoDer();
			if (hi.esVacio() && hd.esVacio()) {
				l.insertarFinal(a.raiz());
			} else {
				frontera(a.hijoIzq(), l);
				frontera(a.hijoDer(), l);
			}
		}
	}

	// Ejercicio 7
	public static ArbolBinario<Character> reconstruir(String preord,
			String inord) {
		if (preord.length() == 0)
			return new EnlazadoArbolBinario<Character>();
		else {
			char r = preord.charAt(0);
			int p = inord.indexOf(r);
			return new EnlazadoArbolBinario<Character>(
					r,
					reconstruir(preord.substring(1, p + 1),
							inord.substring(0, p)),
					reconstruir(preord.substring(p + 1), inord.substring(p + 1)));
		}
	}

	public static ArbolBinario<Integer> reconstruir2(String preord, String inord) {
		if (preord.length() == 0)
			return new EnlazadoArbolBinario<Integer>();
		else {
			char r = preord.charAt(0);
			int p = inord.indexOf(r);
			return new EnlazadoArbolBinario<Integer>(
					Character.getNumericValue(r), reconstruir2(
							preord.substring(1, p + 1), inord.substring(0, p)),
					reconstruir2(preord.substring(p + 1),
							inord.substring(p + 1)));
		}
	}

	// Ejercicio 8
	public static <E> boolean identicos(ArbolBinario<E> a, ArbolBinario<E> b) {
		if (!a.esVacio() && !b.esVacio())
			return a.raiz().equals(b.raiz())
					&& identicos(a.hijoIzq(), b.hijoIzq())
					&& identicos(a.hijoDer(), b.hijoDer());
		else {
			return a.esVacio() && b.esVacio();
		}
	}

	// Ejercicio 9
	public static <E> boolean completo(ArbolBinario<E> a) {
		if (a.esVacio())
			return true;
		if (a.hijoIzq().esVacio() && a.hijoDer().esVacio())
			return true;
		if (!a.hijoIzq().esVacio() && !a.hijoDer().esVacio())
			return completo(a.hijoIzq()) && completo(a.hijoDer());
		else
			return false;
	}

	// Ejercicio 10
	public static <E> ArbolBinario<E> podar(ArbolBinario<E> a) {
		if (a.esVacio())
			return new EnlazadoArbolBinario<E>();
		else {
			if (a.hijoIzq().esVacio() || a.hijoDer().esVacio())
				return new EnlazadoArbolBinario<E>(a.raiz(),
						new EnlazadoArbolBinario<E>(),
						new EnlazadoArbolBinario<E>());
			else {
				return new EnlazadoArbolBinario<E>(a.raiz(),
						podar(a.hijoIzq()), podar(a.hijoDer()));
			}
		}
	}

	// Ejercicio 11
	public static <E> boolean esCamino(ArbolBinario<E> arbol, String camino) {
		return esCamino(arbol, camino, 0);
	}

	private static <E> boolean esCamino(ArbolBinario<E> arbol, String camino,
			int i) {
		if (camino.length() == 0 || i == camino.length())
			return true;
		if (arbol.esVacio())
			return false;
		if (arbol.raiz().equals(camino.charAt(i)))
			return esCamino(arbol.hijoIzq(), camino, i + 1)
					|| esCamino(arbol.hijoDer(), camino, i + 1);
		else
			return false;
	}

	// Ejercicio 12
	public static <E> void visualizarNivel(ArbolBinario<E> a, int nivel) {
		if (!a.esVacio()) {
			if (nivel == 0)
				System.out.print(a.raiz() + " ");
			else {
				visualizarNivel(a.hijoIzq(), nivel - 1);
				visualizarNivel(a.hijoDer(), nivel - 1);
			}
		}
	}

	// Ejercicio 13
	public static <E> void visualizarPalabras(ArbolBinario<E> a, String palabra) {

		if (!a.esVacio()) {
			if (a.hijoIzq().esVacio() && a.hijoDer().esVacio())
				System.out.println(palabra + a.raiz());
			else {
				visualizarPalabras(a.hijoIzq(), palabra + a.raiz());
				visualizarPalabras(a.hijoDer(), palabra + a.raiz());
			}
		}

	}

	// Ejercicio 14
	public static <E extends Comparable<E>> boolean esBusqueda(ArbolBinario<E> a) {
		if (a.esVacio())
			return true;
		if (esMayor(a.raiz(), a.hijoIzq())
				&& esMenorOIgual(a.raiz(), a.hijoDer()))
			return esBusqueda(a.hijoIzq()) && esBusqueda(a.hijoDer());
		else
			return false;
	}

	private static <E extends Comparable<E>> boolean esMayor(E e,
			ArbolBinario<E> a) {
		// Se podr�a simplificar comparandolo exclusivamente con el elemento mas
		// a la derecha del sub�rbol izquierdo
		if (a.esVacio())
			return true;
		else if (a.raiz().compareTo(e) < 0)
			return esMayor(e, a.hijoIzq()) && esMayor(e, a.hijoDer());
		else
			return false;
	}

	private static <E extends Comparable<E>> boolean esMenorOIgual(E e,
			ArbolBinario<E> a) {
		// Se podria simplificar comparandolo exclusivamente con el elemento mas
		// a la izquierda del sub�rbol derecho
		if (a.esVacio())
			return true;
		else if (a.raiz().compareTo(e) > 0)
			return esMenorOIgual(e, a.hijoIzq())
					&& esMenorOIgual(e, a.hijoDer());
		else
			return false;
	}

	// no propuestos

	public static <E extends Comparable<E>> boolean esMonton(ArbolBinario<E> a) {
		if (a.esVacio())
			return true;
		if (esMayorOIgual(a.raiz(), a.hijoIzq())
				&& esMayorOIgual(a.raiz(), a.hijoDer()))
			return esMonton(a.hijoIzq()) && esMonton(a.hijoDer());
		else
			return false;
	}

	private static <E extends Comparable<E>> boolean esMayorOIgual(E e,
			ArbolBinario<E> a) {
		if (a.esVacio())
			return true;
		else if (a.raiz().compareTo(e) > 0)
			return false;
		else
			return true;
	}

	public static ArbolBinario<Character> arbolExpresion(String prefija) {
		if (prefija.length() == 0)
			return new EnlazadoArbolBinario<Character>();
		else if (prefija.length() == 1)
			return new EnlazadoArbolBinario<Character>(prefija.charAt(0),
					new EnlazadoArbolBinario<Character>(),
					new EnlazadoArbolBinario<Character>());
		else {
			char raiz = prefija.charAt(0);
			int posicion = prefija.length() / 2;
			String prefijaSI = prefija.substring(1, posicion + 1);
			String prefijaSD = prefija.substring(posicion + 1);
			return new EnlazadoArbolBinario<Character>(raiz,
					arbolExpresion(prefijaSI), arbolExpresion(prefijaSD));
		}
	}

	public static <E> void misterio(ArbolBinario<E> a) {
		if (!a.esVacio()) {
			System.out.print(a.raiz());
			misterio(a.hijoIzq());
			System.out.print(a.raiz());
			misterio(a.hijoDer());
			System.out.print(a.raiz());
		}
	}

	public static <E> void preorden(ArbolBinario<E> a) {
		if (!a.esVacio()) {
			System.out.print(a.raiz() + " ");
			preorden(a.hijoIzq());
			preorden(a.hijoDer());
		}
	}

	public static <E> void inorden(ArbolBinario<E> a) {
		if (!a.esVacio()) {
			inorden(a.hijoIzq());
			System.out.print(a.raiz() + " ");
			inorden(a.hijoDer());
		}
	}

	public static <E> void postorden(ArbolBinario<E> a) {
		if (!a.esVacio()) {
			postorden(a.hijoIzq());
			postorden(a.hijoDer());
			System.out.print(a.raiz() + " ");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(
				System.in));
		// utilizaremos entrada para leer l�neas desde el teclado
		String preord, inord;
		ArbolBinario<Character> inicial, copia;
		System.out.println("�rboles binarios");
		System.out.print("Introduzca el recorrido en preorden:  ");
		preord = entrada.readLine();
		System.out.print("Introduzca el recorrido en inorden:  ");
		inord = entrada.readLine();
		// reconstruir el arbol
		inicial = reconstruir(preord, inord);

		System.out.println("1. Copia");
		copia = copia(inicial);
		System.out.print("Recorrido en preorden:");
		preorden(copia);
		System.out.println();
		System.out.print("Recorrido en inorden:");
		inorden(copia);
		System.out.println();

		System.out.println("2. �Numero de hojas?: " + numHojas(inicial));
		System.out.println();

		System.out.print("3. Frontera: ");
		Lista<Character> l = new ListaEnlazada<Character>();
		frontera(inicial, l);
		for (Character e : l)
			System.out.println(e + ", ");
		System.out.println();

		System.out.println("4. �Identicos?: "
				+ (identicos(inicial, copia) ? "Si" : "No"));
		System.out.println();

		System.out.println("5. �Es completo?: "
				+ (completo(inicial) ? "S�" : "No"));
		System.out.println();

		System.out.println("6. Podar:");
		copia = podar(inicial);
		System.out.print("Recorrido en preorden:");
		preorden(copia);
		System.out.println();
		System.out.print("Recorrido en inorden:");
		inorden(copia);
		System.out.println();

		String path = "abd";
		System.out.println("7. �Es camino (String)?: "
				+ (esCamino(inicial, path) ? "S�" : "No"));
		System.out.println();

		System.out.println("8. �nivel 2?: ");
		visualizarNivel(inicial, 2);
		System.out.println();

		System.out.println("9. Palabras: ");
		visualizarPalabras(inicial, "");
		System.out.println();

		System.out.println("10. Es de b�squeda: " + esBusqueda(inicial));
		System.out.println();

		misterio(inicial);
		System.out.println();
	}
}
