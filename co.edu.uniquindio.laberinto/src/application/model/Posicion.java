package application.model;

public class Posicion {

	int fila;
	int columna;
	
	public Posicion(int fila, int columna) {
		super();
		this.fila = fila;
		this.columna = columna;
	}
	
	@Override
	public String toString() {
		return "Posicion [fila=" + fila + ", columna=" + columna + "]";
	}

	public boolean equal(int i, int j) {
		if(fila==i && columna==j)
			return true;
		return false;
	}
}
