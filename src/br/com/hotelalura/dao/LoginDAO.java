package br.com.hotelalura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hotelalura.modelo.User;

public class LoginDAO {
	private Connection connection;

	public LoginDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<User> buscar() throws SQLException {
		List<User> usuarios = new ArrayList<User>();
		
		String sql = "SELECT * FROM USERS";
		
		try(PreparedStatement stm = this.connection.prepareStatement(sql)){	
			stm.execute();
			
			try(ResultSet rst = stm.getResultSet()){				
				while(rst.next()) {
					User user = new User(
							rst.getInt("ID"), rst.getString("LOGIN"), rst.getString("SENHA"));
					usuarios.add(user);
				}
			}
		}
		
		return usuarios;
	}
}
