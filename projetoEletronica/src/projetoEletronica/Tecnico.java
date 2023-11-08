package projetoEletronica;

public class Tecnico extends Pessoa {
	private int id;
	private boolean estado;

	
	public Tecnico() {
		super();
		this.id = 0;
		this.estado = true;
	}


	public Tecnico(String nome, String cpf, Endereco endereco, String telefone, String email, int id, boolean estado) {
		super(nome, cpf, endereco, telefone, email);
		this.id = id;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	
}
