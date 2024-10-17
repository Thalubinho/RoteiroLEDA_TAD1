package org.leda.tad.fila;

import java.io.Serial;

public class FilaCheiaException extends Exception {
	
	@Serial
	private static final long serialVersionUID = 2205604804082710180L;

	public FilaCheiaException() {
		super("fila cheia");
	}

}
