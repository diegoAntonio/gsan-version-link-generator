package br.com.dantonio.gui;

import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FramePrincipalJfx {
	private Stage primaryStage;
	
	public FramePrincipalJfx(Stage primaryStage) {
		super();
		this.primaryStage = primaryStage;
		this.iniciarComponentes(primaryStage);
	}


	private void iniciarComponentes(Stage primaryStage) {
		 primaryStage.setTitle("Gsan Link Generator 2.0");  
	        StackPane root = new StackPane();
	        root.getChildren().add(this.gerarAbas());
	        primaryStage.setScene(new Scene(root, 300, 250));
	        
		
	}
	
	private TabPane gerarAbas() {
		TabPane painel = new TabPane();
		Tab aba1 = new Tab("Gerador de Links");
		Tab aba2 = new Tab("Gerador de Email");

		aba1.setClosable(false);
		aba2.setClosable(false);

		painel.getTabs().addAll(aba1, aba2);
		
		return painel;
	}
	
	
	public void iniciarAplicacao() {
		this.primaryStage.show();
	}

}
