package br.projetoeletronica.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.projetoeletronica.model.Eletronico;

public class EletronicoDAO extends GenericDAO<Eletronico, String>{
	@Override
	public void inserir(Eletronico entidade) throws Exception {
		PreparedStatement ps = null;
		String sql = "INSERT INTO eletronicos(num_serial, tipo, marca, modelo, cliente_cpf)" + 
					 "values(?,?,?,?,?)";
		
		try {
			ps = getConnection().prepareStatement(sql);
			ps.setString(1, entidade.getNumSerial());
			ps.setString(2, entidade.getTipo());
			ps.setString(3, entidade.getMarca());
			ps.setString(4, entidade.getModelo());
			ps.setString(5, entidade.getCliente().getCpf());
			
			ps.executeUpdate();
			closeStatement(ps);
			
		} catch (SQLException e){
			System.out.println("Não foi possível inserir o eletronico! Erro: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Erro Geral: " + e.getMessage());
		}
	}
	
	@Override
	public void excluir(String chave) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void alterar(Eletronico entidade) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Eletronico obter(String chave) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Eletronico> obterTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
