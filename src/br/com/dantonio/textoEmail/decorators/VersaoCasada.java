package br.com.dantonio.textoEmail.decorators;

import br.com.dantonio.constantesSistema.Constantes;
import br.com.dantonio.constantesSistema.ProdutosMobile;
import br.com.dantonio.textoEmail.baseClasses.Email;
import br.com.dantonio.textoEmail.templateTexto.ConstantesTexto;

/**
 *  Classe que repsenta uma altera&ccedil;&atilde;o
 *  proveniente de uma vers&atilde;o Casada com um Produto
 *  Mobile.
 *  
 * @author Diego.Ferreira
 *
 */
public class VersaoCasada extends EmailDecorator {
	private String nomeProdutoMobile;

	public VersaoCasada(Email email, Integer codigoProdutoMobile) {
		super(email);
		this.linkScripts = email.getLinkScripts();
		this.linkVersao = email.getLinkVersao();
		this.versao = email.getVersao();
		this.nomeProdutoMobile = ProdutosMobile.getNomeProdutoAbreviado(codigoProdutoMobile);
	}

	@Override
	public String[] gerarEmailVersao() {
		final int posicaoObservacoes = 2;
		String[] emailFinal = this.email.gerarEmailVersao();
		String textoVersaoCasada = ConstantesTexto.AVISO_VERSAO_CASADA;
		StringBuilder sb = new StringBuilder(emailFinal[posicaoObservacoes]);
		
		textoVersaoCasada = textoVersaoCasada.replaceAll(ConstantesTexto.REGEX_NOME_PRODUTO_MOBILE,
				this.nomeProdutoMobile);
		
		sb.append("<br/>");
		sb.append(textoVersaoCasada);
		emailFinal[posicaoObservacoes] = sb.toString();
		
		return emailFinal;
	}

}