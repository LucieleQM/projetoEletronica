package br.projetoeletronica.model;

public class Cliente extends Pessoa {
	
	
	public Cliente() {
		super();
		
	}

	public Cliente(long id, String nome, String cpf, String endereco, String telefone, String email) {
		super(id, nome, cpf, endereco, telefone, email);
	}	
	

}
