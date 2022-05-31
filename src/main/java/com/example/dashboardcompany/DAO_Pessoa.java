package com.example.dashboardcompany;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO_Pessoa {
	private final Connection conexao;

	public DAO_Pessoa(){
		conexao = new BDConexoes().solicitaConexao("localhost", "teste", "root", "");
	}

	public void insere(Pessoa p){

		String sql = "insert into pessoa " +
				"(nome, cargo, digital, url, entrada, saida) " +
				"values (?,?,?,?,?,?)";

		try{
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1,p.getNome());
			stmt.setString(2,p.getCargo());
			stmt.setString(3,p.getDigital());
			stmt.setString(4,p.getUrl());
			stmt.setString(5,p.getEntrada());
			stmt.setString(6,p.getSaida());


			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Pessoa busca(String f){

		Pessoa p = new Pessoa();

		try{
//			String sql = "select * from pessoa where digital like ?";
			String sql = "select * from pessoa where digital=?";

			PreparedStatement stmt = conexao.prepareStatement(sql);
//			stmt.setString(1,"%" + f + "%");
			stmt.setString(1,f);

			ResultSet rs = stmt.executeQuery();

			p.setNome("Nao Encontrado!");

			while(rs.next()){
				if(rs.getString("digital").contains(f)){
					p.setNome(rs.getString("nome"));
					p.setCargo(rs.getString("cargo"));
					p.setDigital(rs.getString("digital"));
					p.setUrl(rs.getString("url"));
					p.setEntrada(rs.getString("entrada"));
					p.setSaida(rs.getString("saida"));
				}
			}

			rs.close();
			stmt.close();
			return p;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Pessoa p){

		String sql = "update pessoa set " +
				"nome=?, cargo=?, digital=?, url=?, entrada=?, saida=? " +
				"where digital=?";

		try{
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1,p.getNome());
			stmt.setString(2,p.getCargo());
			stmt.setString(3,p.getDigital());
			stmt.setString(4,p.getUrl());
			stmt.setString(5,p.getEntrada());
			stmt.setString(6,p.getSaida());
			stmt.setString(7,p.getDigital());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public void apaga(String d){

		String sql = "delete from pessoa " +
				"where digital=?";

		try{
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1,d);

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

//	public List<Pessoa> lista(){
//
//		try{
//			List<Pessoa> pessoas = new ArrayList<Pessoa>();
//			PreparedStatement stmt = conexao.prepareStatement("select * from pessoa");
//			ResultSet rs = stmt.executeQuery();
//
//			while(rs.next()){
//				Pessoa p = new Pessoa();
//				p.setNome(rs.getString("nome"));
//				p.setCargo(rs.getString("cargo"));
//				p.setDigital(rs.getString("digital"));
//
//				pessoas.add(p);
//			}
//
//			rs.close();
//			stmt.close();
//			return pessoas;
//
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}

}

