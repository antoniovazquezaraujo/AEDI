package aed2.grafos;

import grafo.*;

import java.util.Iterator;
import java.util.Map;

public class Principal {

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
		g.insertarArco(new Arco<String, Integer>(v2, v3, 100));
		g.insertarArco(new Arco<String, Integer>(v4, v2, 120));
		g.insertarArco(new Arco<String, Integer>(v4, v3, 120));

		System.out.println("Todos los v�rtices: ");
		Iterator<Vertice<String>> vertices = g.vertices();
		while (vertices.hasNext())
			System.out.print(vertices.next() + " ");
		System.out.println();

		System.out.println("Todos los arcos: ");
		Iterator<Arco<String, Integer>> arcos = g.arcos();
		while (arcos.hasNext())
			System.out.print(arcos.next() + " ");
		System.out.println();

		// Ejercicio 1. Predecesores
		System.out.print("Predecesores de " + v3 + ": ");
		Iterator<Vertice<String>> itVer = Actividad7.predecesores2(g, v3);
		while (itVer.hasNext())
			System.out.print(itVer.next() + " ");
		System.out.println();

		// Ejercicio 2. Sumidero
		System.out.println("Sumidero " + v3 + "?: "
				+ Actividad7.sumidero(g, v3));

		// Ejercicio 3. Camino entre dos v�rtices
		System.out.println("Hay camino entre los v�rtices: " + v4.getEtiqueta()
				+ ", " + v1.getEtiqueta() + "?: "
				+ Actividad7.hayCaminoEntreDos(g, v4, v1));

		// Ejercicio 4. Conexo
		System.out.println("Conexo ?: " + Actividad7.conexo(g));

		// Ejercicio 5.Visualizar Caminos
		Actividad7.caminos(g, v2, v3);

		// -------------------------------------------------------------------------------------------------------------------------------------------------------------------
		Grafo<Integer, Integer> g1 = new ListaAdyacencia<Integer, Integer>();
		Vertice<Integer> uno = new Vertice<Integer>(1);
		Vertice<Integer> dos = new Vertice<Integer>(2);
		Vertice<Integer> tres = new Vertice<Integer>(3);
		Vertice<Integer> cuatro = new Vertice<Integer>(4);
		Vertice<Integer> cinco = new Vertice<Integer>(5);
		Vertice<Integer> seis = new Vertice<Integer>(6);

		g1.insertarArco(new Arco<Integer, Integer>(uno, dos, 3));
		g1.insertarArco(new Arco<Integer, Integer>(uno, seis, 5));
		g1.insertarArco(new Arco<Integer, Integer>(dos, tres, 7));
		g1.insertarArco(new Arco<Integer, Integer>(dos, seis, 10));
		g1.insertarArco(new Arco<Integer, Integer>(seis, tres, 8));
		g1.insertarArco(new Arco<Integer, Integer>(seis, cuatro, 2));
		g1.insertarArco(new Arco<Integer, Integer>(tres, cuatro, 5));
		g1.insertarArco(new Arco<Integer, Integer>(tres, cinco, 1));
		g1.insertarArco(new Arco<Integer, Integer>(cuatro, cinco, 6));
		// A�ado los arcos en el otro sentido, hace falta para el problema del
		// viajante
		g1.insertarArco(new Arco<Integer, Integer>(dos, uno, 3));
		g1.insertarArco(new Arco<Integer, Integer>(seis, uno, 5));
		g1.insertarArco(new Arco<Integer, Integer>(tres, dos, 7));
		g1.insertarArco(new Arco<Integer, Integer>(seis, dos, 10));
		g1.insertarArco(new Arco<Integer, Integer>(tres, seis, 8));
		g1.insertarArco(new Arco<Integer, Integer>(cuatro, seis, 2));
		g1.insertarArco(new Arco<Integer, Integer>(cuatro, tres, 5));
		g1.insertarArco(new Arco<Integer, Integer>(cinco, tres, 1));
		g1.insertarArco(new Arco<Integer, Integer>(cinco, cuatro, 6));

		Iterator<Arco<Integer, Integer>> arc = g1.arcos();

		System.out.println("\n --- VORACES ---");

		System.out.println("\n------------ Grafo inicial ---------");

		while (arc.hasNext()) {
			Arco<Integer, Integer> a1 = arc.next();
			System.out.println("Vertice Origen: " + a1.getOrigen().toString()
					+ " vertice Destino : " + a1.getDestino().toString()
					+ " Distancia : " + a1.getEtiqueta());
		}

		Map<Vertice<Integer>, Integer> map = Actividad7_Algoritmos.dijkstra(g1,
				uno);

		Iterator<Vertice<Integer>> claves = map.keySet().iterator();

		System.out.println("\n------ Algoritmo de Dijkstra ----------");

		while (claves.hasNext()) {
			Vertice<Integer> c = claves.next();
			System.out.println("Vertice : " + c + " valor : " + map.get(c));
		}

		Grafo<Integer, Integer> gSol = Actividad7_Algoritmos.viajante(g1, uno);

		arc = gSol.arcos();

		System.out.println("\n------------ Algoritmo del Viajante ---------");

		while (arc.hasNext()) {
			Arco<Integer, Integer> a1 = arc.next();
			System.out.println("Vertice Origen: " + a1.getOrigen().toString()
					+ " vertice Destino : " + a1.getDestino().toString()
					+ " Distancia : " + a1.getEtiqueta());
		}

		gSol = Actividad7_Algoritmos.prim(g1, uno);

		arc = gSol.arcos();

		System.out.println("\n------- Algoritmo de Prim --------");

		while (arc.hasNext()) {
			Arco<Integer, Integer> a1 = arc.next();
			System.out.println("Vertice Origen: " + a1.getOrigen().toString()
					+ " vertice Destino : " + a1.getDestino().toString()
					+ " Distancia : " + a1.getEtiqueta());
		}

	}

}
