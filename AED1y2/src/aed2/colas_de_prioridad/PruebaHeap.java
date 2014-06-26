package aed2.colas_de_prioridad;

public class PruebaHeap {
	public static void main(String args[]) {
		Heap<String, Integer> colaP = new Heap<String, Integer>(100000);
		colaP.insertar(new Par<String, Integer>("Ana", 50));
		colaP.insertar(new Par<String, Integer>("Pepe", 10));
		colaP.insertar(new Par<String, Integer>("Paco", 8));
		colaP.insertar(new Par<String, Integer>("Bea", 15));
		colaP.insertar(new Par<String, Integer>("Cris", 58));
		colaP.insertar(new Par<String, Integer>("Nacho", 25));
		colaP.insertar(new Par<String, Integer>("Fidel", 25));
		colaP.insertar(new Par<String, Integer>("Carmen", 24));
		colaP.insertar(new Par<String, Integer>("Rosa", 9));
		colaP.insertar(new Par<String, Integer>("Juan", 12));

		System.out.println(colaP);

		System.out.println("eliminado: " + (colaP.suprimir()).getPrioridad());
		System.out.println(colaP);
		System.out.println("eliminado: " + (colaP.suprimir()).getPrioridad());
		System.out.println(colaP);
		System.out.println("eliminado: " + (colaP.suprimir()).getPrioridad());
		System.out.println(colaP);
		System.out.println("eliminado: " + (colaP.suprimir()).getPrioridad());
		System.out.println(colaP);
		System.out.println("eliminado: " + (colaP.suprimir()).getPrioridad());
		System.out.println(colaP);
		System.out.println("eliminado: " + (colaP.suprimir()).getPrioridad());
		System.out.println(colaP);
	}
}