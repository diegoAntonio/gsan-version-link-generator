package br.com.dantonio.textoEmail.baseClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.dantonio.constantesSistema.Constantes;
import br.com.dantonio.constantesSistema.ProdutosConsenso;
import br.com.dantonio.textoEmail.templateTexto.ConstantesTexto;

/**
 *  Classe que representa o {@link Email} que &eacute; disponibilizado
 *  para as empresas na libera&ccedil;&atilde;o de um produto Mobile.
 *  
 * @author dantonio
 *
 */
public class EmailVersaoMobile extends Email {
	private String nomeEmpresa;
	private String nomeProdutoAbreviado;
	private String nomeProdutoExtenso;

	public EmailVersaoMobile() {
		super();
	}	

	public EmailVersaoMobile(String versao, String linkVersao, String produto, String linkScripts, 
			String nomeEmpresa,Integer codigoProduto) {
		super(versao, linkVersao, produto, linkScripts);
		this.nomeEmpresa = nomeEmpresa;
		this.versao = versao;
		this.linkScripts = linkScripts;
		this.produto = produto;
		this.linkVersao = linkVersao;
		this.nomeProdutoAbreviado = ProdutosConsenso.getNomeProdutoAbreviado(codigoProduto);
		this.nomeProdutoExtenso = ProdutosConsenso.getNomeProdutoExtenso(codigoProduto);
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
		assuntoVersaoMobile.append(this.nomeProdutoAbreviado);
		assuntoVersaoMobile.append(" - ");
		assuntoVersaoMobile.append(this.versao);
		assuntoVersaoMobile.append(" - ");
		assuntoVersaoMobile.append(this.nomeEmpresa);
		assuntoVersaoMobile.append(" publicada ");
		assuntoVersaoMobile.append(formatador.format(dataAtual));
		
		return assuntoVersaoMobile.toString();
	}
	
	@Override
	protected String alterarConstantesTexto(String textoVersao) {
		String texto = super.alterarConstantesTexto(textoVersao);
		StringBuilder textoAlterado = new StringBuilder();
		StringBuilder textoLink = new StringBuilder();
		
		textoLink.append(" Versão ");
		textoLink.append(this.nomeProdutoAbreviado);
		textoLink.append(" - ");
		textoLink.append(this.nomeEmpresa);
		textoLink.append(" - ");
		textoLink.append(this.versao);
		
		textoAlterado.append(texto.replaceAll(ConstantesTexto.REGEX_NOME_PRODUTO_MOBILE, this.nomeProdutoExtenso)
								  .replaceAll(ConstantesTexto.REGEX_LINK_VERSAO, this.linkVersao)
								  .replaceAll(ConstantesTexto.REGEX_TEXTO_LINK_DOWNLOAD_MOBILE, textoLink.toString()));
		
		return textoAlterado.toString();
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
}
