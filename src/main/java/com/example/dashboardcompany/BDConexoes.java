package com.example.dashboardcompany;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConexoes {

    public Connection solicitaConexao(String host, String banco, String usuario, String senha) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver nao encontrato. " + e.toString());
            System.exit(1);
        }

        try {
            return DriverManager.getConnection("jdbc:mysql://" + host + "/" + banco, usuario, senha);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro com o banco de dados. \n" + e.toString());
            System.exit(1);
            return null;
        }
    }
}
