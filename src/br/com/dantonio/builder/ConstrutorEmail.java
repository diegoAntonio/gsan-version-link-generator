package br.com.dantonio.builder;

import javafx.scene.control.RadioButton;
import br.com.dantonio.constantesSistema.ProdutosConsenso;
import br.com.dantonio.helpers.HelperEnvioEmail;
import br.com.dantonio.textoEmail.baseClasses.Email;

/**
 * Classe que e responsavel por Construir o texto dos 
 * emails das Versoes que serao disponibilizadas
 * 
 * @author dantonio
 * @since 09-09-2018
 *
 */
//TODO:Transformar num builder de verdade.
public class ConstrutorEmail {
	public Email criarEmailVersao(HelperEnvioEmail helper){
		Email emailGerado = null;
		RadioButton versao = (RadioButton) helper.getTipoVersao().getSelectedToggle();
		Integer opcaoVersaoSelecionada = new Integer(versao.getId());
		
		if(ProdutosConsenso.isVersaoGsan(opcaoVersaoSelecionada)) {
			
		} else if(ProdutosConsenso.isVersaoMobile(opcaoVersaoSelecionada)){
			
		}
		
		
		
		return emailGerado;
	}
}
