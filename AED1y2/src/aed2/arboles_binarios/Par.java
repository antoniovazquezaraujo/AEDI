package aed2.arboles_binarios;

public class Par<K extends Comparable<K>, V> implements Comparable<Par<K, V>> {
	private K clave;
	private V valor;

	public Par(K c, V v) {
		clave = c;
		valor = v;
	}

	public K getClave() {
		return clave;
	}

	public V getValor() {
		return valor;
	}

	public void setValor(V v) {
		valor = v;
	}

	public int compareTo(Par<K, V> p) {
		return clave.compareTo(p.getClave());
	}
}
