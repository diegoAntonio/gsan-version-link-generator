package br.com.dantonio.gui;

import br.com.dantonio.constantesSistema.Constantes;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
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
		 primaryStage.setHeight(Constantes.ALTURA_PADRAO);
		 primaryStage.setWidth(Constantes.LARGURA_PADRAO);
	        StackPane root = new StackPane();
	        root.getChildren().add(this.gerarPainelDeAbas());
	        primaryStage.setScene(new Scene(root, 300, 250));
	        
		
	}
	
	private TabPane gerarPainelDeAbas() {
		TabPane painel = new TabPane();
		painel.getTabs().add(this.gerarAbaEmailClientes());
		painel.getTabs().add(this.gerarAbaTextoEmail());
		
		return painel;
	}
	
	public void iniciarAplicacao() {
		this.primaryStage.show();
	}
	
	
	private Tab gerarAba(String nomeAba) {
		Tab aba1 = new Tab(nomeAba);
		aba1.setClosable(false);
		
		return aba1;
	}
	
	private Tab gerarAbaEmailClientes() {
		Tab abaEmailsClientes = this.gerarAba("Emails dos Clientes");
		HBox frame = new HBox(5);
		frame.getChildren().addAll(new Label("Name:"), new Text("teste"));
		
		abaEmailsClientes.setContent(frame);
		
		return abaEmailsClientes;
	}

	private Tab gerarAbaTextoEmail() {
		Tab abaTextoEmail = this.gerarAba("Texto do Email");
		
		return abaTextoEmail;
	}
	
}
