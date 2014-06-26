package aed1.ejercicios;

class NodoDeAlumno {
	Alumno alumno;
	NodoDeAlumno nextByName;
	NodoDeAlumno nextByDni;

	public NodoDeAlumno(Alumno dato, NodoDeAlumno nextByName,
			NodoDeAlumno nextByDni) {
		if (nextByDni != null) {
			this.nextByDni = nextByDni;
		} else {
			this.nextByDni = this;
		}
		if (nextByName != null) {
			this.nextByName = nextByName;
		} else {
			this.nextByName = this;
		}
	}

	public Alumno getDato() {
		return alumno;
	}

	public void setDato(Alumno dato) {
		this.alumno = dato;
	}

	public NodoDeAlumno getNextByName() {
		return nextByName;
	}

	public void setNextByName(NodoDeAlumno nextByName) {
		this.nextByName = nextByName;
	}

	public NodoDeAlumno getNextByDni() {
		return nextByDni;
	}

	public void setNextByDni(NodoDeAlumno nextByDni) {
		this.nextByDni = nextByDni;
	}

}

public class ListaAlumnosDosIndices {
	NodoDeAlumno centinelaNombre;
	NodoDeAlumno centinelaDni;

	public ListaAlumnosDosIndices() {
		centinelaNombre = new NodoDeAlumno(null, null, null);
		centinelaDni = new NodoDeAlumno(null, null, null);
	}

	public void insertarByName(NodoDeAlumno nuevo) {
		NodoDeAlumno actual;
		actual = centinelaNombre;
		while (actual.getNextByName() != centinelaNombre) {
			if (actual.getNextByName().alumno.getNombre().compareTo(
					nuevo.alumno.getNombre()) < 0) {
				actual = actual.getNextByName();
			} else {
				nuevo.setNextByName(actual.getNextByName());
				actual.setNextByName(nuevo);
			}
		}
	}

	public void insertarByDni(NodoDeAlumno nuevo) {
		NodoDeAlumno actual;
		actual = centinelaDni;
		while (actual.getNextByDni() != centinelaDni) {
			if (actual.getNextByDni().alumno.getDni() > nuevo.alumno.getDni()) {
				actual = actual.getNextByDni();
			} else {
				nuevo.setNextByDni(actual.getNextByDni());
				actual.setNextByDni(nuevo);
			}
		}
	}

	public void insertar(Alumno alumno) {
		if (isEmpty()) {
			NodoDeAlumno nuevo = new NodoDeAlumno(alumno, centinelaNombre,
					centinelaDni);
			centinelaNombre.setNextByName(nuevo);
			nuevo.setNextByName(centinelaNombre);
			centinelaDni.setNextByDni(nuevo);
			nuevo.setNextByDni(centinelaDni);
		} else {
			NodoDeAlumno nuevo = new NodoDeAlumno(alumno, null, null);
			insertarByName(nuevo);
			insertarByDni(nuevo);
		}
	}

	boolean isEmpty() {
		return (centinelaNombre.getNextByName() == centinelaNombre && centinelaDni
				.getNextByDni() == centinelaDni);
	}

}

class Alumno {
	String nombre;
	int dni;
	int matricula;
	String curso;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
}