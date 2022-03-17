package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller implements Initializable {
	Main main;
	char[][] matriz= new char[5][5];

	int[] posInicial= new int[2];
	int[] posFinal= new int[2];

	char  movPermitido; 
	char  posInicialChar;
	char  posFinalChar;

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCas21;

    @FXML
    private TextField txtCas43;

    @FXML
    private TextField txtCas00;

    @FXML
    private TextField txtCas22;

    @FXML
    private TextField txtCas44;

    @FXML
    private TextField txtCas01;

    @FXML
    private TextField txtCas23;

    @FXML
    private TextField txtCas02;

    @FXML
    private TextField txtCas24;

    @FXML
    private TextField txtCas40;

    @FXML
    private TextField txtCas41;

    @FXML
    private TextField txtCas20;

    @FXML
    private TextField txtCas42;

    @FXML
    private TextField txtCas03;

    @FXML
    private Button btnIniciar;

    @FXML
    private TextField txtCas04;

    @FXML
    private TextField txtPosInicial;

    @FXML
    private TextField txtPosFinal;

    @FXML
    private TextField txtCas10;

    @FXML
    private TextField txtCas32;

    @FXML
    private TextField txtCas11;

    @FXML
    private TextField txtCas33;

    @FXML
    private TextField txtCas12;

    @FXML
    private TextField txtCas34;

    @FXML
    private TextField txtCas13;

    @FXML
    private TextField txtMovPermitido;

    @FXML
    private TextField txtCas30;

    @FXML
    private TextField txtCas31;

    @FXML
    private TextField txtCas14;

    @FXML
    void iniciarAction(ActionEvent event) {
    	iniciar();

  }

	private void iniciar() {
		matriz=new char[5][5];
		validarMatriz();
		
	
		
	}

	/*
	 * metodo que valida la matriz y la manda al main para que se solucione 
	 * el laberinto
	 */
	private void validarMatriz() {
		ArrayList<TextField> listaTextFields=obtenerTextFields();
		if(validarCasillas(listaTextFields).isEmpty()){

			posInicialChar=txtPosInicial.getText().charAt(0);
			posFinalChar=txtPosFinal.getText().charAt(0);
			movPermitido=txtMovPermitido.getText().charAt(0);
			llenarMatriz(listaTextFields);
			main.solucionarMatriz(matriz,posInicial,posFinal,movPermitido);
		}

	}

		

	/*
	 * metodo que llena la matriz con los caracteres de la listaTextFields
	 */
	private void llenarMatriz(ArrayList<TextField> listaTextFields) {
		int indice=0;
		String texto;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {

				texto=listaTextFields.get(indice).getText();
				matriz[i][j]=texto.charAt(0);

				if(texto.charAt(0)==posInicialChar){
					posInicial[0]=i;
					posInicial[1]=j;
				}
				if(texto.charAt(0)==posFinalChar){
					posFinal[0]=i;
					posFinal[1]=j;
				}
				indice++;
			}
			
		}
	}

	/*
	 * método que valida las casillas del tablero
	 */
	private String validarCasillas(ArrayList<TextField> listaCasillas) {

		String mensaje="";

		String movPermitido=txtMovPermitido.getText();
		String posInicial=txtPosInicial.getText();
		String posFinal=txtPosFinal.getText();

		int contadorElementos=0;
		boolean error=false;
		
		
		String texto;
		mensaje+=validarPuntos(posInicial,posFinal,movPermitido);

		validarCaja(txtPosInicial);
		validarCaja(txtPosFinal);
		validarCaja(txtMovPermitido);

		if(mensaje.isEmpty()){
			for (TextField textField : listaCasillas) {
				texto=textField.getText();
				if(validarCaja(textField))
					error=true;
				if(texto.equals(posInicial) || texto.equals(posFinal))
					contadorElementos++;
			}
		}
		if(error==true)
			mensaje+="las casillas del tablero deben tener un único caracter por casilla\n";
		if(contadorElementos!=2)
			mensaje+="la posicion inicial y la final deben aparecer solo una vez en el laberinto";
		
		System.err.println(mensaje);

		return mensaje;
		
	}

	/*
	 * metodo que se asegura de que las casillas con los puntos principales(pos inicial, pos final, movimiento permitido)
	 * sean válidas
	 */
	private String validarPuntos(String string, String string2, String string3) {
		String mensaje="";
		
		if( !(string.isEmpty() && string2.isEmpty() && string3.isEmpty()) ){
			
			if(string.equals(string2) || string3.equals(string2) || string.equals(string3))
				mensaje="las posiciones(inicial/final) y el movimiento permitido no pueden coincidir(ser iguales)";
			
		}
		
		
		return mensaje;
	}

	/*
	 * metodo que valida una caja de texto
	 */
	private boolean validarCaja(TextField txt) {
		String texto=txt.getText();
		if(texto.length()!=1){
			txt.setText("!");;
			return true;
		}
		return false;

	}

	/*
	 * metodo que linkea los textfields a un arraylist para manejarlos facilmente
	 */
	private ArrayList<TextField> obtenerTextFields() {
		ArrayList<TextField> listaTextFields= new ArrayList<TextField>();
		
		listaTextFields.add(txtCas00);
		listaTextFields.add(txtCas01);
		listaTextFields.add(txtCas02);
		listaTextFields.add(txtCas03);
		listaTextFields.add(txtCas04);
		
		listaTextFields.add(txtCas10);
		listaTextFields.add(txtCas11);
		listaTextFields.add(txtCas12);
		listaTextFields.add(txtCas13);
		listaTextFields.add(txtCas14);

		listaTextFields.add(txtCas20);
		listaTextFields.add(txtCas21);
		listaTextFields.add(txtCas22);
		listaTextFields.add(txtCas23);
		listaTextFields.add(txtCas24);
		
		listaTextFields.add(txtCas30);
		listaTextFields.add(txtCas31);
		listaTextFields.add(txtCas32);
		listaTextFields.add(txtCas33);
		listaTextFields.add(txtCas34);

		listaTextFields.add(txtCas40);
		listaTextFields.add(txtCas41);
		listaTextFields.add(txtCas42);
		listaTextFields.add(txtCas43);
		listaTextFields.add(txtCas44);


		
		
		return listaTextFields;
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

	public void setMain(Main main) {
		this.main=main;
		
	}

	
}
