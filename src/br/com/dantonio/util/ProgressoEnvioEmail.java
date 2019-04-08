package br.com.dantonio.util;

import javafx.scene.control.ProgressBar;

public class ProgressoEnvioEmail {
	private ProgressBar barraProgresso;
	private static ProgressoEnvioEmail envioEmailProgresso;
	
	private ProgressoEnvioEmail() {
		super();
		this.barraProgresso = new ProgressBar();
		this.barraProgresso.setProgress(0);
	}
	
	public static ProgressoEnvioEmail getInstance() {
		if(envioEmailProgresso == null) {
			envioEmailProgresso = new ProgressoEnvioEmail();
		}
		
		return envioEmailProgresso;
	}

	public ProgressBar getBarraProgresso() {
		return barraProgresso;
	}

	public void setBarraProgresso(ProgressBar barraProgresso) {
		this.barraProgresso = barraProgresso;
	}
	
	public void incrementarProgresso(Double valorPercentual) {
		this.barraProgresso.setProgress(valorPercentual);
	}
}
