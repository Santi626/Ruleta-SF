/*
CLASE: BASE DE DATOS
 */
package BaseDatos;

//import gestores.*;
import Clases.ErrorException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;

/**
 *
 * @author Alumno
 */
public class DataBase {

    private static String bd;
    private static String login;
    private static String password;
    private static String servidorMysql;
    private static Connection conexion;

    public static boolean setConexion(String bd1, String login1,
            String password1, String servidorMysql1) throws ErrorException {

        //Primero inicializa los datos
        setBd(bd1);
        setLogin(login1);
        setPassword(password1);
        setServidorMysql(servidorMysql1);

        //Se conecta al servidor proporcionado 
        //Si no existe la base de datos la crea y se conecta
        try {
            // Carga el driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            setConexion(DriverManager.getConnection(getServidorMysql() + getBd(), getLogin(), getPassword()));
            return true;
        } catch (ClassNotFoundException ex) {
            throw new ErrorException("Problemas con la conexión " + ex.getMessage());
        } catch (SQLException ex) {
            //NO SE PUEDE CONECTAR A LA BASE DE DATOS QUE NO EXISTE/ESTA CERRADA/PASSWORD INCORRECTO...

//            //Si el error (ex.getErrorCode()) es el --> 1049
//            //Conectarse al servidor
//            int codError = ex.getErrorCode();
//            if (codError == 1049) {
//                /*
//                Llamar a un metodo que haga:
//                    1.-Conectarse al servidor
//                        conexion = DriverManager.getConnection(servidorMysql, login, password);
//                    2.- a traves de ejecutaUpdate --> CREATE DATABASE ......
//                    3.- Dos opciones: 
//                        3.1.-CREATE *NOMBREDATABASE*.tabla ......
//                        3.2.-cerrar conexión, abrir conexion con la Base de Datos
//                                Crear tablas
//                    4.-Tendreis que tener una conexion al Servidor y a la Base de Datos
//                 */
//
//                creaDataBase();
//                return true;
//            } else {
//                throw new ErrorException("Problemas con la conexión " + ex.getMessage());
//            }
            throw new ErrorException("Problemas con la conexión " + ex.getMessage());
        }
    }

    private static boolean creaDataBase() throws ErrorException {
        //Se conecta al servidor y crea la Base de Datos
        try {
            //Conecta al servidor
            setConexion(DriverManager.getConnection(getServidorMysql(), getLogin(), getPassword()));

            PreparedStatement ps = null;

            //Crea la base de datos
            ps = getConexion().prepareStatement("CREATE DATABASE saludeternaMySQL;");
            ejecutaUpdateSeguro(ps);

            cerrarConexion();

            //conecta a la nueva base de datos
            setConexion(DriverManager.getConnection(getServidorMysql() + getBd(), getLogin(), getPassword()));

            //Crea las tablas
            //Tabla1 = Tarifa
            ps = getConexion().prepareStatement("CREATE TABLE if not exists aseguradora "
                    + "(id_aseguradora char(8), primary key (id_aseguradora),"
                    + "nombre varchar(30) not null,"
                    + "cuenta_pago varchar(30) not null,"
                    + "telefono varchar(20) not null,"
                    + "pagina_web varchar(100));");
            ejecutaUpdateSeguro(ps);
            //Tabla2 = Factura
            ps = getConexion().prepareStatement("CREATE TABLE if not exists paciente "
                    + "(id_paciente char(8), primary key (id_paciente),"
                    + "nombre varchar(30) not null,"
                    + "apellido1 VARCHAR(30) not null,"
                    + "apellido2 VARCHAR(30),"
                    + "telefono VARCHAR(20),"
                    + "nif_dni VARCHAR(9) not null,"
                    + "id_aseguradora char(8), foreign key (id_aseguradora) references aseguradora(id_aseguradora));");
            ejecutaUpdateSeguro(ps);

            return true;
        } catch (SQLException ex) {
            throw new ErrorException("Problemas con la conexión " + ex.getMessage());
        }
    }

    public static boolean cerrarConexion() throws ErrorException {
        try {
            getConexion().close();
            return true;
        } catch (SQLException ex) {
            throw new ErrorException("Problemas al cerrar la conexion " + ex.getMessage());
        }

    }
    
    public static int ejecutaUpdateSeguro(PreparedStatement ps) throws ErrorException {
        //Ejecuta la sentencia que se le proporciona
        try {
            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException("Error sentencia: " + ex.getMessage());
        } finally {
            //Se libera la memoria
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new ErrorException("Error al cerrar la sentencia" + ex.getMessage());
                }
            }
        }
    }

    public static void ejecutaProcedimiento(CallableStatement llamada) throws ErrorException {
        //Ejecuta el procedimiento que se le proporciona
        try {
            llamada.executeUpdate();
        } catch (SQLException ex) {
            throw new ErrorException("Error sentencia: " + ex.getMessage());
        } finally {
            //Se libera la memoria
            if (llamada != null) {
                try {
                    llamada.close();
                } catch (SQLException ex) {
                    throw new ErrorException("Error al cerrar la sentencia" + ex.getMessage());
                }
            }
        }
    }

    public static ResultSet creaResultSet(String consulta) throws ErrorException {
        //Devuelve un ResultSet con la consulta proporcionada
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = getConexion().prepareStatement(consulta);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            throw new ErrorException("Problemas haciendo Select " + ex.getMessage());
        }
    }

    /**
     * @return the bd
     */
    public static String getBd() {
        return bd;
    }

    /**
     * @param aBd the bd to set
     */
    public static void setBd(String aBd) {
        bd = aBd;
    }

    /**
     * @return the login
     */
    public static String getLogin() {
        return login;
    }

    /**
     * @param aLogin the login to set
     */
    public static void setLogin(String aLogin) {
        login = aLogin;
    }

    /**
     * @return the password
     */
    public static String getPassword() {
        return password;
    }

    /**
     * @param aPassword the password to set
     */
    public static void setPassword(String aPassword) {
        password = aPassword;
    }

    /**
     * @return the servidorMysql
     */
    public static String getServidorMysql() {
        return servidorMysql;
    }

    /**
     * @param aServidorMysql the servidorMysql to set
     */
    public static void setServidorMysql(String aServidorMysql) {
        servidorMysql = aServidorMysql;
    }

    /**
     * @return the conexion
     */
    public static Connection getConexion() {
        return conexion;
    }

    /**
     * @param aConexion the conexion to set
     */
    public static void setConexion(Connection aConexion) {
        conexion = aConexion;
    }

}
