package br.com.dantonio.textoEmail.templateTexto;

/**
 * Classe que guarda o texto formatado das vers&otilde;es.
 * 
 * @author Diego.Ferreira
 *
 */
public class ConstantesTexto {
	public static String CORPO_EMAIL_VERSAO_3_0 = inicializarValorCorpoEmailVersao3_0();
	public static String CORPO_EMAIL_VERSAO_MUNICIPAL = inicializarValorCorpoEmailVersaoMunicipal();
	public static String CORPO_EMAIL_VERSAO_MOBILE = inicializaValorCorpoEmailVersaoMobile();
	public static String CORPO_EMAIL_VERSAO_MANAM = inicializaValorCorpoEmailManam();
	public static String RODAPE_EMAIL = inicializarValorRodape();
	public static String AVISO_SCRIPTS = inicializarAvisoScripts();
	public static String AVISO_VERSAO_CASADA = inicializarAvisoVersaoCasada();
	public static String AVISO_EMERGENCIAL = "EMERGENCIAL: ";
	public static String REGEX_LINK_VERSAO = "%Link_Version%";
	public static String REGEX_NOME_VERSAO = "%NAME_Version%";
	public static String REGEX_SCRIPT_VERSAO = "%Link_Script_Version%";
	public static String REGEX_NOME_PRODUTO_MOBILE = "%Name_Product_Mobile%";
	
	private static String inicializarValorCorpoEmailVersao3_0() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("<p> Prezados(as), </p></br>");
		sb.append("<p>Foi liberado hoje uma Versão GSAN  ");
		sb.append("(" + gerarRegexNomeVersao() + ") ");
		sb.append("para a base Postgres.");
		sb.append("A versão pode ser obtida através do Link:</p></br> ");
		sb.append("<p><a href=\"");
		sb.append(gerarRegexLinkVersao());
		sb.append("\"> ");
		sb.append(" Versão ");
		sb.append(gerarRegexNomeVersao());
		sb.append("</a></p></br><p>O arquivo único deve ser utilizado para os ");
		sb.append("servidores <b><font color=\"red\">BATCH e ONLINE</font>.</b></p></br>");

		return sb.toString();
	}
	
	private static String inicializaValorCorpoEmailVersaoMobile() {
		StringBuilder sb = new StringBuilder();
		sb.append("<p>Foi liberado hoje uma versão ");
		sb.append(gerarRegexNomeProdutoMobile());
		sb.append(" ");
		sb.append(gerarRegexNomeVersao());
		sb.append(". Segue o link da versão ");
		sb.append("(APK) em conjunto com o documento Release Notes ");
		sb.append("que representa todas as alterações atendidas nessa versão. ");
		sb.append("</p> ");
		sb.append("<br/><p> ");
		sb.append(gerarRegexLinkVersao());
		sb.append("</p>");
		
		
		return sb.toString();
	}
	
	private static String inicializaValorCorpoEmailManam() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("<p>Prezados(as), </p></br>");
		sb.append("<p>Foi liberado hoje uma Versão MANAM (");
		sb.append(gerarRegexNomeVersao());
		sb.append(") ,contemplando as seguintes Rm(s)" );
		sb.append("que se encontram no release notes em anexo:</p> ");
		sb.append("<p>Para isso, é necessário baixar a nova versão, ");
		sb.append("que pode ser obtida através do link:</p></br>");
		sb.append("<p><a href=\" >");
		sb.append(gerarRegexLinkVersao());
		sb.append("\"> ");
		sb.append("Versão ");
		sb.append(gerarRegexNomeVersao());
		sb.append("</a>");
		sb.append("</p></br>");
		
		return sb.toString();
	}
	
	private static String inicializarValorRodape() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Lembrem-se de acessar nossa base de conhecimento de propostas para acompanhar, ");
		sb.append("em tempo de desenvolvimento, ");
		sb.append("o levantamento de requisitos de suas solicitações. Basta acessar o endereço a seguir: ");
		sb.append("<a href=\"http://www.gsan.com.br/doku.php?id=postgres:propostas\">");
		sb.append("http://www.gsan.com.br/doku.php?id=postgres:propostas</a>");
		sb.append("</p>");

		return sb.toString();
	}
	
	private static String inicializarAvisoScripts(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("<b><p><font color=\"red\">Atenção</font>: Esta versão possui dependência ");
		sb.append("de Script para o correto funcionamento. ");
		sb.append(" Ele deve ser rodado <font color=\"red\">CASADO</font> com a versão,  ");
		sb.append("já que algumas alterações necessitam de colunas existentes no Script, ");
		sb.append("ocasionando erro em caso do procedimento não ser feito. ");
		sb.append("Seguem os links:");
		sb.append("</p></b>");
		sb.append("<p>");
		sb.append("<a href=\"");
		sb.append(gerarRegexScriptsVersao());
		sb.append(" \"> ");
		sb.append("Scripts Versão ");
		sb.append(gerarRegexNomeVersao());
		sb.append("</a>");
		sb.append("</p>");
		
		return sb.toString();
	}
	
	private static String inicializarAvisoVersaoCasada() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("</br><b><p><font color=\"red\">Atenção</font>:");
		sb.append(" Em anexo estão as apk(s) do ");
		sb.append(gerarRegexNomeProdutoMobile());
		sb.append(" que deve ser disponibilizada ");
		sb.append("<font color=\"red\">CASADA</font>");
		sb.append(" com a versão do GSAN ");
		sb.append("ocasionando erro em caso do procedimento não ser feito. ");
		sb.append("</p></b> </br>");
		return sb.toString();
	}
	
	private static String inicializarValorCorpoEmailVersaoMunicipal() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("<p> Prezados(as), </p></br>");
		sb.append("<p>Foi liberado hoje uma Versão  ");
		sb.append("(" + gerarRegexNomeVersao() + ") ");
		sb.append("para a versão Municipal do GSAN.");
		sb.append("A versão pode ser obtida através do Link:</p></br> ");
		sb.append("<p><a href=\"");
		sb.append(gerarRegexLinkVersao());
		sb.append("\"> ");
		sb.append(" Versão ");
		sb.append(gerarRegexNomeVersao());
		sb.append("</a></p></br><p>O arquivo único deve ser utilizado para os ");
		sb.append("servidores <b><font color=\"red\">BATCH e ONLINE</font>.</b></p></br>");
		
		return sb.toString();
	}
	
	private static String gerarRegexNomeVersao() {
		return "%NAME_Version%";
	}
	
	private static String gerarRegexScriptsVersao() {
		return "%Link_Script_Version%";
	}
	
	private static String gerarRegexLinkVersao() {
			return "%Link_Version%";
	}
	
	private static String gerarRegexNomeProdutoMobile() {
		return "%Name_Product_Mobile%";
	}
}
