package br.com.dantonio.emailController;

import br.com.dantonio.helpers.HelperEnvioEmail;

/** 
 * Classe que funciona como um controlador validando regra de
 * negocio e criando os objetos corretamente para o envio das 
 * vers&otilde;es.
 
 * @author Diego.Ferreira
 *
 */
public class EmailController {
	
	
	/**
	 *  M&eacute;todo central respons&aacute;vel por fazer a
	 *  cria&ccedil;&atilde;o, valida&ccedil;&atilde;o 
	 *  e envio da versao para os clientes.
	 *  
	 * @param helper - {@link HelperEnvioEmail} criado com os 
	 * parametro informados nas 3 abas.
	 */
	public static void enviarEmailVersao(HelperEnvioEmail helper) {
		//Detectar os tipos de versao que serao disponibilizados
		
		//Validar a versao de acordo com o tipo informado
		
		//Checar se eh teste ou nao.
		
		//Caso esteja ok, validar se foi informado destinatarios, release notes e credenciais
		// do email de envio

	}

}
