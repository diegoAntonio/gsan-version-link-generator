package br.com.dantonio.builder.chain.implementations;

import javafx.scene.control.CheckBox;
import br.com.dantonio.builder.chain.interfaces.EmailOpcoesGerenator;
import br.com.dantonio.constantesSistema.OpcoesVersao;
import br.com.dantonio.helpers.HelperEnvioEmail;
import br.com.dantonio.textoEmail.baseClasses.Email;

/**
 *  Superclasse que inicia a sequencia do Chain of Responsability
 *  para o caso de Cria&ccedil;&atilde;o de op&ccedil;&otilde;es.
 *  
 * @author Diego.Ferreira
 * @since 26/02/2019
 *
 */
public abstract class GenericEmailOpcaoGenerator implements
		EmailOpcoesGerenator {
	protected GenericEmailOpcaoGenerator next;
	protected OpcoesVersao opcao;

	public GenericEmailOpcaoGenerator(GenericEmailOpcaoGenerator next) {
		super();
		this.next = next;
	}

	@Override
	public Email avaliarGeracaoEmail(HelperEnvioEmail helper,
			Email emailConstruido) {
		Email emailGerado = null;

		if (this.verificarAplicacaoOpcao(helper)) {
			emailGerado = this.criarEmailComOpcoes(helper, emailConstruido);
		} else if (this.next != null) {
			emailGerado = this.next.avaliarGeracaoEmail(helper,emailConstruido);
		} else {
			throw new IllegalArgumentException(
					"Erro, Opcao Informada ao filtro nao existe!");
		}

		return emailGerado;
	}

	protected abstract Email criarEmailComOpcoes(HelperEnvioEmail helper,
			Email emailConstruido);

	/**
	 *  Verifica se a op&ccedil;&atilde;o selecionada na tela &eacute; atendida
	 *  por esta Classe.
	 *  
	 * @param helper - {@link HelperEnvioEmail} contendo os par&acirc;metros selecionados na tela.
	 * @return <code>true</code> se a op&ccedil;&atilde;o  for gerada pore esta unidade e <code>false</code>
	 * caso contr&aacute;rio.
	 */
	protected boolean verificarAplicacaoOpcao(HelperEnvioEmail helper) {
		boolean aplicarOpcao = false;
		CheckBox[] listaOpcoes = helper.getOpcoesVersao();
		
		for (CheckBox checkBox : listaOpcoes) {
			if(this.opcao.equals(OpcoesVersao.getByStringId(checkBox.getId()))) {
				aplicarOpcao = checkBox.isSelected();
				
				if(aplicarOpcao) break;
			}
		}
		
		return aplicarOpcao;
	}
}
