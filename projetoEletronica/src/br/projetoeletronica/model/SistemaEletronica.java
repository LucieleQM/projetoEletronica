package br.projetoeletronica.model;

import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStreamReader;

import br.projetoeletronica.dao.ClienteDAO;
import br.projetoeletronica.dao.EletronicoDAO;
import br.projetoeletronica.dao.TecnicoDAO;

// A funçao dessa classe e coordenar as ações do sistema.
// Essa classe possui metodos que envolvem a interaçao com o usuario.

public class SistemaEletronica {
	
	//O objeto "entrada" serve para ler do teclado, como se fosse um Scanner.
	private static final BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
	
	// =========================================== Setor Cliente  =============================================================
	private final ClienteDAO cliDAO = new ClienteDAO();
	
	private void exibirCliente(Cliente cliente) {
		System.out.println("\nCliente: " + cliente.getNome() + "\nCPF: " + cliente.getCpf() + "\nEndereço: " + cliente.getEndereco() +
				"\nTelefone: " + cliente.getTelefone() + "\nEmail: " + cliente.getEmail() +
				"\n=========================================================================");
	}
	
	public void exibirTodosClientes() {
		cliDAO.obterTodos().forEach(cliente->exibirCliente(cliente));
	}
	
	/*public Cliente obterClientePorCPF(String cpf) {
	    try {
	        return cliDAO.obter(cpf);
	    } catch (Exception e) {
	        System.out.println("Erro ao obter cliente por CPF: " + e.getMessage());
	        return null;
	    }
	}*/
	
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
		//Cliente cliente = new Cliente();
		
		System.out.println("\n\nNum Serial: ");
		eletronico.setNumSerial(entrada.readLine());
		System.out.println("Tipo: ");
		eletronico.setTipo(entrada.readLine());
		System.out.println("Marca: ");
		eletronico.setMarca(entrada.readLine());
		System.out.println("Modelo: ");
		eletronico.setModelo(entrada.readLine());
		System.out.println("Avarias: ");
		eletronico.setAvarias(entrada.readLine());
		
		if (cliente.getCpf() == null) {
			System.out.println("Cliente: ");
			String cpfCliente = entrada.readLine();
			cliente.setCpf(cpfCliente);
			
			eletronico.setCliente(cliente);
			
			try {
	            eletDAO.inserir(eletronico);

	            System.out.println("\nEletronico inserido com sucesso!");
	        } catch (Exception e) {
	            System.out.println("\nErro ao inserir eletronico: " + e.getMessage());
	        }
			
		} else {
			eletronico.setCliente(cliente);
			
			try {
	            eletDAO.inserir(eletronico);

	            System.out.println("\nEletronico inserido com sucesso!");
	        } catch (Exception e) {
	            System.out.println("\nErro ao inserir eletronico: " + e.getMessage());
	        }
		}
		
	}
	
	
	public void excluirEletronico() throws IOException {
		System.out.println("Informe o Número Serial: ");
        String num_serial = entrada.readLine();
       eletDAO.excluir(num_serial);

	}
	
	public void exibirEletronico(Eletronico eletronico) {
		System.out.println("\nNumero Serial: " + eletronico.getNumSerial() + "\nTipo: " + eletronico.getTipo() + "\nMarca: " + eletronico.getMarca() +
				"\nModelo: " + eletronico.getModelo() + "\nCliente: " + eletronico.getCliente().getCpf() +
				"\n=========================================================================");
	}
	
	public void exibirTodosEletronicos() {
		eletDAO.obterTodos().forEach(eletronico->exibirEletronico(eletronico));
	}
	
	
	// =========================================== Setor Tecnico =============================================================
	private final TecnicoDAO tecDAO = new TecnicoDAO();
	
	private void exibirTecnico(Tecnico tecnico) {
		System.out.println("\nTecnico: " + tecnico.getNome() + "\nID: "+ tecnico.getId() +"\nCPF: " + tecnico.getCpf() + "\nEndereço: " + tecnico.getEndereco() +
				"\nTelefone: " + tecnico.getTelefone() + "\nEmail: " + tecnico.getEmail() +
				"\n=========================================================================");
	}
	
	public void exibirTodosTecnicos() {
		tecDAO.obterTodos().forEach(tecnico->exibirTecnico(tecnico));
	}
	
	public void inserirTecnico() throws IOException {
		Tecnico tecnico = new Tecnico();
		
		System.out.println("======================= CADASTRO TECNICO =======================");
        System.out.println("\nNome:");
        tecnico.setNome(entrada.readLine());
        System.out.println("\nCPF:");
        tecnico.setCpf(entrada.readLine());
        System.out.println("\nEndereço:");
        tecnico.setEndereco(entrada.readLine());
        System.out.println("\nTelefone:");
        tecnico.setTelefone(entrada.readLine());
        System.out.println("\nEmail:");
        tecnico.setEmail(entrada.readLine());
		
		try {
            tecDAO.inserir(tecnico);
            System.out.println("\nTecnico cadastrado com sucesso!");
            
        } catch (Exception e) {
            System.out.println("\nErro ao cadastrar técnico: " + e.getMessage());
        }
	
	}
	
	public void excluirTecnico() throws IOException{
		System.out.println("Informe o ID: ");
		long id = Long.parseLong(entrada.readLine());
		tecDAO.excluir(id);
	}
	
	}
