package com.example.dashboardcompany;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO_Pessoa {
	private Connection conexao;

	public DAO_Pessoa(){
		conexao = new FabricaDeConexoes().solicitaConexao("localhost", "teste", "root", "");
	}

	public void insere(Pessoa p){

		String sql = "insert into pessoa " +
				"(nome, endereco, fone, url) " +
				"values (?,?,?)";

		try{
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1,p.getNome());
			stmt.setString(2,p.getEndereco());
			stmt.setString(3,p.getFone());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Pessoa busca(String n){

		Pessoa p = new Pessoa();

		try{
			String sql = "select * from pessoa where nome like ?";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1,"%" + n + "%");

			ResultSet rs = stmt.executeQuery();

			p.setNome("Nao Encontrado!");

			while(rs.next()){
				//if(rs.getString("nome").equals(n)){
				if(rs.getString("nome").contains(n)){
					p.setNome(rs.getString("nome"));
					p.setEndereco(rs.getString("endereco"));
					p.setFone(rs.getString("fone"));
					p.setUrl(rs.getString("url"));
				}
			}

			rs.close();
			stmt.close();
			return p;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

//	public void altera(Pessoa p){
//
//		String sql = "update pessoa set " +
//				"nome=?, endereco=?, fone=? " +
//				"where nome=?";
//
//		try{
//			PreparedStatement stmt = conexao.prepareStatement(sql);
//			stmt.setString(1,p.getNome());
//			stmt.setString(2,p.getEndereco());
//			stmt.setString(3,p.getFone());
//			stmt.setString(4,p.getNome());
//
//			stmt.execute();
//			stmt.close();
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}

//
//	public void apaga(String n){
//
//		String sql = "delete from pessoa " +
//				"where nome=?";
//
//		try{
//			PreparedStatement stmt = conexao.prepareStatement(sql);
//			stmt.setString(1,n);
//
//			stmt.execute();
//			stmt.close();
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
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
//				p.setEndereco(rs.getString("endereco"));
//				p.setFone(rs.getString("fone"));
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

