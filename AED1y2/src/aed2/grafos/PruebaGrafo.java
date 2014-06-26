package aed2.grafos;

import java.util.Iterator;
import java.util.Vector;

public class PruebaGrafo {

	private static <E, T> Iterator<Vertice<E>> predecesores(Grafo<E, T> g,
			Vertice<E> v) {
		Vector<Vertice<E>> pred = new Vector<Vertice<E>>();
		Iterator<Vertice<E>> itv = g.vertices();
		while (itv.hasNext()) {
			Vertice<E> w = itv.next();
			Iterator<Vertice<E>> it2 = g.adyacentes(w);
			while (it2.hasNext()) {

				if (it2.next().equals(v))
					pred.add(w);
			}
		}
		return pred.iterator();
	}

	public static void main(String[] args) {
		Grafo<String, Integer> g = new ListaAdyacencia<String, Integer>();
		Vertice<String> v1 = new Vertice<String>("Coru�a");
		Vertice<String> v2 = new Vertice<String>("Lugo");
		Vertice<String> v3 = new Vertice<String>("Ourense");
		Vertice<String> v4 = new Vertice<String>("Pontevedra");
		g.insertarArco(new Arco<String, Integer>(v2, v1, 10));
		g.insertarArco(new Arco<String, Integer>(v1, v3, 20));
		g.insertarArco(new Arco<String, Integer>(v2, v4, 115));
		g.insertarArco(new Arco<String, Integer>(v3, v4, 100));
		g.insertarArco(new Arco<String, Integer>(v4, v3, 120));
		System.out.println("Vertices con sus adyacentes: ");
		for (Iterator<Vertice<String>> i = g.vertices(); i.hasNext();) {
			Vertice<String> w = i.next();
			System.out.print(w + ", ");
			System.out.print("Adyacentes: ");
			for (Iterator<Vertice<String>> it = g.adyacentes(w); it.hasNext();)
				System.out.print(it.next());
			System.out.println();
		}
		System.out.println("Arcos: ");
		for (Iterator<Arco<String, Integer>> i = g.arcos(); i.hasNext();)
			System.out.println(i.next());

		System.out.println("Eliminar arco: ");
		Iterator<Arco<String, Integer>> i = g.arcos();
		g.eliminarArco(i.next());

		System.out.println("Nuevos arcos: ");
		for (Iterator<Arco<String, Integer>> it = g.arcos(); it.hasNext();)
			System.out.println(it.next());

		System.out.println("Eliminar Vertice: ");
		Iterator<Vertice<String>> ii = g.vertices();
		Vertice<String> v = ii.next();
		g.eliminarVertice(v);
		System.out.println("Vertices con sus adyacentes: ");
		for (Iterator<Vertice<String>> it = g.vertices(); it.hasNext();) {
			Vertice<String> w = it.next();
			System.out.print(w + ", ");
			System.out.print("Adyacentes: ");
			for (Iterator<Vertice<String>> itr = g.adyacentes(w); itr.hasNext();)
				System.out.print(itr.next());
			System.out.println();
		}

		System.out.println("Arcos: ");
		for (Iterator<Arco<String, Integer>> it = g.arcos(); it.hasNext();)
			System.out.println(it.next());

		System.out.println("Predecesores de " + v3 + ": ");
		for (Iterator<Vertice<String>> pred = predecesores(g, v3); pred
				.hasNext();)
			System.out.println(pred.next());

	}
}
