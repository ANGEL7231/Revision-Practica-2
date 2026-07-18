package utng.gtid2.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // Ya que configuraste el puerto 1433 manualmente en la instancia:
    private static final String URL =
        "jdbc:sqlserver://localhost:1433;" +
        "databaseName=CGTI;" +
        "encrypt=false;" + // Lo cambiamos temporalmente a false para descartar fallos de TLS local
        "trustServerCertificate=true;";

    private static final String USUARIO = "sa";
    private static final String PASSWORD = "sql123"; // Asegúrate de que sea la que pusiste en SSMS

    public static Connection conectar() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(URL, USUARIO, PASSWORD);
        } catch (SQLException e) {
            // ESTO NOS VA A DECIR EL ERROR REAL EN LA TERMINAL
            System.err.println("\n--- [ERROR CRÍTICO DE SQL SERVER] ---");
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Código de error: " + e.getErrorCode());
            System.err.println("Estado SQL: " + e.getSQLState());
            System.err.println("-------------------------------------\n");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}