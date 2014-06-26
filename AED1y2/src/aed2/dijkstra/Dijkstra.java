package aed2.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Vertice implements Comparable<Vertice> {
	public final String name;
	public Arco[] adyacencias;
	public double distance = Double.POSITIVE_INFINITY;
	public Vertice anterior;

	public Vertice(String argName) {
		name = argName;
	}

	public String toString() {
		return name;
	}

	public int compareTo(Vertice other) {
		return Double.compare(distance, other.distance);
	}
}

class Arco {
	public final Vertice destino;
	public final double peso;

	public Arco(Vertice destino, double peso) {
		this.destino = destino;
		this.peso = peso;
	}
}

public class Dijkstra {
	public static void computePaths(Vertice source) {
		source.distance = 0.;
		PriorityQueue<Vertice> vertexQueue = new PriorityQueue<Vertice>();
		vertexQueue.add(source);

		while (!vertexQueue.isEmpty()) {
			// Retira de la cola el de mayor prioridad
			Vertice verticeMasCercano = vertexQueue.poll();
			for (Arco arco : verticeMasCercano.adyacencias) {
				Vertice destinoDelArco = arco.destino;
				double pesoDelArco = arco.peso;
				double distanciaPorEsteCamino = verticeMasCercano.distance
						+ pesoDelArco;
				// Si por aqu� se llega antes...
				if (distanciaPorEsteCamino < destinoDelArco.distance) {
					// Retiramos de la cola ese destino
					vertexQueue.remove(destinoDelArco);
					// Le cambiamos la prioridad y el v�rtice por donde llegamos
					destinoDelArco.distance = distanciaPorEsteCamino;
					destinoDelArco.anterior = verticeMasCercano;
					// y lo volvemos a meter en la cola de prioridad
					vertexQueue.add(destinoDelArco);
				}
			}
		}
	}

	public static List<Vertice> getShortestPathTo(Vertice destino) {
		List<Vertice> path = new ArrayList<Vertice>();
		for (Vertice vertice = destino; vertice != null; vertice = vertice.anterior) {
			path.add(vertice);
		}
		Collections.reverse(path);
		return path;
	}

	public static void main(String[] args) {
		Vertice v0 = new Vertice("La Coru�a");
		Vertice v1 = new Vertice("Lugo");
		Vertice v2 = new Vertice("Ourense");
		Vertice v3 = new Vertice("Pontevedra");
		Vertice v4 = new Vertice("Santiago");

		v0.adyacencias = new Arco[] { new Arco(v1, 5), new Arco(v2, 10),
				new Arco(v3, 8) };
		v1.adyacencias = new Arco[] { new Arco(v0, 5), new Arco(v2, 3),
				new Arco(v4, 7) };
		v2.adyacencias = new Arco[] { new Arco(v0, 10), new Arco(v1, 3) };
		v3.adyacencias = new Arco[] { new Arco(v0, 8), new Arco(v4, 2) };
		v4.adyacencias = new Arco[] { new Arco(v1, 7), new Arco(v3, 2) };
		Vertice[] vertices = { v0, v1, v2, v3, v4 };
		computePaths(v0);
		for (Vertice v : vertices) {
			System.out.println("Distance to " + v + ": " + v.distance);
			List<Vertice> path = getShortestPathTo(v);
			System.out.println("Path: " + path);
		}
	}
}