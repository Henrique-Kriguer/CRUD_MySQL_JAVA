package com.kriguer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    // Construtor declarado como privado para evitar instancias de fabrica;

    private ConnectionFactory() {
        throw new UnsupportedOperationException();
    }

    public static Connection getConnection() throws IOException {
        // 1-  Declarar objeto conexão (irá receber uma conecção após executar os passoa abaixo:

        Connection connection = null;

        //2 - Carregar arquivos de propriedades para pegar parâmetros necessários para se comunicar c/ BD

        try (InputStream input = ConnectionFactory.class.getClassLoader()
                .getResourceAsStream("connection.properties")) {

            //3 - Definir parâmetros p/ se conectar ao BD.

            Properties prop = new Properties();
            prop.load(input);

            String driver = prop.getProperty("jdbc.driver");
            String dataBaseAdress = prop.getProperty("db.address");
            String dataBaseName = prop.getProperty("db.dataBaseName");
            String user = prop.getProperty("db.user");
            String password = prop.getProperty("db.password");


            // 4. Construção da String de connecção:

            StringBuilder sb = new StringBuilder("jdbc:")
                    .append(driver).append("://")
                    .append(dataBaseAdress).append("/")
                    .append(dataBaseName);

            String connectionUrl = sb.toString();

            // 5 - Criar a conexão usando o DriverMannager:

            try {
                connection = DriverManager.getConnection(connectionUrl, user, password);
            } catch (SQLException e) {
                System.out.println("Falha ao tentar efecutar conexão");
                throw new RuntimeException(e);
            }


        } catch (IOException e) {
            System.out.println("Falha ao tentar carregar arquivos de propriedade");
            e.printStackTrace();
        }

        return connection;
    }

}
