package br.com.dantonio.builder;

/**
 * Classe que e responsavel por Construir o texto dos 
 * emails das Versoes que serao disponibilizadas
 * 
 * @author dantonio
 * @since 09-09-2018
 *
 */
public class ConstrutorEmail {
	StringBuilder assunto;
	StringBuilder corpoDotexto;
	String linkVersao;
	boolean isVersaoEmergencial;
	boolean possuiScript;
	boolean versaoCasadaIsc;
	
	public ConstrutorEmail() {
		super();
		this.assunto = new StringBuilder();
		this.corpoDotexto = new StringBuilder();
	}
	
	public StringBuilder getAssunto() {
		return assunto;
	}
	public void setAssunto(StringBuilder assunto) {
		this.assunto = assunto;
	}
	public StringBuilder getCorpoDotexto() {
		return corpoDotexto;
	}
	public void setCorpoDotexto(StringBuilder corpoDotexto) {
		this.corpoDotexto = corpoDotexto;
	}
}
