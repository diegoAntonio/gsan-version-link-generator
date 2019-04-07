package br.com.dantonio.builder;

import br.com.dantonio.builder.chain.implementations.GenericEmailGenerator;
import br.com.dantonio.builder.chain.implementations.GenericEmailOpcaoGenerator;
import br.com.dantonio.builder.chain.implementations.VersaoCasadaMobileChain;
import br.com.dantonio.builder.chain.implementations.VersaoComScriptsChain;
import br.com.dantonio.builder.chain.implementations.VersaoEstadualChain;
import br.com.dantonio.builder.chain.implementations.VersaoGsanacChain;
import br.com.dantonio.builder.chain.implementations.VersaoGsaneosChain;
import br.com.dantonio.builder.chain.implementations.VersaoIscChain;
import br.com.dantonio.builder.chain.implementations.VersaoMunicipalChain;
import br.com.dantonio.helpers.HelperEnvioEmail;
import br.com.dantonio.textoEmail.baseClasses.Email;
import javafx.scene.control.CheckBox;

/**
 * Classe que e responsavel por Construir o texto dos 
 * emails das Versoes que serao disponibilizadas
 * 
 * @author dantonio
 * @since 09-09-2018
 *
 */
public class ConstrutorEmail {
	private GenericEmailGenerator chainEmails;
	private GenericEmailOpcaoGenerator chainOpcoes;
	
	public ConstrutorEmail() {
		VersaoGsanacChain gsanac = new VersaoGsanacChain(null);
		VersaoGsaneosChain gsaneos = new VersaoGsaneosChain(gsanac);
		VersaoIscChain isc = new VersaoIscChain(gsaneos);
		VersaoMunicipalChain municipal = new VersaoMunicipalChain(isc);
		this.chainEmails = new VersaoEstadualChain(municipal);
		
		VersaoComScriptsChain comScripts = new VersaoComScriptsChain(null);
		this.chainOpcoes = new VersaoCasadaMobileChain(comScripts);
		
	}
	
	public Email criarEmailVersao(HelperEnvioEmail helper){
		Email emailGerado = null;
		
		emailGerado = this.chainEmails.avaliarGeracaoEmail(helper);
		
		if(this.verificarOpcionaisEmail(helper)) {
			emailGerado = this.chainOpcoes.avaliarGeracaoEmail(helper, emailGerado);
		}
		
		return emailGerado;
	}
	
	
	private boolean verificarOpcionaisEmail(HelperEnvioEmail helper) {
		boolean temOpcional = false;
		CheckBox[] opcoesVersao = helper.getOpcoesVersao();
		
		for (CheckBox checkBox : opcoesVersao) {
			temOpcional = checkBox.isSelected();
			
			if(temOpcional) break;
		}
		
		return temOpcional;
	}
}
