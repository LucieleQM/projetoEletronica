package br.projetoeletronica.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class App {

	public static void main(String[] args) throws IOException {
		SistemaEletronica sistema = new SistemaEletronica();
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("1-Listar\t2-Inserir\t3-Excluir\t0-Sair");
			int opcao = Integer.parseInt(entrada.readLine());
			
			if (opcao == 0)
				break;
			switch (opcao) {
				case(1):
					sistema.exibirTodos();
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

}
