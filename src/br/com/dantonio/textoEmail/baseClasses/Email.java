package br.com.dantonio.textoEmail.baseClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.dantonio.textoEmail.templateTexto.ConstantesTexto;

/**
 * Classe que representa um Email que sera enviado.
 * 
 * @author Diego.Ferreira
 *
 */
public abstract class Email {
	protected String versao;
	protected String corpo;
	protected String observacoes;
	protected String rodape;
	protected String linkVersao;
	protected String produto;
	protected String linkScripts;
	
	public Email() {
		super();
	}
	
	public Email(String versao, String linkVersao, String produto,
			String linkScripts) {
		super();
		this.versao = versao;
		this.linkVersao = linkVersao;
		this.produto = produto;
		this.linkScripts = linkScripts;
	}


	public String getVersao() {
		return versao;
	}
	
	public void setVersao(String versao) {
		this.versao = versao;
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


	public String getLinkVersao() {
		return linkVersao;
	}

	public void setLinkVersao(String linkVersao) {
		this.linkVersao = linkVersao;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getLinkScripts() {
		return linkScripts;
	}

	public void setLinkScripts(String linkScripts) {
		this.linkScripts = linkScripts;
	}

	public abstract String[] gerarEmailVersao();
	
	protected String gerarAssunto() {
		StringBuilder sb = new StringBuilder();
		Date dataAtual = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		
		sb.append("Versão ");
		sb.append(this.produto);
		sb.append(" ");
		sb.append(this.versao);
		sb.append(" publicada ");
		sb.append(formatador.format(dataAtual));
		
		return sb.toString();
	}
	
	protected String alterarConstantesTexto(String textoVersao) {
		String temp;
		temp = textoVersao.replace(ConstantesTexto.REGEX_LINK_VERSAO, this.linkVersao);
		temp = temp.replace(ConstantesTexto.REGEX_NOME_VERSAO, this.versao);
		temp = temp.replace(ConstantesTexto.REGEX_SCRIPT_VERSAO, this.linkScripts);
		
		return temp.toString();
	}
}
