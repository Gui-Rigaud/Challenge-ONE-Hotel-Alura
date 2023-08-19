package br.com.hotelalura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.hotelalura.modelo.Hospede;
import br.com.hotelalura.modelo.Reserva;


public class HospedeDAO {
	
	private Connection connection;
	
	public HospedeDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(Hospede hospede) throws SQLException{
		
		String sql = "INSERT INTO HOSPEDES (NOME, SOBRENOME, DATA_NASCIMENTO, NACIONALIDADE, TELEFONE, ID_RESERVA) VALUES"
				+ "(?, ?, ?, ?, ?, ?)";
		
		try(PreparedStatement stm = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			stm.setString(1, hospede.getNome());
			stm.setString(2, hospede.getSobrenome());
			stm.setString(3, hospede.getDataDeNascimento());
			stm.setString(4, hospede.getNacionalidade());
			stm.setString(5, hospede.getTelefone());
			stm.setInt(6, hospede.getIdReserva());
			stm.execute();
			
			try(ResultSet rst = stm.getGeneratedKeys()){				
				while(rst.next()) {
					hospede.setIdHospede(rst.getInt(1));
				}
			}
		}
	}
	
	public List<Hospede> buscar(String identify) throws SQLException {
		Hospede ultima = null;
		List<Hospede> hospedes = new ArrayList<Hospede>();
		String sql;
		boolean result = isNumeric(identify);
		
		if(result) {
			sql = "SELECT H.*, R.DATA_ENTRADA, R.DATA_SAIDA, R.VALOR, R.FORMA_PAGAMENTO FROM RESERVAS R INNER JOIN HOSPEDES H "
					+ "ON R.ID = H.ID_RESERVA "
					+ "WHERE ID_RESERVA = ?";
		}else {
			sql = "SELECT H.*, R.DATA_ENTRADA, R.DATA_SAIDA, R.VALOR, R.FORMA_PAGAMENTO FROM RESERVAS R INNER JOIN HOSPEDES H "
					+ "ON R.ID = H.ID_RESERVA "
					+ "WHERE SOBRENOME = ?";
		}
		
		try(PreparedStatement pstm = this.connection.prepareStatement(sql)){
			if (result) {
				pstm.setInt(1, Integer.parseInt(identify));
			}else {
				pstm.setString(1, identify);
			}
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()){
				while(rst.next()) {
					if(ultima == null || !ultima.getNome().equals(rst.getString(2))) {
						Hospede hospede = new Hospede(rst.getString(2), rst.getString(3), 
								rst.getString(4), rst.getString(5), rst.getString(6), rst.getInt(7));
						hospede.setIdHospede(rst.getInt(1));
						ultima = hospede;
						hospedes.add(hospede);
					}
					Reserva reserva = new 
							Reserva(rst.getString(8), rst.getString(9), rst.getDouble(10), rst.getString(11));
					reserva.setId(rst.getInt(7));
					ultima.adicionarReserva(reserva);
				}
			}
			
			return hospedes;
		}
	}
	
	public void alterar(Integer id, String nome, String sobrenome, String dataDeNascimento, String nacionalidade, 
			String telefone) throws SQLException{
		
		String sql = "UPDATE HOSPEDES H SET H.NOME = ?, H.SOBRENOME = ?, H.DATA_NASCIMENTO = ?, "
				+ "H.NACIONALIDADE = ?, H.TELEFONE = ? WHERE ID = ?";
		
		try(PreparedStatement pstm = this.connection.prepareStatement(sql)){
			pstm.setString(1, nome);
			pstm.setString(2, sobrenome);
			pstm.setString(3, dataDeNascimento);
			pstm.setString(4, nacionalidade);
			pstm.setString(5, telefone);
			pstm.setInt(6, id);
			pstm.execute();
		}
	}
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
}