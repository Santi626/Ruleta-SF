/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author santi
 */
public class GestorUsuarios {
    
    private static Usuario usuarioActivo;

    /**
     * @return the usuarioActivo
     */
    public static Usuario getUsuarioActivo() {
        return usuarioActivo;
    }

    /**
     * @param aUsuarioActivo the usuarioActivo to set
     */
    public static void setUsuarioActivo(Usuario aUsuarioActivo) {
        usuarioActivo = aUsuarioActivo;
    }
    
    
}
