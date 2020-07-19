package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import factory.DBUtil;
import modelo.Exame;

public class ExameDAO {
	
	public ExameDAO() {
		
	}
	
	public static int salvar(Exame exame) {

		int status = 0;

		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("insert into exame (nomeExame) values (?)");
			ps.setString(1, exame.getNomeExame());
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static List<Exame> pegarTodosExames() {
		List<Exame> listaExames = new ArrayList<Exame>();
		
		try {
			Connection conn = DBUtil.getConnection();
			Statement st= conn.createStatement();
			ResultSet rs= st.executeQuery("select * from exame");
			
			while(rs.next()) {
				Exame exame = new Exame(rs.getString("nomeExame"));
				exame.setId(rs.getInt("idExame"));
				
				listaExames.add(exame);
			}
			DBUtil.closeConnection(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return listaExames;
	}
	
	public static Exame pegarExamePeloId(String exameId) {
		Exame exame = null;
		
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("select * from exame where idExame = ?");
			ps.setString(1, exameId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				exame = new Exame(rs.getInt("idExame"), rs.getString("nomeExame"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return exame;
	}
	
	public static int atualizarExame(Exame exame) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("update exame set nomeExame=? WHERE idExame=?");
			ps.setString(1, exame.getNomeExame());
			ps.setInt(2, exame.getId());
			status = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

}
