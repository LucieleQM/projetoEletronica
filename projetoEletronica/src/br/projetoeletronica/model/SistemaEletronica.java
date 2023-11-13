package br.projetoeletronica.model;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

import br.projetoeletronica.dao.ClienteDAO;
import br.projetoeletronica.dao.EletronicoDAO;

// A funçao dessa classe e coordenar as ações do sistema.
// Essa classe possui metodos que envolvem a interaçao com o usuario.

public class SistemaEletronica {
	
	//O objeto "entrada" serve para ler do teclado, como se fosse um Scanner.
	private static final BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
	
	// =========================================== Setor Cliente  =============================================================
	private final ClienteDAO cliDAO = new ClienteDAO();
	
	private void exibir(Cliente cliente) {
		System.out.println("\nCliente: " + cliente.getNome() + "\nCPF: " + cliente.getCpf() + "\nEndereço: " + cliente.getEndereco() +
				"\nTelefone: " + cliente.getTelefone() + "\nEmail: " + cliente.getEmail() +
				"\n=========================================================================");
	}
	
	public void exibirTodos() {
		cliDAO.obterTodos().forEach(cliente->exibir(cliente));
	}
	
	public void inserirCliente() throws IOException{
        Cliente cliente = new Cliente();
        System.out.println("\nNome:");
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
        	cliDAO.inserir(cliente);
        	inserirEletronico(cliente);

            System.out.println("Cliente inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir o cliente: " + e.getMessage());
        }
  
	}

	public void excluirCliente() throws IOException{
        System.out.println("CPF:");
        String cpf = entrada.readLine();
       cliDAO.excluir(cpf);
	}
	
	// =========================================== Setor Eletronico =============================================================
	private final EletronicoDAO eletDAO = new EletronicoDAO();
	
	public void inserirEletronico(Cliente cliente) throws IOException {
		Eletronico eletronico = new Eletronico();
		System.out.println("\n\nNum Serial: ");
		eletronico.setNumSerial(entrada.readLine());
		System.out.println("Tipo: ");
		eletronico.setTipo(entrada.readLine());
		System.out.println("Marca: ");
		eletronico.setMarca(entrada.readLine());
		System.out.println("Modelo: ");
		eletronico.setModelo(entrada.readLine());
		System.out.println("Cliente: ");
		eletronico.setCliente(cliente);
		
		try {
            eletDAO.inserir(eletronico);

            System.out.println("\nEletronico inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("\nErro ao inserir eletronico: " + e.getMessage());
        }
		
	}
	
	}