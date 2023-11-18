package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.TipoServico;

public class TipoServicoDAO extends GenericDAO<TipoServico, Long>{
	
	public void inserir(TipoServico entidade) throws Exception {
		PreparedStatement ps = null;
		String sql= "INSERT INTO tiposServicos(nome, descricao, preco_base)" + 
					" VALUES (?,?,?)";
		try {
			ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, entidade.getNome());
			ps.setString(2, entidade.getDescricao());
			ps.setDouble(3, entidade.getPrecoBase());
			
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
				System.out.println("Não foi possível inserir o cliente!\nErro: " + e.getMessage());
				e.printStackTrace();
			}
	};
	
	@Override
	public void excluir(Long chave) {
		try {
			PreparedStatement ps = getConnection(). prepareStatement("DELETE FROM tiposServicos WHERE id = ?");
			ps.setLong(1, chave);
			ps.executeUpdate();
			closeStatement(ps);
		} catch (Exception e){
			System.out.println("Não foi possível excluir o Tipo de Servico!\nErro: " + e.getMessage());
		}
		
	}
	// Precisa de ajuste
	@Override
	public void alterar(TipoServico entidade) {
		try {
			PreparedStatement ps = getConnection().prepareStatement("UPDATE FROM tiposServicos SET NOME = ?, DESCRICAO = ?, PRECO_BASE = ?"
					+ "WHERE ID = ?");
			ps.setString(1, entidade.getNome());
			ps.setString(2, entidade.getDescricao());
			ps.setDouble(3, entidade.getPrecoBase());
			ps.executeUpdate();
			closeStatement(ps);
		} catch (Exception e) {
			System.out.println("Não foi possível alterar o Tipo de Servico! " + e.getMessage());
		}	
	}
	
	@Override
	public TipoServico obter(Long chave) {
		TipoServico tpServico = null;
		try {
			PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM tiposServicos WHERE id = ?");
			ps .setLong(1, chave);
			ResultSet r1 = ps.executeQuery();
			if (r1.next())
				tpServico = new TipoServico(r1.getLong("ID"), 
						r1.getString("NOME"), 
						r1.getString("DESCRICAO"), 
						r1.getDouble("PRECO_BASE"));
			closeStatement(ps);
		} catch (Exception e) {
			
		}
		return tpServico;
	}
	
	@Override
	public List<TipoServico> obterTodos() {
		List<TipoServico> lista = new ArrayList<>();
		try {
			ResultSet r1 = getStatment().executeQuery("SELECT * FROM tiposServicos");
			while(r1.next())
				lista.add(new TipoServico(r1.getLong("ID"), 
						r1.getString("NOME"), 
						r1.getString("DESCRICAO"), 
						r1.getDouble("PRECO_BASE")));
			closeStatement(r1.getStatement());
		} catch (Exception e) {
			System.out.println("Não foi possível retornar a lista com os Tipos de Serviços" + e.getMessage());
			return null;
		}
		return lista;
	}

}
