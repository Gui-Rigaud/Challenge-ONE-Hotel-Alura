package br.com.hotelalura.modelo;

import java.util.ArrayList;
import java.util.List;

public class Hospede {
	
	private Integer idHospede;
	private String nome;
	private String sobrenome;
	private String dataDeNascimento;
	private String nacionalidade;
	private String telefone;
	private Integer idReserva;
	private List<Reserva> reservas = new ArrayList<Reserva>();
	
	public Hospede(String nome, String sobrenome, String dataDeNascimento, String nacionalidade, String telefone,
			Integer idReserva) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataDeNascimento = dataDeNascimento;
		this.nacionalidade = nacionalidade;
		this.telefone = telefone;
		this.idReserva = idReserva;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdHospede(Integer id) {
		this.idHospede = id;
	}

	public Integer getIdHospede() {
		return idHospede;
	}
	
	public void adicionarReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	
	public List<Reserva> getReservas() {
		return reservas;
	}

	@Override
	public String toString() {
		return String.format("Seguem as informações do hóspede: %s, %s, %s, %s, %s, %d", this.nome,	this.sobrenome,	this.dataDeNascimento,
		this.nacionalidade, this.telefone, this.idReserva);
	}
	
}
