package aed2.recursividad;

public class Actividad1 {

	// // ejercicio 1
	public static int sumaNEnterosPositivos(int n) {
		if (n == 0)
			return 0;
		else
			return n + sumaNEnterosPositivos(n - 1);
	}

	// // ejercicio 2

	public static int factorial(int n) {
		if (n == 0)
			return 1;
		else
			return n * factorial(n - 1);
	}

	// // ejercicio 3

	public static int potencia(int base, int exponente) {
		if (exponente == 0)
			return 1;
		else
			return base * potencia(base, exponente - 1);
	}

	// // ejercicio 4

	public static int busquedaBinaria(double[] array, int inicio, int fin,
			double elemento) {
		int medio;
		if (inicio > fin)
			return -1;
		else {
			medio = (fin + inicio) / 2;
			// if (array[medio]<elemento)
			if (elemento >= array[medio])
				return busquedaBinaria(array, medio + 1, fin, elemento);
			else if (array[medio] > elemento)
				return busquedaBinaria(array, inicio, medio - 1, elemento);
			else
				return medio;
		}
	}

	// // ejercicio 5

	public static void invertir(int n) {
		if (n < 10)
			System.out.println(n);
		else {
			System.out.print(n % 10);
			invertir(n / 10);
		}
	}

	public static int invertir3(int n, int digitos) {
		if (digitos == 1)
			return n;
		else
			return (n % 10) * (int) Math.pow(10, digitos - 1)
					+ invertir3(n / 10, digitos - 1);
	}

	public static int invertir2(int n, int resultado) {
		if (n == 0)
			return resultado;
		else
			return invertir2(n / 10, resultado * 10 + n % 10);
	}

	// // ejercicio 6

	public static int multiplicacionRusa(int a, int b) {
		if (a == 1)
			return b;
		if (a % 2 != 0)
			return b + multiplicacionRusa(a / 2, b * 2);
		else
			return multiplicacionRusa(a / 2, b * 2);
	}

	public static void main(String[] args) {
		// ejercicio 1
		System.out.println("La suma de los 6 primeros es: "
				+ sumaNEnterosPositivos(6));

		// ejercicio 2
		System.out.println("El factorial de 5 es: " + factorial(5));

		// ejercicio 3
		System.out.println("5 elevado a 3 es: " + potencia(5, 3));

		// ejercicio 4
		double[] elementos = { 2.5, 6, 7, 10, 25 };
		System.out.println("El elemento 10, est� en la posici�n: "
				+ busquedaBinaria(elementos, 0, 4, 10));

		// ejercicio 5
		System.out.print("El inverso de 123 es: ");
		invertir(123);

		// ejercicio 6
		System.out.println("La multiplicaci�n de 27 x 82 es: "
				+ multiplicacionRusa(27, 82));

	}

}
