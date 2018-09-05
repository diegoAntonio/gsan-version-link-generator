package br.com.dantonio.gui;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import br.com.dantonio.constantesSistema.Constantes;
import br.com.dantonio.converter.LinkConverter;
import br.com.dantonio.email.EmailsClientes;

public class FramePrincipalJfx {
	private Stage primaryStage;
	private TextField inputLink;
	private TextField resultadoLink;
	private TextArea resultadoEmails;
	
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
		painel.getTabs().add(this.gerarAbaEnvioEmail());
		
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
		Tab abaEmailsClientes;
		VBox frame;
		Border borda;
		Label labelLink;
		Label labelResultadoLink;
		Label labelListaEmails;
		Button botaoGerarLink;
		ToggleGroup grupoRadio;
		FlowPane frameRadioButtons;
		
		abaEmailsClientes = this.gerarAba("Emails dos Clientes");
		frame = new VBox(20);
		borda = new Border(new BorderStroke(Color.BLACK,
				BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
				BorderWidths.DEFAULT));
		botaoGerarLink = new Button("Gerar Link da Versão");
		frame.setBorder(borda);
		frame.setPadding(new Insets(15, 12, 15, 12));
		
		//Link Interno FTP
		labelLink = new Label("Link Interno FTP:");
		this.inputLink = new TextField();
		botaoGerarLink.setOnAction(new ButtonHandler());
		frame.getChildren().addAll(labelLink,this.inputLink);
		frame.getChildren().addAll(botaoGerarLink);
		
		//Resultado Link da Versao FTP
		labelResultadoLink = new Label("Resultado link da versão: ");
		this.resultadoLink = new TextField();
		this.resultadoLink.setEditable(false);
		frame.getChildren().addAll(labelResultadoLink,this.resultadoLink);
		
		//Lista de emails
		frameRadioButtons = new FlowPane();
		frameRadioButtons.setHgap(20);
		grupoRadio = new ToggleGroup();
		this.resultadoEmails = new TextArea();
		this.resultadoEmails.setEditable(false);
		this.resultadoEmails.setWrapText(true);
		frameRadioButtons.getChildren().addAll(this.gerarRadioButtonsEmails(grupoRadio));
		frame.getChildren().add(frameRadioButtons);
		labelListaEmails = new Label("Lista Emails: ");
		frame.getChildren().addAll(labelListaEmails, this.resultadoEmails);
		
		abaEmailsClientes.setContent(frame);
		
		return abaEmailsClientes;
	}

	private Tab gerarAbaTextoEmail() {
		Tab abaTextoEmail = this.gerarAba("Texto do Email");
		
		return abaTextoEmail;
	}
	
	private Tab gerarAbaEnvioEmail() {
		Tab abaTextoEmail = this.gerarAba("Envio Email");
		
		return abaTextoEmail;
	}
	
	private List<RadioButton> gerarRadioButtonsEmails(ToggleGroup grupo){
		List<RadioButton> emails = new ArrayList<RadioButton>();
		
		for (EmailsClientes email : EmailsClientes.values()) {
			RadioButton temp = new RadioButton(email.getNomeEmpresa());
			temp.setOnAction(new RadioButtonHandler());
			temp.setToggleGroup(grupo);
			temp.setId(String.valueOf(email.getIdCliente()));
			emails.add(temp);
		}
		
		return emails;
	}
	
	
	private class RadioButtonHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			RadioButton escolhido = (RadioButton) event.getTarget();
			resultadoEmails.setText(" ");
			
			if (escolhido != null) {
				Integer valor = new Integer(escolhido.getId());
				String emails = "";

				switch (valor.intValue()) {
				case 0:
					emails = EmailsClientes.getEmailClientesGsan();
					break;

				case 12:
					emails = EmailsClientes.getEmailsClientesFTP();
					break;

				case 13:
					emails = EmailsClientes.getEmailsClientesJenkins();
					break;

				default:
					emails = EmailsClientes.getEmailClientes(valor.intValue());
					break;
				}

				resultadoEmails.setText(emails);
			}
			
		}
		
	};
	
	private class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			resultadoLink.setText(" ");
			if(inputLink != null && !inputLink.getText().trim().isEmpty()){
				resultadoLink.setText(LinkConverter.formatarLinkExternoFTP(inputLink.getText().trim()));
			}
		}
		
	};
}
