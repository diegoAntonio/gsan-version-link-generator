package br.com.dantonio.builder.chain.implementations;

import javafx.scene.control.TextField;
import br.com.dantonio.constantesSistema.OpcoesVersao;
import br.com.dantonio.constantesSistema.ProdutosConsenso;
import br.com.dantonio.helpers.HelperEnvioEmail;
import br.com.dantonio.textoEmail.baseClasses.Email;
import br.com.dantonio.textoEmail.decorators.EmailDecorator;
import br.com.dantonio.textoEmail.decorators.VersaoCasada;
import br.com.dantonio.util.Util;

/**
 * Constr&oacute;i um {@link Email} para disponibiliza&ccedil;&atilde;o da apk
 * de algum mobile casado com a vers&atilde;o do Gsan.
 * 
 * @author Diego.Ferreira
 * @since 26/02/2019
 *
 */
public class VersaoCasadaMobile extends GenericEmailOpcaoGenerator {

	public VersaoCasadaMobile(GenericEmailGenerator next) {
		super(next);
		this.opcao = OpcoesVersao.CASADA_MOBILE;
	}

	@Override
	protected Email criarEmailComOpcoes(HelperEnvioEmail helper,
			Email emailConstruido) {
		EmailDecorator email = new VersaoCasada(emailConstruido,
				this.obterCodigoDoProduto(helper.getLinkVersoesMobileCasada()));

		return email;
	}

	private Integer obterCodigoDoProduto(TextField[] textFields) {
		int posicao = 0;
		Integer codigo = null;

		for (TextField textField : textFields) {
			posicao++;
			if (!Util.isObjetoNulo(textField)
					&& !Util.isTextoNuloOuBranco(textField.getText())) {
				break;
			}
		}

		switch (posicao) {
		case 1:
			codigo = ProdutosConsenso.ISC.getId();
			break;

		case 2:
			codigo = ProdutosConsenso.GSANAS.getId();
			break;

		case 3:
			codigo = ProdutosConsenso.GSANEOS.getId();
			break;

		case 4:
			codigo = ProdutosConsenso.GSANAC.getId();
			break;

		default:
			codigo = new Integer(-1);
			break;
		}

		return codigo;
	}
}
