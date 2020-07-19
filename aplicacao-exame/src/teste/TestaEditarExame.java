package teste;

import java.sql.SQLException;
import java.util.List;

import dao.ExameDAO;
import modelo.Exame;

public class TestaEditarExame {
	
	public static void main(String[] args) throws SQLException {

		Exame exame = ExameDAO.pegarExamePeloId("1");
		exame.setNomeExame("Nome do exame atualizado");
		ExameDAO.atualizarExame(exame);
		
		List<Exame> exames = ExameDAO.pegarTodosExames();
		
		for (Exame exame2 : exames) {
			System.out.println(exame2);
		}
	}
}
