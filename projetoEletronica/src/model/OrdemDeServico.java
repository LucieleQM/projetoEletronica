package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrdemDeServico {
	private long id;
	private Cliente cliente;
	private Eletronico eletronico;
	private TipoServico tipoServico;
	private Tecnico tecnico;
	private double valorTotal;
	private Date DtRegistro;
	private Date DtInicio;
	private Date DtConclusao;
	
	
	
	public OrdemDeServico() {
		
	}
		
	public OrdemDeServico(long id, Cliente cliente, Eletronico eletronico, TipoServico tipoServico, Tecnico tecnico, double valorTotal,
			Date dtRegistro, Date dtInicio, Date dtConclusao) {
		this.id = id;
		this.cliente = cliente;
		this.eletronico = eletronico;
		this.tipoServico = tipoServico;
		this.tecnico = tecnico;
		this.valorTotal = valorTotal;
		DtRegistro = dtRegistro;
		/*try {
			DtInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dtInicio);
			DtConclusao = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dtConclusao);
		} catch (ParseException e) {
			Logger.getLogger(OrdemDeServico.class.getName()).log(Level.SEVERE,null, e);
		}
	}
	
	public void DtsEmDateFormat(String dtInicioString) {
        try {
            this.DtInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dtInicioString);
        } catch (ParseException e) {
            Logger.getLogger(OrdemDeServico.class.getName()).log(Level.SEVERE, null, e);
        }*/
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

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
}
