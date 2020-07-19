package teste;

import java.sql.SQLException;
import java.util.List;

import dao.ExameDAO;
import modelo.Exame;

public class TestaListarExame {
	
	public static void main(String[] args) throws SQLException {

		List<Exame> lista = ExameDAO.pegarTodosExames();
		
		for (Exame exame : lista) {
			System.out.println(exame);
		}
	}
}
