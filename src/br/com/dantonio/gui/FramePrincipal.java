package br.com.dantonio.gui;

import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FramePrincipal extends Frame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FramePrincipal() throws HeadlessException {
		super();
		this.iniciarComponentes();
	}

	public FramePrincipal(GraphicsConfiguration gc) {
		super(gc);
		this.iniciarComponentes();
	}

	public FramePrincipal(String title, GraphicsConfiguration gc) {
		super(title, gc);
		this.iniciarComponentes();
	}

	public FramePrincipal(String title) throws HeadlessException {
		super(title);
		this.iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		this.setSize(800, 600);
		Label teste = new Label("Teste", Label.LEFT);
		TextField campoTexto = new TextField(5);
		this.add(teste);
		this.add(campoTexto);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
