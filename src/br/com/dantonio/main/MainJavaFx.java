package br.com.dantonio.main;

import br.com.dantonio.gui.FramePrincipalJfx;
import br.com.dantonio.textoEmail.baseClasses.Email;
import br.com.dantonio.textoEmail.baseClasses.EmailVersao3_0;
import br.com.dantonio.textoEmail.decorators.EmailDecorator;
import br.com.dantonio.textoEmail.decorators.Emergencial;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainJavaFx extends Application {

	public static void main(String[] args) {
		//launch(args);
		//System.out.println(testeEmailVersao3_0());
		System.out.println(testeEmailVersao3_0Emergencial());
//		System.out.println(testeEmailVersao3_0ComScripts());
//		System.out.println(testeEmailVersaoManam());
//		System.out.println(testeEmailVersaoMobile());
		
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
		String linkVersao;
		String nomeVersao;
		String produto;
		String linkScripts;
		
		
		return null;
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
		String linkVersao;
		String nomeVersao;
		String produto;
		String linkScripts;
		
		
		return null;
	}
	
	private static String testeEmailVersaoMobile() {
		String linkVersao;
		String nomeVersao;
		String produto;
		String linkScripts;
		return null;
	}
}
