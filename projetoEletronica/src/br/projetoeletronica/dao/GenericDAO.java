package br.projetoeletronica.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class GenericDAO<E,K> {
	protected  Connection getConnection() throws Exception{
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost/dbeletronica", "postgres", "senha");
		} catch (SQLException e) {
			System.out.println("Problema ao abrir o banco" + e.getMessage());
			return null;
		} catch (ClassNotFoundException e) {
			System.out.println("Problema ao carregar o driver de conexão!");
			return null;
		} 
	}
	
	protected Statement getStatment() throws Exception{
		return getConnection().createStatement();
	}
	
	protected void closeStatement(Statement st) throws Exception{
		st.getConnection().close();
	}
	
	public abstract void inserir(E entidade) throws Exception;
	public abstract void excluir(K chave);
	public abstract void alterar(E entidade);
	public abstract E obter(K chave);
	public abstract List<E> obterTodos();	
}
