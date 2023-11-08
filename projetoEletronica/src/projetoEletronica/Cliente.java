package projetoEletronica;

public class Cliente extends Pessoa {
	private int id;
	
	
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nome, String cpf, Endereco endereco, String telefone, String email, int id) {
		super(nome, cpf, endereco, telefone, email);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
