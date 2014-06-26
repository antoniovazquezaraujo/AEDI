package aed2.arboles_binarios;

import java.util.Iterator;
import java.util.Vector;

import arbolBusqueda.ArbolBinarioBusqueda;
import arbolBusqueda.ArbolBusqueda;

public class ABBMapa<K extends Comparable<K>, V> implements Mapa<K, V> {
	private ArbolBusqueda<Par<K, V>> tree;
	private int numElementos;

	public ABBMapa() {
		tree = new ArbolBinarioBusqueda<Par<K, V>>();
		numElementos = 0;
	}

	public V get(K clave) throws ClaveIncorrecta {
		Par<K, V> par = new Par<K, V>(clave, null);
		if (!tree.buscar(par))
			throw new ClaveIncorrecta();
		else
			return get(tree, clave);
	}

	private V get(ArbolBusqueda<Par<K, V>> a, K clave) {
		if (a.raiz().getClave().equals(clave))
			return a.raiz().getValor();
		else if (a.raiz().getClave().compareTo(clave) < 0)
			return get(a.hijoDer(), clave);
		else
			return get(a.hijoIzq(), clave);
	}

	public void insertar(K clave, V valor) throws ClaveIncorrecta {
		Par<K, V> par = new Par<K, V>(clave, valor);
		if (!tree.buscar(par)) {
			tree.insertar(new Par<K, V>(clave, valor));
			numElementos++;
		} else {
			throw new ClaveIncorrecta("la clave ya existe");
		}
	}

	public void eliminar(K clave) throws ClaveIncorrecta {
		if (!tree.buscar(new Par<K, V>(clave, null)))
			throw new ClaveIncorrecta();
		else {
			V valor = get(clave);
			tree.eliminar(new Par<K, V>(clave, valor));
			numElementos--;
		}
	}

	public int tamanho() {
		return numElementos;
	}

	public Iterator<K> getClaves() {
		Vector<K> v = new Vector<K>();
		inorden(tree, v);
		return v.iterator();
	}

	private void inorden(ArbolBusqueda<Par<K, V>> a, Vector<K> v) {
		if (!a.esVacio()) {
			inorden(a.hijoIzq(), v);
			v.add(a.raiz().getClave());
			inorden(a.hijoDer(), v);
		}
	}

}