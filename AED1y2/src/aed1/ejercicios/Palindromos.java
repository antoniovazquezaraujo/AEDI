package aed1.ejercicios;

public class Palindromos {

	public static boolean esPalindromo(String cadena) {
		int inicio, fin;
		inicio = 0;
		fin = cadena.length() - 1;
		while (inicio < fin) {
			while (!Character.isLetter(cadena.charAt(inicio))) {
				inicio++;
			}
			while (!Character.isLetter(cadena.charAt(fin))) {
				fin--;
			}
			if (Character.toUpperCase(cadena.charAt(inicio)) != Character
					.toUpperCase(cadena.charAt(fin))) {
				return false;
			}
			inicio++;
			fin--;
		}
		return true;
	}

	public static void main(String[] args) {
		assert (esPalindromo("dabale arroz a la zorra el abad"));
		assert (esPalindromo("A man, a plan, a canal, Panama"));
		assert (!esPalindromo("Julia es de Caceres"));
		System.out.println("OK");
	}
}
