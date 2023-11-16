package br.projetoeletronica.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.projetoeletronica.model.Cliente;
import br.projetoeletronica.model.Eletronico;

public class EletronicoDAO extends GenericDAO<Eletronico, String>{
	
	// metodo insert OK
	@Override
	public void inserir(Eletronico entidade) throws Exception {
		PreparedStatement ps = null;
		String sql = "INSERT INTO eletronicos(num_serial, tipo, marca, modelo, cliente_cpf, avarias, defeito)" + 
					 "values(?,?,?,?,?,?,?)";
		
		try {
			ps = getConnection().prepareStatement(sql);
			ps.setString(1, entidade.getNumSerial());
			ps.setString(2, entidade.getTipo());
			ps.setString(3, entidade.getMarca());
			ps.setString(4, entidade.getModelo());
			ps.setString(5, entidade.getCliente().getCpf());
			ps.setString(6, entidade.getAvarias());
			ps.setString(7, entidade.getDefeito());
			
			ps.executeUpdate();
			closeStatement(ps);
			
		} catch (SQLException e){
			System.out.println("Não foi possível inserir o eletronico! Erro: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Erro Geral: " + e.getMessage());
		}
	}
	// metodo delete OK
	@Override
	public void excluir(String chave) {
		try {
			PreparedStatement ps = getConnection(). prepareStatement("DELETE FROM eletronicos WHERE NUM_SERIAL = ?");
			ps.setString(1, chave);
			ps.executeUpdate();
			closeStatement(ps);
		} catch (Exception e){
			System.out.println("Não foi possível excluir o eletronico!\nErro: " + e.getMessage());
		}
		
	}
	// metodo update falta implementar
	@Override
	public void alterar(Eletronico entidade) {
		try {
			PreparedStatement ps = getConnection().prepareStatement("UPDATE eletronicos SET tipo = ?, marca = ?, "
					+ "modelo = ?, cpf_cliente = ?, avarias = ?, defeito = ?"
					+ "WHERE num_serial = ?");
			ps.setString(1, entidade.getTipo());
			ps.setString(2, entidade.getMarca());
			ps.setString(3, entidade.getModelo());
			ps.setString(4, entidade.getCliente().getCpf());
			ps.setString(5, entidade.getAvarias());
			ps.setString(6, entidade.getDefeito());
			ps.setString(7, entidade.getNumSerial());
			ps.executeUpdate();
			closeStatement(ps);
		} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
		}	
	}

	
	// metodo select where OK
	@Override
	public Eletronico obter(String chave) {
		Eletronico eletronico = null;
		try {
			PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM eletronicos WHERE NUM_SERIAL = ?");
			ps.setString(1, chave);
			ResultSet r1 = ps.executeQuery();
			if (r1.next()) {
				String cpf = r1.getString("CLIENTE_CPF");
				ClienteDAO clienteDAO = new ClienteDAO();
				Cliente cliente = clienteDAO.obter(cpf);
				
				eletronico = new Eletronico(r1.getString("NUM_SERIAL"), 
						r1.getString("TIPO"), 
						r1.getString("MARCA"), 
						r1.getString("MODELO"),
						cliente,		
						r1.getString("AVARIAS"),
						r1.getString("DEFEITO"));
			closeStatement(ps);
			}
				
		} catch (Exception e) {
			System.out.println("Não foi possível obter o eletrônico!");
		}
		return eletronico; 
	}
	
	// Metodo select OK
	@Override
	public List<Eletronico> obterTodos() {
		List<Eletronico> lista = new ArrayList<>();
		try {
			ResultSet r1 = getStatment().executeQuery("SELECT * FROM Eletronicos");
			while(r1.next()) {
				String cpf = r1.getString("CLIENTE_CPF");
				ClienteDAO clienteDAO = new ClienteDAO();
				Cliente cliente = clienteDAO.obter(cpf);
			
				lista.add(new Eletronico(r1.getString("NUM_SERIAL"), 
						r1.getString("TIPO"), 
						r1.getString("MARCA"),
						r1.getString("MODELO"), 
						cliente,
						r1.getString("AVARIAS"),
						r1.getString("DEFEITO")));
			closeStatement(r1.getStatement());
			}
				
		} catch (Exception e) {
			System.out.println("Não foi possível obter os eletrônicos!" + e.getMessage());
		}
		return lista;
	}
	
}
