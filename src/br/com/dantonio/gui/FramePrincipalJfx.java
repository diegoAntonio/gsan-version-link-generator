package br.com.dantonio.gui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import br.com.dantonio.constantesSistema.Constantes;
import br.com.dantonio.constantesSistema.OpcoesVersao;
import br.com.dantonio.constantesSistema.ProdutosConsenso;
import br.com.dantonio.email.EmailsClientes;
import br.com.dantonio.emailController.EmailController;
import br.com.dantonio.helpers.HelperEnvioEmail;

public class FramePrincipalJfx {
	private Stage primaryStage;
	private TextField linkScripts;
	private TextField linkVersaoMobile;
	private TextField linkVersaoGsan;
	private TextField linkFuncionalidades;
	private TextField nomeVersao;
	private TextField[] linkVersoesMobileCasada;
	private TextField emailEnvio;
	private Alert mensagemsErro;
	private PasswordField senhaEmailEnvio;
	private TextArea resultadoEmails;
	private ToggleGroup tipoVersao;
	private VBox panelVersaoScript;
	private VBox panelVersaoCasadaMobile;
	private VBox panelParametrosVersaoGsan;
	private VBox panelParametrosVersaoMobile;
	private CheckBox[] checkboxlst;
	private File releaseNotes;
	private CheckBox adicaoRelease;
	
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
		painel.getTabs().add(this.gerarAbaTipoEmail());
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
		Label labelListaEmails;
		Label labelRadioButtons;
		ToggleGroup grupoRadio;
		VBox frameRadioButtons;
		
		frame = this.gerarFramePrincipal();
		abaEmailsClientes = this.gerarAba("Emails dos Clientes");
		
		//Lista de emails
		frameRadioButtons = new VBox();
		grupoRadio = new ToggleGroup();
		this.resultadoEmails = new TextArea();
		this.resultadoEmails.setEditable(true);
		this.resultadoEmails.setWrapText(true);
		labelRadioButtons = new Label("Escolha a Empresa: ");
		frameRadioButtons.getChildren().addAll(labelRadioButtons);
		frameRadioButtons.getChildren().addAll(this.gerarRadioButtonsEmails(grupoRadio));
		frame.getChildren().add(frameRadioButtons);
		labelListaEmails = new Label("Lista Emails: ");
		frame.getChildren().addAll(labelListaEmails, this.resultadoEmails);
		
		abaEmailsClientes.setContent(frame);
		
		return abaEmailsClientes;
	}

	private Tab gerarAbaTipoEmail() {
		Tab abaTextoEmail = this.gerarAba("Tipo do Email");
		VBox framePrincipal = this.gerarFramePrincipal();
		HBox boxBotoes = new HBox();
		Label labelBotoes = new Label("Escolha o Produto:");
		Label labelOpcoes = new Label("Escolha as Opções:");
		Label labelScript = new Label("Informe o link dos Scripts:");
		Label labelVersaoCasadaISC = new Label("Link Versão ISC:");
		Label labelVersaoCasadaGsaneos = new Label("Link Versão Gsaneos:");
		Label labelVersaoCasadaGsanas = new Label("Link Versão Gsanas:");
		Label labelVersaoCasadaAC = new Label("Link Versão Atualização Cadastral:");
		Label labelTextoVersaoGsan = new Label("Link da Versão do Gsan");
		Label labelTextoVersaoMobile = new Label("Informe o link para o APK");
		HBox boxOpcoes = new HBox();
		this.linkScripts = new TextField();		
		
		//RadioButtons com os produtos.
		boxBotoes.getChildren().add(labelBotoes);
		boxBotoes.getChildren().addAll(this.gerarRadioButtonsTiposProdutos());
		framePrincipal.getChildren().add(boxBotoes);
		
		//Painel com o link do Gsan
		this.linkVersaoGsan = new TextField();
		this.panelParametrosVersaoGsan = new VBox();
		this.panelParametrosVersaoGsan.getChildren().add(labelTextoVersaoGsan);
		this.panelParametrosVersaoGsan.getChildren().add(this.linkVersaoGsan);
		this.panelParametrosVersaoGsan.setVisible(false);
		framePrincipal.getChildren().add(this.panelParametrosVersaoGsan);
		
		//Painel com o link da versao Mobile
		this.linkVersaoMobile = new TextField();
		this.panelParametrosVersaoMobile = new VBox();
		this.panelParametrosVersaoMobile.getChildren().add(labelTextoVersaoMobile);
		this.panelParametrosVersaoMobile.getChildren().add(this.linkVersaoMobile);
		this.panelParametrosVersaoMobile.setVisible(false);
		framePrincipal.getChildren().add(this.panelParametrosVersaoMobile);
		
		//Lista de Checkbox com as opcoes de versao disponivel
		boxOpcoes.getChildren().add(labelOpcoes);
		boxOpcoes.getChildren().addAll(this.gerarOpcoesEmail());
		framePrincipal.getChildren().add(boxOpcoes);
		
		//Painel com o link para a versao que contenha Scripts.
		this.panelVersaoScript = new VBox();
		this.panelVersaoScript.getChildren().add(labelScript);
		this.panelVersaoScript.setVisible(false);
		this.panelVersaoScript.getChildren().add(this.linkScripts);
		framePrincipal.getChildren().add(this.panelVersaoScript);
		
		//Painel com os possiveis produtos mobile.
		this.panelVersaoCasadaMobile = new VBox();
		this.iniciarArrayVersoesMobileCasadas();
		this.panelVersaoCasadaMobile.getChildren().add(labelVersaoCasadaISC);
		this.panelVersaoCasadaMobile.getChildren().add(this.linkVersoesMobileCasada[0]);
		this.panelVersaoCasadaMobile.getChildren().add(labelVersaoCasadaGsanas);
		this.panelVersaoCasadaMobile.getChildren().add(this.linkVersoesMobileCasada[1]);
		this.panelVersaoCasadaMobile.getChildren().add(labelVersaoCasadaGsaneos);
		this.panelVersaoCasadaMobile.getChildren().add(this.linkVersoesMobileCasada[2]);
		this.panelVersaoCasadaMobile.getChildren().add(labelVersaoCasadaAC);
		this.panelVersaoCasadaMobile.getChildren().add(this.linkVersoesMobileCasada[3]);
		this.panelVersaoCasadaMobile.setVisible(false);
		framePrincipal.getChildren().add(this.panelVersaoCasadaMobile);
		
		
		abaTextoEmail.setContent(framePrincipal);
		
		return abaTextoEmail;
	}

	private Tab gerarAbaEnvioEmail() {
		Tab abaTextoEmail = this.gerarAba("Envio Email");
		VBox framePrincipal = this.gerarFramePrincipal();
		Label labelExplicacao = new Label("Informe email/senha para envio da versão:");
		Label labelEmail = new Label("Email:");
		Label labelSenha = new Label("Senha:");
		Label labelNomeVersao = new Label("Numero da Versão");
		Button botaoEnvio = new Button("Enviar Versão");
		Button botaoReleaseNotes = new Button("Carregar o Release Notes");
	
		this.emailEnvio = new TextField();
		this.senhaEmailEnvio = new PasswordField();
		this.nomeVersao = new TextField();
		this.adicaoRelease = new CheckBox("Release Adicionado");
		this.adicaoRelease.setSelected(false);
		this.adicaoRelease.setDisable(true);
		botaoEnvio.setOnAction(new BotaoEnvioHandler());
		botaoReleaseNotes.setOnAction(new BotaoReleaseHandler());
		
		framePrincipal.getChildren().add(labelNomeVersao);
		framePrincipal.getChildren().add(this.nomeVersao);
		framePrincipal.getChildren().add(labelExplicacao);
		framePrincipal.getChildren().add(labelEmail);
		framePrincipal.getChildren().add(this.emailEnvio);
		framePrincipal.getChildren().add(labelSenha);
		framePrincipal.getChildren().add(this.senhaEmailEnvio);
		framePrincipal.getChildren().add(botaoReleaseNotes);
		framePrincipal.getChildren().add(this.adicaoRelease);
		framePrincipal.getChildren().add(botaoEnvio);

		abaTextoEmail.setContent(framePrincipal);
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
	
	private List<RadioButton> gerarRadioButtonsTiposProdutos() {
		List<RadioButton> botoesProduto = new ArrayList<RadioButton>();
		this.tipoVersao = new ToggleGroup();
		
		for (ProdutosConsenso temp: ProdutosConsenso.values()) {
			RadioButton botao = new RadioButton(temp.getNomeAppAbreviado());
			botao.setToggleGroup(this.tipoVersao);
			botao.setId(temp.getId().toString());
			botao.setPadding(new Insets(0,10,0,10));
			botoesProduto.add(botao);
			botao.setOnAction(new ParametrosEmailRadioButtonHandler());
		}
		
		return botoesProduto;
	}
	
	private List<CheckBox> gerarOpcoesEmail() {
		List<CheckBox> listaChecks = new ArrayList<CheckBox>();
		int index = 0;
		this.checkboxlst = new CheckBox[OpcoesVersao.values().length];
		
		for (OpcoesVersao temp : OpcoesVersao.values()) {
			CheckBox checkbox = new CheckBox(temp.getDescricao());
			checkbox.setId(temp.getId().toString());
			checkbox.setPadding(new Insets(0,10,0,10));
			checkbox.setOnAction(new CheckboxHandler());
			
			if(index == OpcoesVersao.EMERGENCIAL.getId().intValue()) {
				checkbox.setDisable(true);
			}
			
			listaChecks.add(checkbox);
			this.checkboxlst[index] = checkbox;
			index++;
		}
		
		return listaChecks;
	}
	
	private VBox gerarFramePrincipal() {
		VBox frameGerado;
		Border borda;
		
		frameGerado = new VBox(20);
		borda = new Border(new BorderStroke(Color.BLACK,
				BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
				BorderWidths.DEFAULT));
		frameGerado.setBorder(borda);
		frameGerado.setPadding(new Insets(15, 12, 15, 12));
		
		return frameGerado;
	}
	
	private void iniciarArrayVersoesMobileCasadas() {
		this.linkVersoesMobileCasada = new TextField[4];
		
		for (int i = 0; i < linkVersoesMobileCasada.length; i++) {
			this.linkVersoesMobileCasada[i] = new TextField();
		}
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
	
	private class CheckboxHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			CheckBox checkboxSelecionado = (CheckBox) arg0.getTarget();

			if (checkboxSelecionado != null) {
				Integer idSelecionado = new Integer(checkboxSelecionado.getId());

				switch (idSelecionado) {
				// PossuiScripts
				case 1:
					panelVersaoScript.setVisible(!panelVersaoScript.isVisible());
					break;
				// Versao CASADA/MOBILE
				case 2:
					panelVersaoCasadaMobile.setVisible(!panelVersaoCasadaMobile.isVisible());
					break;
				}
			}
		}
	};
	
	private  class ParametrosEmailRadioButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			RadioButton selecionado = (RadioButton) event.getTarget();
			
			if(selecionado != null) {
				Integer idProduto = new Integer(selecionado.getId());
				
				if(ProdutosConsenso.isVersaoGsan(idProduto)) {
					panelParametrosVersaoGsan.setVisible(true);
					panelParametrosVersaoMobile.setVisible(false);
				} else if(ProdutosConsenso.isVersaoMobile(idProduto)) {
					panelParametrosVersaoMobile.setVisible(true);
					panelParametrosVersaoGsan.setVisible(false);
				}	
			}
		}
	};
	
	private class BotaoReleaseHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			FileChooser escolhedor = new FileChooser();

			escolhedor.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter("PDF", "*.pdf"));
			
			releaseNotes = escolhedor.showOpenDialog(primaryStage);
			
			if(releaseNotes !=null) {
				adicaoRelease.setSelected(true);
			}
		}
	};
	
	private class BotaoEnvioHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			HelperEnvioEmail helper = new HelperEnvioEmail(linkScripts,
					linkVersaoMobile, linkVersaoGsan, linkFuncionalidades,
					nomeVersao, emailEnvio, senhaEmailEnvio, resultadoEmails,
					linkVersoesMobileCasada, tipoVersao, checkboxlst,
					releaseNotes);
			
			helper.setReleaseNotes(releaseNotes);
			if(mensagemsErro != null) {
				mensagemsErro.hide();
			}
			
			try{
				EmailController.enviarEmailVersao(helper);
				
				mensagemsErro = new Alert(AlertType.INFORMATION);
				mensagemsErro.setTitle("Sucesso");
				mensagemsErro.setContentText("Versão disponibilizada com sucesso!");
				mensagemsErro.show();
			}catch (IllegalArgumentException e) {
				e.printStackTrace();
				mensagemsErro = new  Alert(AlertType.ERROR);
				mensagemsErro.setTitle("Erro!");
				mensagemsErro.setContentText(e.getMessage());
				mensagemsErro.show();
			}
		}
	};
	
}
