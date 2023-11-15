package br.projetoeletronica.model;

import java.util.Date;

public class OrdemDeServico {
	private long id;
	private Cliente cliente;
	private Eletronico eletronico;
	private TipoServico tipoServico;
	private Tecnico tecnico;
	private Date DtRegistro;
	private Date DtInicio;
	private Date DtConclusao;
	
	
	public OrdemDeServico() {
		
	}
		
	public OrdemDeServico(long id, Cliente cliente, Eletronico eletronico, TipoServico tipoServico, Tecnico tecnico,
			Date dtRegistro, Date dtInicio, Date dtConclusao) {
		this.id = id;
		this.cliente = cliente;
		this.eletronico = eletronico;
		this.tipoServico = tipoServico;
		this.tecnico = tecnico;
		DtRegistro = dtRegistro;
		DtInicio = dtInicio;
		DtConclusao = dtConclusao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Eletronico getEletronico() {
		return eletronico;
	}
	public void setEletronico(Eletronico eletronico) {
		this.eletronico = eletronico;
	}
	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Tecnico getTecnico() {
		return tecnico;
	}
	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Date getDtRegistro() {
		return DtRegistro;
	}

	public void setDtRegistro(Date dtRegistro) {
		DtRegistro = dtRegistro;
	}

	public Date getDtInicio() {
		return DtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		DtInicio = dtInicio;
	}

	public Date getDtConclusao() {
		return DtConclusao;
	}

	public void setDtConclusao(Date dtConclusao) {
		DtConclusao = dtConclusao;
	}
	
	
	
}
