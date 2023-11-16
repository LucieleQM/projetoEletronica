package br.projetoeletronica.model;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

// Essa é a classe main do programa.
// Nessa classe estão as informacoes mostradas no console
public class App {
	public static void main(String[] args) throws IOException {
		SistemaEletronica sistema = new SistemaEletronica();
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		
		while (true) {
			
			System.out.println("\n1- Tecnico\t 2- Cliente\t 3- Eletronico\t 4- Servico\t 5-Ordem de Servico\t 0- Sair");
			System.out.println("=================================================================================================");
			int opcaoMenu = Integer.parseInt(entrada.readLine());
			
			if (opcaoMenu == 0) 
				break;
			
			if (opcaoMenu == 1) {
				while(true) {
					System.out.println("\n1- Inserir\t3- Excluir\t5- Listar"
									 + "\n2- Alterar\t4- Procurar\t0- Voltar");
					System.out.println("===========================================");
					int opcao = Integer.parseInt(entrada.readLine());
					
					if (opcao == 0)
						break;
					switch (opcao) {
						case(1):
							sistema.inserirTecnico();
							break;
						case(2):
							sistema.alterarTecnico();
						    break;
						case(3):
							sistema.excluirTecnico();
							break;
						case(4):
							sistema.procurarTecnico();
							break;
						case(5):
							sistema.exibirTodosTecnicos();
							break;
					}
					
				}
			}
			
			if (opcaoMenu == 2) {
				while(true) {
					System.out.println("\n1- Inserir\t3- Excluir\t5- Listar"
									+ "\n2- Alterar\t4- Procurar\t0- Voltar");
					System.out.println("===========================================");
					int opcao = Integer.parseInt(entrada.readLine());
					
					if (opcao == 0)
						break;
					switch (opcao) {
						case(1):
							sistema.inserirCliente();
							break;
						case(2):
							sistema.alterarCliente();
							break;
						case(3):
							sistema.excluirCliente();
							break;
						case(4):
							sistema.procurarCliente();
							break;
						case(5):
							sistema.exibirTodosClientes();
							break;
					}
					
				}
			}
			
			if (opcaoMenu == 3) {
				while(true) {
					System.out.println("\n1- Inserir\t3- Procurar"
									+ "\n2- Excluir\t4- Listar\t0- Voltar");
					System.out.println("===========================================");
					int opcao = Integer.parseInt(entrada.readLine());
					
					if (opcao == 0)
						break;
					switch (opcao) {
						case(1):
							Cliente cliente = new Cliente();
							sistema.inserirEletronico(cliente);
							break;
						/*case(2): //nao tá funcionando
							sistema.alterarEletronico();
							break;*/
						case(2):
							sistema.excluirEletronico();
							break;
						case(3):
							sistema.procurarEletronico();
							break;
						case(4):
							sistema.exibirTodosEletronicos();
							break;
					}
					
				}
			}
			if (opcaoMenu == 4) {
				while(true) {
					System.out.println("\n1- Inserir\t3- Procurar"
									+ "\n2- Excluir\t4- Listar\t0- Voltar");
					System.out.println("===========================================");
					int opcao = Integer.parseInt(entrada.readLine());
					
					if (opcao == 0)
						break;
					switch (opcao) {
						case(1):
							sistema.inserirTipoServico();
							break;
						case(2):
							sistema.excluirTipoServico();
							break;
						case(3):
							
							break;
						case(4):
							sistema.exibirTodosTipoServico();
							break;
					}	
				}
			}
			if (opcaoMenu == 5) {
				while(true) {
					System.out.println("\n1- Excluir\t3- Listar"
									+ "\n2- Procurar \t4- Voltar");
					System.out.println("===========================================");
					int opcao = Integer.parseInt(entrada.readLine());
					
					if (opcao == 0)
						break;
					switch (opcao) {
						case(1):
							sistema.excluirOrdemServico();
							break;
						case(2):
							
							break;
						case(3):
							sistema.exibirTodosOrdemServico();
							break;
					}	
				}
			}
		}
		
		
		
	}

}
