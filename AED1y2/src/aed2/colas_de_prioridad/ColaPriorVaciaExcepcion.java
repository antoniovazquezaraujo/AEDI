package aed2.colas_de_prioridad;

@SuppressWarnings("serial")
public class ColaPriorVaciaExcepcion extends RuntimeException {
	public ColaPriorVaciaExcepcion() {
		super();
	}

	public ColaPriorVaciaExcepcion(String s) {
		super(s);
	}

}
