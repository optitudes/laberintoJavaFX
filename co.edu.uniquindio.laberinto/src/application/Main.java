package application;
	
import java.io.IOException;

import application.controller.Controller;
import application.model.Tablero;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	private Tablero tablero;
	private Stage primaryStage;
	@Override
	public void start(Stage primaryStage) {

		try {
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Laberinto");
			mostrarVentanaPrincipal();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void mostrarVentanaPrincipal() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/laberintoView.fxml"));
			AnchorPane rootLayout = (AnchorPane)loader.load();
			Controller controller = loader.getController();
			controller.setMain(this);
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}

	/*
	 * método que envía la matriz, la posicion inicial, la posicion final y el movimiento permitido
	 * al tablero para que este solucione el laberinto
	 */
	public void solucionarMatriz(char[][] matriz, int[] posInicial, int[] posFinal,char movPermitido) {
		tablero= new Tablero(matriz, posInicial, posFinal,movPermitido);
		tablero.iniciar();


		
	}
}
