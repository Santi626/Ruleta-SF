/*
 * Clase Usuario con la plantilla de datos de usuario de BBDD
 */
package Clases;

import java.util.Date;

/**
 *
 * @author santi
 */
public class Usuario {
    
    private int id;
    private String nombre;
    private Date fechaNacimiento;
    private String correo;
    private Date fechaCreacion;
    private Date fechaUltimaConexion;
    private int FichasIniciales;
    private int fichasFinales;
    private String password;

    public Usuario() {
    }

    public Usuario(int id, String nombre, Date fechaNacimiento, String correo, Date fechaCreacion, Date fechaUltimaConexion, int fichasFinales, String password) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltimaConexion = fechaUltimaConexion;
        this.fichasFinales = fichasFinales;
        this.FichasIniciales = fichasFinales;
        this.password = password;
    }

    public Usuario(String nombre, String correo, String password) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    public Usuario(int id, String nombre, Date fechaUltimaConexion, int totalFichas) {
        this.id = id;
        this.nombre = nombre;
        this.fechaUltimaConexion = fechaUltimaConexion;
        this.fichasFinales = totalFichas;
        this.FichasIniciales = totalFichas;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @return the fechaUltimaConexion
     */
    public Date getFechaUltimaConexion() {
        return fechaUltimaConexion;
    }

    /**
     * @param fechaUltimaConexion the fechaUltimaConexion to set
     */
    public void setFechaUltimaConexion(Date fechaUltimaConexion) {
        this.fechaUltimaConexion = fechaUltimaConexion;
    }

    /**
     * @return the totalFichas
     */
    public int getFichasFinales() {
        return fichasFinales;
    }

    /**
     * @param totalFichas the totalFichas to set
     */
    public void setFichasFinales(int totalFichas) {
        this.fichasFinales = totalFichas;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the FichasIniciales
     */
    public int getFichasIniciales() {
        return FichasIniciales;
    }

    /**
     * @param FichasIniciales the FichasIniciales to set
     */
    public void setFichasIniciales(int FichasIniciales) {
        this.FichasIniciales = FichasIniciales;
    }
    
    
    
}
