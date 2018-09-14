package br.com.dantonio.main;

import br.com.dantonio.constantesSistema.ProdutosMobile;
import br.com.dantonio.email.EmailsClientes;
import br.com.dantonio.gui.FramePrincipalJfx;
import br.com.dantonio.textoEmail.baseClasses.Email;
import br.com.dantonio.textoEmail.baseClasses.EmailVersao3_0;
import br.com.dantonio.textoEmail.baseClasses.EmailVersaoManam;
import br.com.dantonio.textoEmail.baseClasses.EmailVersaoMobile;
import br.com.dantonio.textoEmail.decorators.EmailDecorator;
import br.com.dantonio.textoEmail.decorators.Emergencial;
import br.com.dantonio.textoEmail.decorators.Scripts;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainJavaFx extends Application {

	public static void main(String[] args) {
		//launch(args);
		//System.out.println(testeEmailVersao3_0());
		//System.out.println(testeEmailVersao3_0Emergencial());
		//System.out.println(testeEmailVersao3_0ComScripts());
		//System.out.println(testeEmailVersaoManam());
		//System.out.println(testeEmailVersaoManamComScripts());
		System.out.println(testeEmailVersaoMobile());
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FramePrincipalJfx framePrincipalJfx = new FramePrincipalJfx(primaryStage);
		framePrincipalJfx.iniciarAplicacao();
	}

	
	private static String testeEmailVersao3_0() {
		String linkVersao = "http://ftp.consensotec.com.br/ear/2018/Consenso/9-Setembro/Versao-3.33.0.2-13-09-2018/gsan_v3.33.0.2.rar";
		String nomeVersao = "3.33.0.2";
		String produto = "GSAN";
		StringBuilder emailFinal = new StringBuilder();
		
		Email email = new EmailVersao3_0(nomeVersao, linkVersao, produto, "");
		
		for (String temp : email.gerarEmailVersao()) {
			emailFinal.append(temp.toString() + " <br/>");
		}
		
		return emailFinal.toString();
	}
	
	private static String testeEmailVersao3_0ComScripts() {
		String linkVersao = "http://ftp.consensotec.com.br/ear/2018/Consenso/9-Setembro/Versao-3.33.0.2-13-09-2018/gsan_v3.33.0.2.rar";;
		String nomeVersao = "3.33.0.2";
		String produto = "GSAN";
		String linkScripts = "http://ftp.consensotec.com.br/banco/postgres/versao_db_comercial_20180910.rar";
		Email email;
		EmailDecorator decorator;
		StringBuilder emailFinal = new StringBuilder();
		
		email = new EmailVersao3_0(nomeVersao, linkVersao, produto, linkScripts);
		decorator = new Scripts(email);
		
		for (String temp : decorator.gerarEmailVersao()) {
			emailFinal.append(temp.toString() + " <br/>");
		}
		
		return emailFinal.toString();
	}
	
	private static String testeEmailVersao3_0Emergencial() {
		String linkVersao = "http://ftp.consensotec.com.br/ear/2018/Consenso/9-Setembro/Versao-3.33.0.2-13-09-2018/gsan_v3.33.0.2.rar";
		String nomeVersao = "3.33.0.2";
		String produto = "GSAN";
		StringBuilder emailFinal = new StringBuilder();
		
		Email email = new EmailVersao3_0(nomeVersao, linkVersao, produto, "");
		EmailDecorator decorator = new Emergencial(email);
		
		for (String temp : decorator.gerarEmailVersao()) {
			emailFinal.append(temp.toString() + " <br/>");
		}
		
		return emailFinal.toString();
	}
	
	
	private static String testeEmailVersaoManam() {
		String linkVersao = "http://ftp.consensotec.com.br/ear/2018/Consenso/9-Setembro/Versao-3.33.0.2-13-09-2018/gsan_v3.33.0.2.rar";
		String nomeVersao = "2.10r87m.48";
		String produto = "MANAM";
		StringBuilder emailFinal = new StringBuilder();
		Email email;
		
		email = new EmailVersaoManam(nomeVersao,linkVersao,produto,"");
		
		
		for (String temp : email.gerarEmailVersao()) {
			emailFinal.append(temp.toString() + " <br/>");
		}
		
		return emailFinal.toString();
	}
	
	private static String testeEmailVersaoManamComScripts() {
		String linkVersao = "http://ftp.consensotec.com.br/ear/2018/Consenso/9-Setembro/Versao-3.33.0.2-13-09-2018/gsan_v3.33.0.2.rar";
		String nomeVersao = "2.10r87m.48";
		String produto = "MANAM";
		String linkScripts = "http://ftp.consensotec.com.br/banco/postgres/versao_db_comercial_20180910.rar";
		StringBuilder emailFinal = new StringBuilder();
		Email email;
		EmailDecorator decorator;
		
		email = new EmailVersaoManam(nomeVersao,linkVersao,produto,linkScripts);
		decorator = new Scripts(email);
		
		
		for (String temp : decorator.gerarEmailVersao()) {
			emailFinal.append(temp.toString() + " <br/>");
		}
		
		return emailFinal.toString();
	}
	
	private static String testeEmailVersaoMobile() {
		StringBuilder emailFinal = new StringBuilder();
		String linkVersao = "";
		String nomeVersao = "6.2.09.3";
		String produto = ProdutosMobile.ISC.getNomeAppAbreviado();
		String linkScripts = "";
		String empresa = EmailsClientes.CAERN.getNomeEmpresa();
		Email email;
		
		email = new EmailVersaoMobile(nomeVersao, linkVersao, produto, linkScripts, empresa,
				ProdutosMobile.ISC.getId());
		
		for (String temp : email.gerarEmailVersao()) {
			emailFinal.append(temp.toString() + " <br/>\n");
		}
		
		return emailFinal.toString();
	}
}
