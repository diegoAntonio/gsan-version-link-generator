package br.com.dantonio.builder.chain.implementations;

import javafx.scene.control.RadioButton;
import br.com.dantonio.builder.chain.interfaces.EmailGenerator;
import br.com.dantonio.constantesSistema.ProdutosConsenso;
import br.com.dantonio.helpers.HelperEnvioEmail;
import br.com.dantonio.textoEmail.baseClasses.Email;

/**
 * Classe gen&eacute;rica que constr&oacute;i os {@link Email} das
 * vers&otilde;es.
 * 
 * @author Diego.Ferreira
 * @since 25/02/2019
 *
 */
public abstract class GenericEmailGenerator implements EmailGenerator {
	protected GenericEmailGenerator next;
	protected Email emailGerado;
	protected ProdutosConsenso produtoAlvo;

	public GenericEmailGenerator(GenericEmailGenerator next) {
		super();
		this.next = next;
	}

	public Email avaliarGeracaoEmail(HelperEnvioEmail helper) {
		Email emailGerado = null;

		if (this.verificaVersao(helper)) {
			emailGerado = this.gerarEmailVersao(helper);
		} else if (this.next != null) {
			emailGerado = this.next.avaliarGeracaoEmail(helper);
		} else {
			throw new IllegalArgumentException(
					"Erro, Opcao Informada ao filtro nao existe!");
		}

		return emailGerado;
	}

	protected abstract Email gerarEmailVersao(HelperEnvioEmail helper);

	/**
	 * Verifica se a classe atual &eacute; a respons&aacute;vel por criar o
	 * {@link Email} corretamente.
	 * 
	 * @param helper
	 * @return <code>true</code> se a Classe for a respons&aacute;vel,
	 *         <code>false</code> caso contr&aacute;rio.
	 */
	protected boolean verificaVersao(HelperEnvioEmail helper) {
		RadioButton radio = (RadioButton) helper.getTipoVersao()
				.getSelectedToggle();
		Integer idInformado = new Integer(radio.getId());

		ProdutosConsenso aux = ProdutosConsenso.getById(idInformado);
		return this.produtoAlvo.equals(aux);
	}
}
