package br.com.dantonio.textoEmail.baseClasses;

/**
 * Classe que representa um Email que sera enviado.
 * 
 * @author Diego.Ferreira
 *
 */
public abstract class Email {
	private String assunto;
	private String corpo;
	private String observacoes;
	private String rodape;
	
	public Email() {
		super();
	}


	public String getAssunto() {
		return assunto;
	}
	
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getRodape() {
		return rodape;
	}

	public void setRodape(String rodape) {
		this.rodape = rodape;
	}


	public abstract String[] gerarEmailVersao();

}
