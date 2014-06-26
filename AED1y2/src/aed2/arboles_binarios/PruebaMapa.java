package aed2.arboles_binarios;

import java.util.Iterator;

public class PruebaMapa {

	public static void main(String args[]) {

		Mapa<Integer, String> mapa = new ABBMapa<Integer, String>();

		mapa.insertar(4, "Elemento 4");
		mapa.insertar(5, "Elemento 5");
		mapa.insertar(8, "Elemento 8");
		// mapa.insertar(8,"Elemento 8b");
		mapa.insertar(1, "Elemento 1");
		mapa.insertar(3, "Elemento 3");

		System.out.println("Clave 3->" + mapa.get(3));
		// System.out.println("Clave 15->"+mapa.obtenerValor(15)); //ERROR CLAVE
		// NO EXISTE!

		System.out.println("Eliminar clave 3");
		mapa.eliminar(3); // eliminamos una clave
		// System.out.println("Clave 3->"+mapa.obtenerValor(3)); //ERROR CLAVE
		// NO EXISTE!

		System.out.println("Eliminar clave 4");
		mapa.eliminar(4);

		Iterator<Integer> itr = mapa.getClaves();
		while (itr.hasNext()) {
			Integer c = itr.next();
			System.out.println(c + "->" + mapa.get(c));
		}

	}
}
