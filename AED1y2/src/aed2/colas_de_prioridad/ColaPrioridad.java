package aed2.colas_de_prioridad;

public interface ColaPrioridad<E, T extends Comparable<T>> {
	public boolean esVacio();

	public int tamaño();

	public Par<E, T> primero() throws ColaPriorVaciaExcepcion;

	public Par<E, T> suprimir() throws ColaPriorVaciaExcepcion;

	public void insertar(Par<E, T> elemento) throws IllegalArgumentException;
}
