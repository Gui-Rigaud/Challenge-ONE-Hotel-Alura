package br.com.hotelalura.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.hotelalura.dao.LoginDAO;
import br.com.hotelalura.modelo.ConnectionFactory;
import br.com.hotelalura.modelo.User;

public class LoginController {
	private LoginDAO loginDao;

	public LoginController() throws SQLException {
		Connection connection = 
				new ConnectionFactory().getConnection();
		this.loginDao = new LoginDAO(connection);
	}
	
	public List<User> signUp() throws SQLException {
		return loginDao.buscar();
	}
}
