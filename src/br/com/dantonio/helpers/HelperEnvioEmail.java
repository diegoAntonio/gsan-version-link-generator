package br.com.dantonio.helpers;

import java.io.File;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import br.com.dantonio.constantesSistema.OpcoesVersao;

/**
 *  Classe auxiliar que ajudara na passagem/validacao
 *  de muitos objetos para a disponibiliza&ccedil;&atilde;o
 *  da vers&atilde;o.
 * 
 * @author Diego.Fereira
 *
 */
public class HelperEnvioEmail {
	private TextField inputLink;
	private TextField resultadoLink;
	private TextField linkScripts;
	private TextField linkVersaoMobile;
	private TextField linkVersaoGsan;
	private TextField nomeVersao;
	private TextField loginEmail;
	private TextField senhaEmail;
	private TextArea resultadoEmails;
	private TextField[] linkVersoesMobileCasada;
	private ToggleGroup tipoVersao;
	private CheckBox[] opcoesVersao;
	private File releaseNotes;
	
	public HelperEnvioEmail() {
		super();
	}

	//TODO: Refazer o construtor no fim.
	public HelperEnvioEmail(TextField inputLink, TextField resultadoLink,
			TextField linkScripts, TextField linkVersaoMobile,
			TextField linkVersaoGsan, TextArea resultadoEmails,
			TextField[] linkVersoesMobileCasada, ToggleGroup tipoVersao,
			CheckBox[] opcoesVersao, TextField nomeVersao) {
		super();
		this.inputLink = inputLink;
		this.resultadoLink = resultadoLink;
		this.linkScripts = linkScripts;
		this.linkVersaoMobile = linkVersaoMobile;
		this.linkVersaoGsan = linkVersaoGsan;
		this.resultadoEmails = resultadoEmails;
		this.linkVersoesMobileCasada = linkVersoesMobileCasada;
		this.tipoVersao = tipoVersao;
		this.opcoesVersao = opcoesVersao;
		this.nomeVersao = nomeVersao;
	}

	public TextField getInputLink() {
		return inputLink;
	}

	public void setInputLink(TextField inputLink) {
		this.inputLink = inputLink;
	}

	public TextField getResultadoLink() {
		return resultadoLink;
	}

	public void setResultadoLink(TextField resultadoLink) {
		this.resultadoLink = resultadoLink;
	}

	public TextField getLinkScripts() {
		return linkScripts;
	}

	public void setLinkScripts(TextField linkScripts) {
		this.linkScripts = linkScripts;
	}

	public TextField getLinkVersaoMobile() {
		return linkVersaoMobile;
	}

	public void setLinkVersaoMobile(TextField linkVersaoMobile) {
		this.linkVersaoMobile = linkVersaoMobile;
	}

	public TextField getLinkVersaoGsan() {
		return linkVersaoGsan;
	}

	public void setLinkVersaoGsan(TextField linkVersaoGsan) {
		this.linkVersaoGsan = linkVersaoGsan;
	}

	public TextArea getResultadoEmails() {
		return resultadoEmails;
	}

	public void setResultadoEmails(TextArea resultadoEmails) {
		this.resultadoEmails = resultadoEmails;
	}

	public TextField[] getLinkVersoesMobileCasada() {
		return linkVersoesMobileCasada;
	}

	public void setLinkVersoesMobileCasada(TextField[] linkVersoesMobileCasada) {
		this.linkVersoesMobileCasada = linkVersoesMobileCasada;
	}

	public ToggleGroup getTipoVersao() {
		return tipoVersao;
	}

	public void setTipoVersao(ToggleGroup tipoVersao) {
		this.tipoVersao = tipoVersao;
	}

	public CheckBox[] getOpcoesVersao() {
		return opcoesVersao;
	}

	public void setOpcoesVersao(CheckBox[] opcoesVersao) {
		this.opcoesVersao = opcoesVersao;
	}
	
	public void testarCheckboxPreenchidos() {
		for (CheckBox check : this.opcoesVersao) {
			if(check.selectedProperty() != null && Boolean.TRUE.equals(check.selectedProperty().get())){
				StringBuilder text = new StringBuilder();
				OpcoesVersao test = OpcoesVersao.getByStringId(check.getId());
				text.append(test.getDescricao());
				text.append(" - SELECIONADO");
				System.out.println(text.toString());
			}
		}
	}

	public TextField getNomeVersao() {
		return nomeVersao;
	}

	public void setNomeVersao(TextField nomeVersao) {
		this.nomeVersao = nomeVersao;
	}

	public TextField getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(TextField loginEmail) {
		this.loginEmail = loginEmail;
	}

	public TextField getSenhaEmail() {
		return senhaEmail;
	}

	public void setSenhaEmail(TextField senhaEmail) {
		this.senhaEmail = senhaEmail;
	}

	public File getReleaseNotes() {
		return releaseNotes;
	}

	public void setReleaseNotes(File releaseNotes) {
		this.releaseNotes = releaseNotes;
	}
}
