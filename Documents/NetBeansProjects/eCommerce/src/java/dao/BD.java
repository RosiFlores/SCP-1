
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mayara Amanda
 */
public class BD {

    public static Connection getConexao()
            throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Class.forName("com.mysql.jdbc.Driver");
        // alterar o nome do banco!!
        conexao = DriverManager.getConnection("jdbc:mysql://localhost/ecommerce", "usuario", "123");
        return conexao;

    }

}
