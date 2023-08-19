package br.com.hotelalura.controllers;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.hotelalura.dao.ReservaDAO;
import br.com.hotelalura.modelo.ConnectionFactory;
import br.com.hotelalura.modelo.Reserva;

public class ReservaController {
	private ReservaDAO reservaDao;
	
	public ReservaController() {
		Connection connection;
		try {
			connection = new ConnectionFactory().getConnection();
			this.reservaDao = new ReservaDAO(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void salvar(Reserva reserva) throws SQLException {
		this.reservaDao.salvar(reserva);
	}
	
	public void alterar(Integer id, String diaDeChegada, String diaDeSaida, 
		 double valorDaReserva, String formaPagamento) {	
		
		this.reservaDao.alterar(id, diaDeChegada, diaDeSaida, valorDaReserva, formaPagamento);
		
	}
	
	public void deletarReserva(Integer id) {
		this.reservaDao.deletarReserva(id);
	}
	
}
