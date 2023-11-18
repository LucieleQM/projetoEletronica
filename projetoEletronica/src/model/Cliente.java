package model;

import java.util.List;

public class Cliente extends Pessoa {
	// Esse atributo indica que 1 cliente pode possuir N eletronicos
	private List<Eletronico> eletronico;
	
	
	public Cliente() {
		super();
		
	}

	public Cliente(long id, String nome, String cpf, String endereco, String telefone, String email, List<Eletronico> eletronico) {
		super(id, nome, cpf, endereco, telefone, email);
		this.eletronico = eletronico;
	}
	
	public List<Eletronico> getEletronico() {
		return eletronico;
	}

	public void setEletronico(List<Eletronico> eletronico) {
		this.eletronico = eletronico;
	}

}
