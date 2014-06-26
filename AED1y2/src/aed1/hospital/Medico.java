package aed1.hospital;

import cola.Cola;
import cola.EnlazadaCola;

public class Medico {
	private int numColegiado;
	private Cola<String> pacEspera;

	public Medico(int numero, Cola<String> pacientes) {
		this.numColegiado = numero;
		// yo crear�a aqu� la cola con:
		// pacEspera = new Cola<String>();
		pacEspera = pacientes;
	}

	public int getNumero() {
		return numColegiado;
	}

	public Cola<String> getPacientes() {
		return pacEspera;
	}

	public void setNumero(int numero) {
		numColegiado = numero;
	}

	public void setPacientes(Cola<String> pacientes) {
		pacEspera = pacientes;
	}

	public String toString() {
		String ret = "Colegiado: " + numColegiado + " Pacientes: ";
		Cola<String> aux = new EnlazadaCola<String>();
		while (!pacEspera.esVacio()) {
			String codigo = pacEspera.suprimir();
			ret += codigo + ", ";
			aux.insertar(codigo);
		}
		pacEspera = aux;
		return ret;
	}
}
