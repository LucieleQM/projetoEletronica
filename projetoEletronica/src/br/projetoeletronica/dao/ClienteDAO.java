package br.projetoeletronica.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.projetoeletronica.model.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, String>{
	@Override
	public List<Cliente> obterTodos() {
		List<Cliente> lista = new ArrayList<>();
		try {
			ResultSet r1 = getStatment().executeQuery("SELECT * FROM cliente");
			while(r1.next())
				lista.add(new Cliente(r1.getString("NOME"), r1.getString("CPF"), r1.getString("ENDERECO"),
						r1.getString("TELEFONE"), r1.getString("EMAIL"), r1.getLong("ID")));
			closeStatement(r1.getStatement());
		} catch (Exception e) {
			return null;
		}
		return lista;
	}
	
	@Override
	public Cliente obter(String chave) {
		Cliente cliente = null;
		try {
			PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM cliente WHERE CPF = ?");
			ps .setString(1, chave);
			ResultSet r1 = ps.executeQuery();
			if (r1.next())
				cliente = new Cliente(r1.getString("NOME"), r1.getString("CPF"), r1.getString("ENDERECO"),
						r1.getString("TELEFONE"), r1.getString("EMAIL"), r1.getLong("ID"));
			closeStatement(ps);
		} catch (Exception e) {
			
		}
		return cliente;
	}
	
	
	@Override
	public void inserir(Cliente cliente) throws Exception {
		PreparedStatement ps = null;
		String sql= "INSERT INTO cliente(nome, cpf, endereco, telefone, email)" + 
					" VALUES (?,?,?,?,?)";
		try {
			ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getEndereco());
			ps.setString(4, cliente.getTelefone());
			ps.setString(5, cliente.getEmail());
			
			int affectedRows = ps.executeUpdate();
		//	ps.executeUpdate();
			closeStatement(ps);
			
			 if (affectedRows == 0) {
		            throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
		        }
		        ResultSet generatedKeys = ps.getGeneratedKeys();
		        if (generatedKeys.next()) {
		            cliente.setId(generatedKeys.getLong(6));
		        }
		        else {
		           throw new SQLException("A inserção falhou. Nenhum id foi retornado.");
		        }
		        
			} catch (SQLException e) {
				System.out.println("Não foi possível inserir o cliente! Erro: " + e.getMessage());
				e.printStackTrace();
			}
	}
	
	@Override
	public void excluir(String chave) {
		try {
			PreparedStatement ps = getConnection(). prepareStatement("DELETE FROM cliente WHERE CPF = ?");
			
			ps.setString(1, chave);
			ps.executeUpdate();
			closeStatement(ps);
		} catch (Exception e){
			
		}
		
	}
	
	
	@Override
	public void alterar(Cliente cliente) {
		try {
			PreparedStatement ps = getConnection().prepareStatement("UPDATE FROM cliente SET NOME = ?, ENDERECO = ?, TELEFONE = ?, EMAIL = ?"
					+ "WHERE CPF = ?");
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEndereco());
			ps.setString(3, cliente.getTelefone());
			ps.setString(4, cliente.getEmail());
			ps.executeUpdate();
			closeStatement(ps);
		} catch (Exception e) {
			
		}
		
	}
}
