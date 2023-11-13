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
			System.out.println("1- Tecnico\t2- Cliente\t3- Eletronico\t0- Sair");
			System.out.println("================================================\n");
			int opcao = Integer.parseInt(entrada.readLine());
			
			if (opcao == 0) 
				break;
			
			if (opcao == 1) {
				while(true) {
					System.out.println("1- Listar\t2- Inserir\t3- Excluir\t0- Voltar");
					opcao = Integer.parseInt(entrada.readLine());
					
					if (opcao == 0)
						break;
					switch (opcao) {
						case(1):
							sistema.exibirTodosTecnicos();
							break;
						case(2):
							sistema.inserirTecnico();
							break;
						case(3):
							sistema.excluirTecnico();
							break;
					}
					
				}
			}
			
			if (opcao == 2) {
				while(true) {
					System.out.println("1- Listar\t2- Inserir\t3- Excluir\t0- Voltar");
					opcao = Integer.parseInt(entrada.readLine());
					
					if (opcao == 0)
						break;
					switch (opcao) {
						case(1):
							sistema.exibirTodosClientes();
							break;
						case(2):
							sistema.inserirCliente();
							break;
						case(3):
							sistema.excluirCliente();
							break;
					}
					
				}
			}
			
			/*if (opcao == 3) {
				while(true) {
					System.out.println("1- Listar\t2- Inserir\t3- Excluir\t0- Voltar");
					opcao = Integer.parseInt(entrada.readLine());
					
					if (opcao == 0)
						break;
					switch (opcao) {
						case(1):
							sistema.exibirTodosEletronicos();
							break;
						case(2):
							sistema.inserirEletronico();
							break;
						case(3):
							sistema.excluirEletronico();
							break;
					}
					
				}
			}*/
		}
		
		
		
	}

}
