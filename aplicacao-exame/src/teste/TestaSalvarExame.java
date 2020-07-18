package teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import factory.DBUtil;

public class TestaSalvarExame {
	
	public static void main(String[] args) throws SQLException {

		Connection conn = DBUtil.getConnection();
		
		PreparedStatement ps= conn.prepareStatement("insert into exame (nomeExame) values (?)");
		ps.setString(1, "Deu certo2");
		ps.executeUpdate();
		
		conn.close();
		
	}
}
