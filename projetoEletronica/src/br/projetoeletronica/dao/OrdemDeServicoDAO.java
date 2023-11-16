package br.projetoeletronica.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.projetoeletronica.model.OrdemDeServico;

public class OrdemDeServicoDAO extends GenericDAO<OrdemDeServico, Long>{
	
	@Override
	public void inserir(OrdemDeServico entidade) throws Exception {
		PreparedStatement ps = null;
        String sql = ("INSERT INTO OrdensServico (CLIENTE_CPF, ELETRONICO_NUM_SERIAL, "
        			+ "TIPO_SERVICO_ID, TECNICO_ID, DT_INICIO, DT_CONCLUSAO, VALOR_TOTAL) "
        			+ "VALUES (?, ?, ?, ?, ?, ?, ?)");
		try {
			ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entidade.getCliente().getCpf());
            ps.setString(2, entidade.getEletronico().getNumSerial());
            ps.setLong(3, entidade.getTipoServico().getId());
            ps.setLong(4, entidade.getTecnico().getId());
            ps.setDate(5, (Date) entidade.getDtInicio());
            ps.setDate(6, (Date) entidade.getDtConclusao());
            ps.setDouble(7, entidade.getValorTotal());
            
            
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
	        
        } catch (Exception e) {
        	System.out.println("Não foi possível inserir a Ordem De Serviço!\nErro: " + e.getMessage());
			e.printStackTrace();
        }
		
	}
	
	@Override
	public void excluir(Long chave) {
		try {
			PreparedStatement ps = getConnection(). prepareStatement("DELETE FROM tiposServicos WHERE id = ?");
			ps.setLong(1, chave);
			ps.executeUpdate();
			closeStatement(ps);
		} catch (Exception e){
			System.out.println("Não foi possível excluir a Ordem de Servico!\nErro: " + e.getMessage());
		}
		
	}
	
	@Override
	public void alterar(OrdemDeServico entidade) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public OrdemDeServico obter(Long chave) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<OrdemDeServico> obterTodos() {
		// TODO Auto-generated method stub
		return null;
	}
}
