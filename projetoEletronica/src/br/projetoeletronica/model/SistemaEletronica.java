package br.projetoeletronica.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import br.projetoeletronica.dao.ClienteDAO;

public class SistemaEletronica {
	private final ClienteDAO dao = new ClienteDAO();
	private static final BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
	
	private void exibir(Cliente cliente) {
		System.out.println("Cliente: " + cliente.getNome() + "\nCPF: " + cliente.getCpf() + "\nEndereço: " + cliente.getEndereco() +
				"\nTelefone: " + cliente.getTelefone() + "\nEmail: " + cliente.getEmail() +
				"\n=========================================================================");
	}
	
	public void exibirTodos() {
		dao.obterTodos().forEach(cliente->exibir(cliente));
	}
	
	public void inserirCliente() throws IOException{
        Cliente cliente = new Cliente();
        System.out.println("Nome:");
        cliente.setNome(entrada.readLine());
        System.out.println("CPF:");
        cliente.setCpf(entrada.readLine());
        System.out.println("Endereço:");
        cliente.setEndereco(entrada.readLine());
        System.out.println("Telefone:");
        cliente.setTelefone(entrada.readLine());
        System.out.println("Email:");
        cliente.setEmail(entrada.readLine());
        
        try {
            dao.inserir(cliente);
            System.out.println("Cliente inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir o cliente: " + e.getMessage());
        }
       
	}

	public void excluirCliente() throws IOException{
        System.out.println("CPF:");
        String cpf = entrada.readLine();
       dao.excluir(cpf);
	}
	
	}
