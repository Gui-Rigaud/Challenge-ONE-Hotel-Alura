package br.com.hotelalura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.hotelalura.modelo.Reserva;

public class ReservaDAO {

	private Connection connection;

	public ReservaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(Reserva reserva) {
		String sql = "INSERT INTO RESERVAS (DATA_ENTRADA, DATA_SAIDA, VALOR, FORMA_PAGAMENTO)"
				+ "VALUES (?, ?, ?, ?)";
		
		try(PreparedStatement stm = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			stm.setString(1, reserva.getDiaDeChegada());
			stm.setString(2, reserva.getDiaDeSaida());
			stm.setDouble(3, reserva.getValorDaReserva());
			stm.setString(4, reserva.getFormaPagamento());
			stm.execute();
			
			try(ResultSet rst = stm.getGeneratedKeys()){				
				while(rst.next()) {
					reserva.setId(rst.getInt(1));
				}
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(Integer id, String diaDeChegada, String diaDeSaida, 
			double valorDaReserva, String formaPagamento) {
		
		String sql = "UPDATE RESERVAS R SET R.DATA_ENTRADA = ?, R.DATA_SAIDA = ?, R.VALOR = ?, "
				+ "R.FORMA_PAGAMENTO = ? WHERE ID = ?";
		
		try(PreparedStatement pstm = this.connection.prepareStatement(sql)){
			pstm.setString(1, diaDeChegada);
			pstm.setString(2, diaDeSaida);
			pstm.setDouble(3, valorDaReserva);
			pstm.setString(4, formaPagamento);
			pstm.setInt(5, id);
			pstm.execute();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deletarReserva(Integer id) {
		
		String sql1 = "DELETE FROM HOSPEDES WHERE ID_RESERVA = ?";
		String sql2 = "DELETE FROM RESERVAS WHERE ID = ?";		
		
		try(PreparedStatement pstm1 = this.connection.prepareStatement(sql1); 
				PreparedStatement pstm2 = this.connection.prepareStatement(sql2)){
			pstm1.setInt(1, id);
			pstm1.execute();
			
			pstm2.setInt(1, id);
			pstm2.execute();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}		
	}
}
