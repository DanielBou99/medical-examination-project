package acao;

import com.opensymphony.xwork2.ActionSupport;

import dao.ExameDAO;
import modelo.Exame;

public class UpdateDataAction extends ActionSupport{

	String exameId;
	String nomeExame;
	Exame exame;
	
	public String execute() {
		Exame exame = ExameDAO.pegarExamePeloId(exameId);
		nomeExame = exame.getNomeExame();
		
		return "success";
	}

	public String getExameId() {
		return exameId;
	}

	public void setExameId(String exameId) {
		this.exameId = exameId;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}
	
	public String getNomeExame() {
		return nomeExame;
	}
	
	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}
}
