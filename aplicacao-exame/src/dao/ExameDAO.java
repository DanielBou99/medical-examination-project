package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import factory.DBUtil;
import modelo.Exame;

public class ExameDAO {
	
	public ExameDAO() {
		
	}
	
	public void salvar(Exame exame) throws SQLException {

		Connection conn = DBUtil.getConnection();
		
		PreparedStatement ps= conn.prepareStatement("insert into exame (nomeExame) values (?)");
		ps.setString(1, exame.getNomeExame());
		ps.executeUpdate();
		
		conn.close();
	}

}
