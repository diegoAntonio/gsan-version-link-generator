package br.com.dantonio.textoEmail.templateTexto;

/**
 * Classe que guarda o texto formatado das versoes.
 * 
 * @author Diego.Ferreira
 *
 */
public class ConstantesTexto {
	public static String CORPO_EMAIL_VERSAO_3_0 = inicializarValorCorpoEmailVersao3_0();
	public static String CORPO_EMAIL_VERSAO_MOBILE = inicializaValorCorpoEmailVersaoMobile();
	public static String CORPO_EMAIL_VERSAO_MANAM = inicializaValorCorpoEmailManam();
	public static String RODAPE_EMAIL = inicializarValorRodape();
	public static String REGEX_LINK_VERSAO = "%Link_Version%";
	public static String REGEX_NOME_VERSAO = "%NAME_Version%";
	
	private static String inicializarValorCorpoEmailVersao3_0() {
		StringBuilder sb = new StringBuilder();
		
		return sb.toString();
	}
	
	private static String inicializaValorCorpoEmailVersaoMobile() {
		StringBuilder sb = new StringBuilder();
		
		return sb.toString();
	}
	
	private static String inicializaValorCorpoEmailManam() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("<p>Prezados(as), </p></br>");
		sb.append("<p>Foi liberado hoje uma Versão MANAM (");
		sb.append(ConstantesTexto.REGEX_NOME_VERSAO);
		sb.append(") ,contemplando as seguintes Rm(s)" );
		sb.append("que se encontram no release notes em anexo: ");
		sb.append("Para isso, é necessário baixar a nova versão, ");
		sb.append("que pode ser obtida através do link:</br>");
		sb.append("Versão ");
		sb.append(ConstantesTexto.REGEX_LINK_VERSAO);
		sb.append("</br></p>");
		
		return sb.toString();
	}
	
	private static String inicializarValorRodape() {
		StringBuilder sb = new StringBuilder();
		sb.append("<p>");
		sb.append("Lembrem-se de acessar nossa base de conhecimento de propostas para acompanhar, ");
		sb.append("em tempo de desenvolvimento, ");
		sb.append("o levantamento de requisitos de suas solicitações. Basta acessar o endereço a seguir: ");
		sb.append("<a href=\"http://www.gsan.com.br/doku.php?id=postgres:propostas\">");
		sb.append("http://www.gsan.com.br/doku.php?id=postgres:propostas</a>");
		sb.append("</p>");

		return sb.toString();
	}
}
