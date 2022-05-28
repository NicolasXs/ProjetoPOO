package com.example.dashboardcompany;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {

	public Connection solicitaConexao(String host, String banco, String usuario, String senha) {

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e){
             System.out.println("Driver nao encontrato. "+e.toString());
		}

		try {
			return DriverManager.getConnection("jdbc:mysql://" + host + "/" + banco, usuario, senha);
		} catch (SQLException e) {
            System.out.println("Ocorreu um erro com o banco de dados. \n"+e.toString());
			return null;
		}
	}
}
