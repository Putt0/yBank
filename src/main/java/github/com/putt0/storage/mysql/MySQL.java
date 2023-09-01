package github.com.putt0.storage.mysql;

import github.com.putt0.account.User;
import github.com.putt0.storage.Database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {

    public static Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public boolean hasConnection() {
        return getConnection() != null;
    }

    public void loadMySQL() {
        if (!hasConnection()) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://" + Database.MYSQL.getAddress() + ":"
                        + Database.MYSQL.getPort() + "/" + Database.MYSQL.getDatabase() + "?autoReconnect=true"
                        , Database.MYSQL.getUsername(), Database.MYSQL.getPassword());
            } catch (SQLException sqlException) {
                System.err.print("-> Ocorreu um erro ao inicializar a conexão com a base de dados!");
                JOptionPane.showMessageDialog(null, sqlException.getMessage());
            }

            /*
            Ao iniciar, caso não tenha a tabela; Elas inicializarão automaticamente!
             */

            try {
                PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS User " +
                        "(Name VARCHAR(100), Password VARCHAR(100), Cash INT(100))");
                preparedStatement.execute();
            } catch (SQLException sqlException) {
                System.err.print("-> Ocorreu um erro ao gerar a tabela: [User] ");
                JOptionPane.showMessageDialog(null, sqlException.getMessage());
            }
        }
    }
    
    public ResultSet hasUser(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from User where name= ? and password= ?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, sQLException);
            return null;
        }
    }
}