package aed1.hospital;

import lista.IteradorLista;
import lista.Lista;
import lista.ListaEnlazada;
import cola.Cola;
import cola.EnlazadaCola;

public class ComplejoHospitalario implements Hospital {
	Lista<Medico> medicos;

	public ComplejoHospitalario() {
		medicos = new ListaEnlazada<Medico>();
	}

	@Override
	public boolean insertarMedico(int numMedico) {
		Cola<String> cola = new EnlazadaCola<String>();
		Medico nuevo = new Medico(numMedico, cola);
		if (medicos.contiene(nuevo)) {
			return false;
		}
		if (medicos.esVacio()) {
			medicos.insertarFinal(nuevo);
			return true;
		}
		IteradorLista<Medico> iterador = medicos.iteradorLista();
		while (iterador.hasNext()) {
			Medico next = iterador.next();
			if (numMedico > next.getNumero()) {
				iterador.insertarPrevious(nuevo);
				return true;
			}
		}
		medicos.insertarFinal(nuevo);
		return true;
	}

	@Override
	public boolean altaPaciente(int numMedico, String codigoPaciente) {
		IteradorLista<Medico> iterador = medicos.iteradorLista();
		while (iterador.hasNext()) {
			Medico medico = iterador.next();
			if (medico.getNumero() == numMedico) {
				medico.getPacientes().insertar(codigoPaciente);
				return true;
			}
		}
		return false;
	}

	@Override
	public String atenderPaciente(int numMedico) throws HospitalException {
		IteradorLista<Medico> iterador = medicos.iteradorLista();
		while (iterador.hasNext()) {
			Medico medico = iterador.next();
			if (medico.getNumero() == numMedico) {
				if (medico.getPacientes().esVacio()) {
					throw new HospitalException("Lista vac�a");
				}
				return medico.getPacientes().suprimir();
			}
		}
		throw new HospitalException("M�dico no encontrado");
	}

	@Override
	public boolean hayPacientes(int numMedico) throws HospitalException {
		IteradorLista<Medico> iterador = medicos.iteradorLista();
		while (iterador.hasNext()) {
			Medico medico = iterador.next();
			if (medico.getNumero() == numMedico) {
				if (medico.getPacientes().esVacio()) {
					return false;
				} else {
					return true;
				}
			}

		}
		throw new HospitalException("M�dico no encontrado");
	}

	public String toString() {
		String ret = "";
		IteradorLista<Medico> iterador = medicos.iteradorLista();
		while (iterador.hasNext()) {
			Medico medico = iterador.next();
			ret += medico.toString();
		}
		return ret;
	}

	public static void main(String[] args) {
		ComplejoHospitalario complejo = new ComplejoHospitalario();
		Cola<String> pacientes = new EnlazadaCola<String>();
		Medico perez = new Medico(1, pacientes);
		complejo.insertarMedico(1);
		String paciente = "jose";
		complejo.altaPaciente(1, paciente);
		System.out.println(complejo);
	}
}
