/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlUsuario;

/**
 *
 * @author Clara
 */
public enum EstadoSesion {
    NO_LOGIN,           // nunca intentó iniciar sesión
    LOGIN_CORRECTO,     // tiene la sesión iniciada
    LOGIN_INCORRECTO,    // le erro a la sesión al menos una vez
    LOGIN_INVITADO
}

