/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author Clara
 */
public class UsuarioNoEncontrado extends Exception {

	/**
	 * Creates a new instance of <code>UsuarioNoEncontrado</code> without detail message.
	 */
	public UsuarioNoEncontrado() {
	}

	/**
	 * Constructs an instance of <code>UsuarioNoEncontrado</code> with the specified detail message.
	 * @param msg the detail message.
	 */
	public UsuarioNoEncontrado(String msg) {
		super(msg);
	}
}

