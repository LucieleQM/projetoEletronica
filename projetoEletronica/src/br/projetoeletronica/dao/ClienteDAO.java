package br.projetoeletronica.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.projetoeletronica.model.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, String>{
	
	@Override
	public void inserir(Cliente cliente) throws Exception {
		PreparedStatement ps = null;
		String sql= "INSERT INTO clientes(cpf, nome, endereco, telefone, email)" + 
					" VALUES (?,?,?,?,?)";
		try {
			ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, cliente.getCpf());
			ps.setString(2, cliente.getNome());
			ps.setString(3, cliente.getEndereco());
			ps.setString(4, cliente.getTelefone());
			ps.setString(5, cliente.getEmail());
			
			int affectedRows = ps.executeUpdate();
			closeStatement(ps);
			
			 if (affectedRows == 0) {
		            throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
		        }
		        ResultSet generatedKeys = ps.getGeneratedKeys();
		        if (generatedKeys.next()) {
		            cliente.setId(generatedKeys.getLong(1));
		            System.out.println("\nid gerado: " + generatedKeys.getLong(1));
		        }
		        else {
		           throw new SQLException("A inserção falhou. Nenhum id foi retornado.");
		        }
		        
			} catch (SQLException e) {
				System.out.println("Não foi possível inserir o cliente!\nErro: " + e.getMessage());
				e.printStackTrace();
			}
	}
	
	@Override
	public void excluir(String chave) {
		try {
			PreparedStatement ps = getConnection(). prepareStatement("DELETE FROM clientes WHERE CPF = ?");
			
			ps.setString(1, chave);
			ps.executeUpdate();
			closeStatement(ps);
		} catch (Exception e){
			System.out.println("Não foi possível excluir o cliente!\nErro: " + e.getMessage());
		}
		
	}
	
	
	@Override
	public void alterar(Cliente cliente) {
		try {
			PreparedStatement ps = getConnection().prepareStatement("UPDATE FROM clientes SET NOME = ?, ENDERECO = ?, TELEFONE = ?, EMAIL = ?"
					+ "WHERE CPF = ?");
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEndereco());
			ps.setString(3, cliente.getTelefone());
			ps.setString(4, cliente.getEmail());
			ps.executeUpdate();
			closeStatement(ps);
		} catch (Exception e) {
			System.out.println("Não foi possível alterar o cliente! " + e.getMessage());
		}
		
	}
	
	@Override
	public List<Cliente> obterTodos() {
		List<Cliente> lista = new ArrayList<>();
		try {
			ResultSet r1 = getStatment().executeQuery("SELECT * FROM clientes");
			while(r1.next())
				lista.add(new Cliente(r1.getLong("ID"), 
						r1.getString("NOME"), 
						r1.getString("CPF"), 
						r1.getString("ENDERECO"),
						r1.getString("TELEFONE"), 
						r1.getString("EMAIL"),
						null));
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
			PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM clientes WHERE CPF = ?");
			ps .setString(1, chave);
			ResultSet r1 = ps.executeQuery();
			if (r1.next())
				cliente = new Cliente(r1.getLong("ID"), 
						r1.getString("CPF"), 
						r1.getString("NOME"), 
						r1.getString("ENDERECO"),
						r1.getString("TELEFONE"), 
						r1.getString("EMAIL"), null);
			closeStatement(ps);
		} catch (Exception e) {
			
		}
		return cliente;
	}

}
