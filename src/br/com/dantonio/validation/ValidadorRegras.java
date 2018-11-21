package br.com.dantonio.validation;

import javafx.scene.control.ToggleGroup;

/**
 * Classe que far&aacute; as valida&ccedil;&otilde;es
 * de regra de negocio para envio das vers&otilde;es
 * 
 * @author Diego.Ferreira
 *
 */
public class ValidadorRegras {

	public static void validarParametrosVersaoGsan(){
		
	}
	
	public static void validarParametrosVersaoMobile() {
		
	}
	
	public static void validarReleaseNotes(){
		
	}
	
	public static void verificarPreenchimentoVersao(ToggleGroup toggleGroup) {
		if(toggleGroup.getSelectedToggle() == null) {
			throw new IllegalArgumentException("Informe o tipo da versão na primeira Aba!");
		}
	}
}
