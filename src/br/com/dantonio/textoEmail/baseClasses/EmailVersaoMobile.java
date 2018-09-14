package br.com.dantonio.textoEmail.baseClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.dantonio.constantesSistema.Constantes;
import br.com.dantonio.textoEmail.templateTexto.ConstantesTexto;

public class EmailVersaoMobile extends Email {
	private String nomeEmpresa;

	public EmailVersaoMobile() {
		super();
	}	

	public EmailVersaoMobile(String versao, String linkVersao, String produto, String linkScripts, String nomeEmpresa) {
		super(versao, linkVersao, produto, linkScripts);
		this.nomeEmpresa = nomeEmpresa;
		this.versao = versao;
		this.linkScripts = linkScripts;
		this.produto = produto;
		this.linkVersao = linkVersao;
	}

	@Override
	public String[] gerarEmailVersao() {
		int index = 0;
		String[] email = new String[Constantes.TAM_VETOR_EMAIL];
		
		email[index++] = this.gerarAssunto();
		email[index++] = this.alterarConstantesTexto(ConstantesTexto.CORPO_EMAIL_VERSAO_MOBILE);
		email[index++] = " ";
		email[index++] = ConstantesTexto.RODAPE_EMAIL;
		
		return email;
	}
	
	@Override
	public String gerarAssunto() {
		StringBuilder assuntoVersaoMobile = new StringBuilder();
		Date dataAtual = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		
		assuntoVersaoMobile.append("Versão ");
		assuntoVersaoMobile.append(this.produto);
		assuntoVersaoMobile.append(" - ");
		assuntoVersaoMobile.append(this.versao);
		assuntoVersaoMobile.append(" - ");
		assuntoVersaoMobile.append(this.nomeEmpresa);
		assuntoVersaoMobile.append(" publicada ");
		assuntoVersaoMobile.append(formatador.format(dataAtual));
		
		return assuntoVersaoMobile.toString();
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
}
