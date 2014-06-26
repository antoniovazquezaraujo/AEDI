package aed1.hospital;

public interface Hospital {
	// Hospital()

	/*
	 * Necesita: Produce: Inserci�n de medico Modifica: this
	 */
	public boolean insertarMedico(int numMedico);

	/*
	 * Necesita: Produce: Inserci�n de medico( true si lo insert�) Modifica:
	 * this
	 */
	public boolean altaPaciente(int numMedico, String codigoPaciente);

	/*
	 * Necesita: numMedico registrado, Produce: Agrega paciente en la cola del
	 * m�dico (false si ya est�) Modifica: this
	 */
	String atenderPaciente(int numMedico) throws HospitalException;

	/*
	 * Necesita: Que exista el m�dico, y que su lista no est� vac�a Produce:
	 * Elimina al paciente de la cola (String de su c�dico) Modifica: this
	 */
	boolean hayPacientes(int numMedico) throws HospitalException;
	/*
	 * Necesita: Que exista el m�dico, y que su lista no est� vac�a Produce:
	 * True si existen pacientes en la cola del m�dico Modifica: this
	 */
}
