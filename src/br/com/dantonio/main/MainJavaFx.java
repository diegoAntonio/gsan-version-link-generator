package br.com.dantonio.main;

import br.com.dantonio.gui.FramePrincipalJfx;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainJavaFx extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FramePrincipalJfx framePrincipalJfx = new FramePrincipalJfx(primaryStage);
		framePrincipalJfx.iniciarAplicacao();
	}

}
