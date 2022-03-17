package application.model;

import java.util.ArrayList;

public class Tablero {

	char[][] matriz; 
	int[][] move= {{0,1},{0,-1},{-1,0},{1,0}};
	int[] movSelect;
	
	char movPermitido;
	int[] posInicial;
	int[] posFinal;
	int   contadorSoluciones;
	boolean primerMovimiento=false;

	ArrayList<Posicion> pasos = new ArrayList<>();

	
	public Tablero(char[][] matriz,int[] posInicial,int[] posFinal,char movPermitido) {
		super();
		this.matriz = matriz;
		this.posInicial=posInicial;
		this.posFinal=posFinal;
		this.movPermitido= movPermitido;

		matriz[posInicial[0]][posInicial[1]]=movPermitido;
		contadorSoluciones=0;
	}

	/*
	 * metodo que inicia el backtracking
	 */
	public void iniciar() {
		resolver(posInicial[0],posInicial[1]);
	}

	/*
	 * backtracking
	 */
	public void resolver(int fila, int columna) {

		if(fila==posFinal[0] && columna==posFinal[1]) {
			pasos.add(new Posicion(fila,columna));
			contadorSoluciones++;
			imprimirPasos();
			pasos.remove(pasos.size()-1);
		}else {
			try {
				if(matriz[fila][columna]==movPermitido   && !verificarPaso(fila,columna)){
					for (int i = 0; i < move.length; i++) {
						movSelect=move[i];	
						pasos.add(new Posicion(fila,columna));
						resolver(fila+movSelect[0],columna+movSelect[1]);
						pasos.remove(pasos.size()-1);
					}
				}

			} catch (Exception e) {
			}
		}
	}


	/*
	 * metodo que verifica si el paso ingresado por parametro ya está 
	 * en la lista de pasos
	 */
	private boolean verificarPaso(int i, int j) {
		for (Posicion posicion : pasos) {
			if(posicion.equal(i, j))
				return true;
		}
		return false;
	}

	/*
	 * método que imprime los pasos
	 */
	public void imprimirPasos() {

		System.out.println("Solucion numero :"+contadorSoluciones);
		for (Posicion p : pasos) {
			System.out.println(p.toString());
		}
		System.out.println("---------------------------");
	}
}
