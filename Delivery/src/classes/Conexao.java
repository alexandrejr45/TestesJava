package classes;

import java.sql.Connection;
// conexão SQL para Java
import java.sql.DriverManager;
// driver de conexão SQL para Java
import java.sql.SQLException;

import com.mysql.jdbc.Driver;


// classe para tratamento de exceções
public class Conexao {
    public Connection getConnection() throws SQLException{
	try {
           Class.forName("com.mysql.jdbc.Driver");



        }
        catch(ClassNotFoundException ex) {


        }

        return DriverManager.getConnection("jdbc:mysql://localhost/delivery", "root","");
    }
}
