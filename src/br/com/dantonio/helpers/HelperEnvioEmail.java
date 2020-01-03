package br.com.dantonio.helpers;

import java.io.File;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *  Classe auxiliar que ajudara na passagem/validacao
 *  de muitos objetos para a disponibiliza&ccedil;&atilde;o
 *  da vers&atilde;o.
 * 
 * @author Diego.Fereira
 *
 */
public class HelperEnvioEmail {
	private TextField linkScripts;
	private TextField linkVersaoMobile;
	private TextField linkVersaoGsan;
	private TextField linkFuncionalidades;
	private TextField nomeVersao;
	private TextField loginEmail;
	private TextField senhaEmail;
	private TextArea resultadoEmails;
	private TextField[] linkVersoesMobileCasada;
	private ToggleGroup tipoVersao;
	private ToggleGroup empresa;
	private CheckBox[] opcoesVersao;
	private File releaseNotes;
	
	public HelperEnvioEmail() {
		super();
	}

	public HelperEnvioEmail(TextField linkScripts, TextField linkVersaoMobile, TextField linkVersaoGsan,
			TextField linkFuncionalidades, TextField nomeVersao, TextField loginEmail, TextField senhaEmail,
			TextArea resultadoEmails, TextField[] linkVersoesMobileCasada, ToggleGroup tipoVersao, ToggleGroup empresa,
			CheckBox[] opcoesVersao, File releaseNotes) {
		super();
		this.linkScripts = linkScripts;
		this.linkVersaoMobile = linkVersaoMobile;
		this.linkVersaoGsan = linkVersaoGsan;
		this.linkFuncionalidades = linkFuncionalidades;
		this.nomeVersao = nomeVersao;
		this.loginEmail = loginEmail;
		this.senhaEmail = senhaEmail;
		this.resultadoEmails = resultadoEmails;
		this.linkVersoesMobileCasada = linkVersoesMobileCasada;
		this.tipoVersao = tipoVersao;
		this.empresa = empresa;
		this.opcoesVersao = opcoesVersao;
		this.releaseNotes = releaseNotes;
	}


	public HelperEnvioEmail(TextField linkScripts, TextField linkVersaoMobile,
			TextField linkVersaoGsan, TextField linkFuncionalidades,
			TextField nomeVersao, TextField loginEmail, TextField senhaEmail,
			TextArea resultadoEmails, TextField[] linkVersoesMobileCasada,
			ToggleGroup tipoVersao, CheckBox[] opcoesVersao, File releaseNotes) {
		super();
		this.linkScripts = linkScripts;
		this.linkVersaoMobile = linkVersaoMobile;
		this.linkVersaoGsan = linkVersaoGsan;
		this.linkFuncionalidades = linkFuncionalidades;
		this.nomeVersao = nomeVersao;
		this.loginEmail = loginEmail;
		this.senhaEmail = senhaEmail;
		this.resultadoEmails = resultadoEmails;
		this.linkVersoesMobileCasada = linkVersoesMobileCasada;
		this.tipoVersao = tipoVersao;
		this.opcoesVersao = opcoesVersao;
		this.releaseNotes = releaseNotes;
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


	public TextField getLinkFuncionalidades() {
		return linkFuncionalidades;
	}


	public void setLinkFuncionalidades(TextField linkFuncionalidades) {
		this.linkFuncionalidades = linkFuncionalidades;
	}


	public ToggleGroup getEmpresa() {
		return empresa;
	}


	public void setEmpresa(ToggleGroup empresa) {
		this.empresa = empresa;
	}
}
