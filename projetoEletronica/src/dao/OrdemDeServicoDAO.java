package dao;

import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Eletronico;
import model.OrdemDeServico;
import model.Tecnico;
import model.TipoServico;

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
			PreparedStatement ps = getConnection(). prepareStatement("DELETE FROM ordensServico WHERE id = ?");
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
		OrdemDeServico ordServico = null;
		try {
			PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM ordensServico WHERE id = ?");
			ps.setLong(1, chave);
			ResultSet r1 = ps.executeQuery();
			if (r1.next()) {
				String cpf = r1.getString("CLIENTE_CPF");
				ClienteDAO clienteDAO = new ClienteDAO();
				Cliente cliente = clienteDAO.obter(cpf);
				
				String numSerial = r1.getString("ELETRONICO_NUM_SERIAL");
				EletronicoDAO eletDAO = new EletronicoDAO();
				Eletronico eletronico = eletDAO.obter(numSerial);
				
				long idS = r1.getLong("TIPO_SERVICO_ID");
				TipoServicoDAO ServDAO = new TipoServicoDAO();
				TipoServico tipoServico = ServDAO.obter(idS);
				
				long idT = r1.getLong("TECNICO_ID");
				TecnicoDAO tecDAO = new TecnicoDAO();
				Tecnico tecnico = tecDAO.obter(idT);
				
				ordServico = new OrdemDeServico(r1.getLong("id"),
						cliente, 
						eletronico, 
						tipoServico,
						tecnico,
						r1.getDouble("valor_total"),
						r1.getDate("dt_registro"),
						r1.getDate("dt_inicio"),
						r1.getDate("dt_conclusao"));
			closeStatement(ps);
			}
				
		} catch (Exception e) {
			System.out.println("Não foi possível obter a ordem de servico!");
		}
		return ordServico;
	}
	
	@Override
	public List<OrdemDeServico> obterTodos() {
		List<OrdemDeServico> lista = new ArrayList<>();
		try {
			ResultSet r1 = getStatment().executeQuery("SELECT * FROM ordensServico");
			while(r1.next()) {
				String cpf = r1.getString("CLIENTE_CPF");
				ClienteDAO clienteDAO = new ClienteDAO();
				Cliente cliente = clienteDAO.obter(cpf);
				
				String numSerial = r1.getString("ELETRONICO_NUM_SERIAL");
				EletronicoDAO eletDAO = new EletronicoDAO();
				Eletronico eletronico = eletDAO.obter(numSerial);
				
				long idS = r1.getLong("TIPO_SERVICO_ID");
				TipoServicoDAO ServDAO = new TipoServicoDAO();
				TipoServico tipoServico = ServDAO.obter(idS);
				
				long idT = r1.getLong("TECNICO_ID");
				TecnicoDAO tecDAO = new TecnicoDAO();
				Tecnico tecnico = tecDAO.obter(idT);
			
				lista.add(new OrdemDeServico(r1.getLong("id"),
						cliente, 
						eletronico, 
						tipoServico,
						tecnico,
						r1.getDouble("valor_total"),
						r1.getDate("dt_registro"),
						r1.getDate("dt_inicio"),
						r1.getDate("dt_conclusao")));
			closeStatement(r1.getStatement());
			}
				
		} catch (Exception e) {
			System.out.println("Não foi possível obter as Ordens de Servicos!" + e.getMessage());
		}
		return lista;
	}
}
