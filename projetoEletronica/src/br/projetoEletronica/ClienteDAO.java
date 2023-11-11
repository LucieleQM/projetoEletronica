package br.projetoEletronica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends GenericDAO<Cliente, String>{
	@Override
	public List<Cliente> obterTodos() {
		List<Cliente> lista = new ArrayList<>();
		try {
			ResultSet r1 = getStatment().executeQuery("SELECT * FROM CLIENTE");
			while(r1.next())
				lista.add(new Cliente(r1.getString("NOME"), r1.getString("CPF"), r1.getString("ENDERECO"),
						r1.getString("TELEFONE"), r1.getString("EMAIL")));
			closeStatement(r1.getStatement());
		} catch (Exception e) {
			return lista;
		}
		return null;
	}
	
	@Override
	public Cliente obter(String chave) {
		Cliente cliente = null;
		try {
			PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM CLIENTE WHERE CPF = ?");
			ps .setString(1, chave);
			ResultSet r1 = ps.executeQuery();
			if (r1.next())
				cliente = new Cliente(r1.getString("NOME"), r1.getString("CPF"), r1.getString("ENDERECO"),
						r1.getString("TELEFONE"), r1.getString("EMAIL"));
			closeStatement(ps);
		} catch (Exception e) {
			
		}
		return cliente;
	}
	
	
	@Override
	public void inserir(Cliente entidade) {
		try {
			PreparedStatement ps = getConnection().prepareStatement("INSERT INTO CLIENTE VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, entidade.getNome());
			ps.setString(2, entidade.getCpf());
			ps.setString(3, entidade.getEndereco());
			ps.setString(4, entidade.getTelefone());
			ps.setString(5, entidade.getEmail());
			
			ps.executeUpdate();
			closeStatement(ps);
			} catch (Exception e){
			
			}
	}
	
	@Override
	public void excluir(String chave) {
		try {
			PreparedStatement ps = getConnection(). prepareStatement("DELETE FROM CLIENTE WHERE CPF = ?");
			
			ps.setString(1, chave);
			ps.executeUpdate();
			closeStatement(ps);
		} catch (Exception e){
			
		}
		
	}
	
	
	@Override
	public void alterar(Cliente entidade) {
		try {
			PreparedStatement ps = getConnection().prepareStatement("UPDATE FROM CLIENTE SET NOME = ?, ENDERECO = ?, TELEFONE = ?, EMAIL = ?"
					+ "WHERE CPF = ?");
			ps.setString(1, entidade.getNome());
			ps.setString(2, entidade.getEndereco());
			ps.setString(3, entidade.getTelefone());
			ps.setString(4, entidade.getEmail());
			ps.executeUpdate();
			closeStatement(ps);
		} catch (Exception e) {
			
		}
		
	}
	
	
	
 /*   public boolean registrarCliente(Cliente cliente) throws SQLException {
        Connection con = new ConnectionFactory().getConnection();
        String sqlCliente = "INSERT INTO clientes(nome, cpf, telefone, email) values (?,?,?,?)";
        String sqlEndereco = "INSERT INTO endereco(rua, cidade, estado, cep, cliente_id) values (?,?,?,?,?)";
        
        try {
            con.setAutoCommit(false);
            
            // Insere o cliente
            try (PreparedStatement stmtCliente = con.prepareStatement(sqlCliente, Statement.RETURN_GENERATED_KEYS)) {
                stmtCliente.setString(1, cliente.getNome());
                stmtCliente.setString(2, cliente.getCpf());
                stmtCliente.setString(3, cliente.getTelefone());
                stmtCliente.setString(4, cliente.getEmail());
                
                stmtCliente.execute();
                
                // Obtém o ID gerado para o cliente
                ResultSet generatedKeys = stmtCliente.getGeneratedKeys();
                if (generatedKeys.next()) {
                    cliente.setId(generatedKeys.getInt(1));
                }
            }
 
            
            con.commit();
            return true;
        } catch (SQLException ex) {
            con.rollback();
            System.out.println("Não foi possível cadastrar o cliente!");
            return false;
        } finally {
            con.close();
        }
    }*/
}
