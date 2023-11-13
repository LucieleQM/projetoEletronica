package br.projetoeletronica.model;

public class Cliente extends Pessoa {
	long id;
	
	
	public Cliente() {
		super();
		
	}

	public Cliente(long id, String nome, String cpf, String endereco, String telefone, String email) {
		super(nome, cpf, endereco, telefone, email);
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
