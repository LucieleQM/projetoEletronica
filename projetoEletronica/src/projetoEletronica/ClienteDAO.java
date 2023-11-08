package projetoEletronica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDAO {
    public boolean registrarCliente(Cliente cliente) throws SQLException {
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
            
            // Insere o endereço
            try (PreparedStatement stmtEndereco = con.prepareStatement(sqlEndereco)) {
                stmtEndereco.setString(1, cliente.getEndereco().getRua());
                stmtEndereco.setString(2, cliente.getEndereco().getCidade());
                stmtEndereco.setString(3, cliente.getEndereco().getUf());
                stmtEndereco.setString(4, cliente.getEndereco().getCep());
                stmtEndereco.setInt(5, cliente.getId());
                
                stmtEndereco.execute();
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
    }
}
