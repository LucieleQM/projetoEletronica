package br.projetoeletronica.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.projetoeletronica.model.Tecnico;

public class TecnicoDAO extends GenericDAO<Tecnico, Long>{

	@Override
	public void inserir(Tecnico entidade) throws Exception {
		PreparedStatement ps = null;
		String sql= "INSERT INTO tecnicos(cpf, nome, endereco, telefone, email)" + 
					" VALUES (?,?,?,?,?)";
		try {
			ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, entidade.getCpf());
			ps.setString(2, entidade.getNome());
			ps.setString(3, entidade.getEndereco());
			ps.setString(4, entidade.getTelefone());
			ps.setString(5, entidade.getEmail());
			
			int affectedRows = ps.executeUpdate();
			closeStatement(ps);
			
			 if (affectedRows == 0) {
		            throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
		        }
		        ResultSet generatedKeys = ps.getGeneratedKeys();
		        if (generatedKeys.next()) {
		        	entidade.setId(generatedKeys.getLong(1));
		            System.out.println("\nid gerado: " + generatedKeys.getLong(1));
		        }
		        else {
		           throw new SQLException("A inserção falhou. Nenhum id foi retornado.");
		        }
		        
			} catch (SQLException e) {
				System.out.println("Não foi possível inserir o técnico!\nErro: " + e.getMessage());
				e.printStackTrace();
			}
		
	}

	@Override
	public void excluir(Long chave) {
		try {
			PreparedStatement ps = getConnection(). prepareStatement("DELETE FROM tecnicos WHERE ID = ?");
			
			ps.setLong(1, chave);
			ps.executeUpdate();
			closeStatement(ps);
		} catch (Exception e){
			System.out.println("Não foi possível excluir o tecnico!\nErro: " + e.getMessage());
		}
		
	}

	@Override
	public void alterar(Tecnico entidade) {
		try {
			PreparedStatement ps = getConnection().prepareStatement("UPDATE tecnicos SET cpf = ?, nome = ?, endereco = ?, telefone = ?, email = ? "
					+ "WHERE id = ?");
			ps.setString(1, entidade.getCpf());
			ps.setString(2, entidade.getNome());
			ps.setString(3, entidade.getEndereco());
			ps.setString(4, entidade.getTelefone());
			ps.setString(5, entidade.getEmail());
			ps.setLong(6, entidade.getId());
			ps.executeUpdate();
			closeStatement(ps);
		} catch (Exception e) {
			System.out.println("\nNão foi possível alterar o tecnico! " + e.getMessage());
		}
	}

	@Override
	public Tecnico obter(Long chave) {
		Tecnico tecnico = null;
		try {
			PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM tecnicos WHERE id = ?");
			ps .setLong(1, chave);
			ResultSet r1 = ps.executeQuery();
			if (r1.next())
				tecnico = new Tecnico(r1.getLong("ID"), 
						r1.getString("CPF"), 
						r1.getString("NOME"), 
						r1.getString("ENDERECO"),
						r1.getString("TELEFONE"), 
						r1.getString("EMAIL"));
			closeStatement(ps);
		} catch (Exception e) {
			
		}
		return tecnico;
	}

	@Override
	public List<Tecnico> obterTodos() {
		List<Tecnico> lista = new ArrayList<>();
		try {
			ResultSet r1 = getStatment().executeQuery("SELECT * FROM tecnicos");
			while(r1.next())
				// A ordem da lista tem a ver com o construtor padrao da classe Tecnico
				lista.add(new Tecnico(r1.getLong("ID"), r1.getString("NOME"), r1.getString("CPF"), r1.getString("ENDERECO"),
						r1.getString("TELEFONE"), r1.getString("EMAIL")));
			closeStatement(r1.getStatement());
		} catch (Exception e) {
			return null;
		}
		return lista;
	}
	
}
