package br.com.hotelalura.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.hotelalura.dao.HospedeDAO;
import br.com.hotelalura.modelo.ConnectionFactory;
import br.com.hotelalura.modelo.Hospede;

public class HospedeController {
	
	private HospedeDAO hospedeDao;
	
	public HospedeController(){
		Connection connection;
		try {
			connection = new ConnectionFactory().getConnection();
			this.hospedeDao = new HospedeDAO(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void salvar(Hospede hospede) throws SQLException {
		this.hospedeDao.salvar(hospede);
	}
	
	public List<Hospede> buscar(String identify) throws SQLException{
		return hospedeDao.buscar(identify);
	}
	
	public void alterar(Integer id, String nome, String sobrenome, String dataDeNascimento, String nacionalidade, 
			String telefone) throws SQLException{
		this.hospedeDao.alterar(id, nome, sobrenome, dataDeNascimento, nacionalidade, telefone);
	}
	
}
