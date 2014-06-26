package aed2.arboles_generales;

@SuppressWarnings("serial")
public class SubarbolNoContenidoExcepcion extends RuntimeException {
	public SubarbolNoContenidoExcepcion() {
		super();
	}

	public SubarbolNoContenidoExcepcion(String mensaje) {
		super(mensaje);
	}
}