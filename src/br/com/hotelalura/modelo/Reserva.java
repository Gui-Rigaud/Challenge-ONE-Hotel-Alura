package br.com.hotelalura.modelo;

public class Reserva {
	
	private Integer id;
	private String diaDeChegada;
	private String diaDeSaida;
	private double valorDaReserva;
	private String formaPagamento;
	
	public Reserva(String diaDeChegada, String diaDeSaida, double valorDaReserva, String formaPagamento) {
		this.diaDeChegada = diaDeChegada;
		this.diaDeSaida = diaDeSaida;
		this.valorDaReserva = valorDaReserva;
		this.formaPagamento = formaPagamento;
	}

	@Override
	public String toString() {
		return String.format("O id da reserva é: %d, o valor é: %f", this.id, this.valorDaReserva);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDiaDeChegada() {
		return diaDeChegada;
	}

	public String getDiaDeSaida() {
		return diaDeSaida;
	}

	public double getValorDaReserva() {
		return valorDaReserva;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}
	
}
