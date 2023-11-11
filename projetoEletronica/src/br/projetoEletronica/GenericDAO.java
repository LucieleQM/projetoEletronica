package br.projetoEletronica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

public abstract class GenericDAO<E,K> {
	protected  Connection getConnection() throws Exception{
		Class.forName("com.postgresql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:postgresql://localhost/dbeletronica", null, null);
	}
	
	protected Statement getStatment() throws Exception{
		return getConnection().createStatement();
	}
	
	protected void closeStatement(Statement st) throws Exception{
		st.getConnection().close();
	}
	
	public abstract void inserir(E entidade);
	public abstract void excluir(K chave);
	public abstract void alterar(E entidade);
	public abstract E obter(K chave);
	public abstract List<E> obterTodos();	
}
