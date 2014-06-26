package aed2.arboles_binarios;

import java.util.Iterator;

public interface Mapa<K extends Comparable<K>, V> {

	public V get(K clave) throws ClaveIncorrecta;

	public void insertar(K clave, V valor) throws ClaveIncorrecta;

	public void eliminar(K clave) throws ClaveIncorrecta;

	public int tamanho();

	public Iterator<K> getClaves();

}