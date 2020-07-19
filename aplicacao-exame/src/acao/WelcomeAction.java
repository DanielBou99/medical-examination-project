package acao;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.ExameDAO;
import modelo.Exame;

public class WelcomeAction extends ActionSupport{
	
	List<Exame> exames;
	
	public void initializeProducts() {
		exames = ExameDAO.pegarTodosExames();
	}
	
	public String execute() {
		initializeProducts();
		
		return "success";
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}
	
	
	
}
