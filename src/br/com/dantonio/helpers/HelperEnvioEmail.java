package br.com.dantonio.helpers;

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
	private TextField inputLink;
	private TextField resultadoLink;
	private TextField linkScripts;
	private TextField linkVersaoMobile;
	private TextField linkVersaoGsan;
	private TextArea resultadoEmails;
	private TextField caminhoArquivoReleaseNotes;
	private TextField[] linkVersoesMobileCasada;
	private ToggleGroup tipoVersao;
	private ToggleGroup opcoesVersao;
	
	public HelperEnvioEmail(TextField inputLink, TextField resultadoLink,
			TextField linkScripts, TextField linkVersaoMobile,
			TextField linkVersaoGsan, TextArea resultadoEmails,
			TextField caminhoArquivoReleaseNotes,
			TextField[] linkVersoesMobileCasada, ToggleGroup tipoVersao,
			ToggleGroup opcoesVersao) {
		super();
		this.inputLink = inputLink;
		this.resultadoLink = resultadoLink;
		this.linkScripts = linkScripts;
		this.linkVersaoMobile = linkVersaoMobile;
		this.linkVersaoGsan = linkVersaoGsan;
		this.resultadoEmails = resultadoEmails;
		this.caminhoArquivoReleaseNotes = caminhoArquivoReleaseNotes;
		this.linkVersoesMobileCasada = linkVersoesMobileCasada;
		this.tipoVersao = tipoVersao;
		this.opcoesVersao = opcoesVersao;
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

	public TextField getCaminhoArquivoReleaseNotes() {
		return caminhoArquivoReleaseNotes;
	}

	public void setCaminhoArquivoReleaseNotes(TextField caminhoArquivoReleaseNotes) {
		this.caminhoArquivoReleaseNotes = caminhoArquivoReleaseNotes;
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

	public ToggleGroup getOpcoesVersao() {
		return opcoesVersao;
	}

	public void setOpcoesVersao(ToggleGroup opcoesVersao) {
		this.opcoesVersao = opcoesVersao;
	}
}
