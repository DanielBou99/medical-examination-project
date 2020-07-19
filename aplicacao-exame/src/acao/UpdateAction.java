package acao;

import com.opensymphony.xwork2.ActionSupport;

import dao.ExameDAO;
import modelo.Exame;

public class UpdateAction extends ActionSupport{

	String exameId;
	String nomeExame;
	
	public String execute() {
		String status = "";
		Exame exame = new Exame(Integer.parseInt(exameId), nomeExame);
		int status2 = ExameDAO.atualizarExame(exame);
		if (status2 == 1) {
			status = "success";
		} else {
			status = "error";
		}
		System.out.println(status);
		return status;
	}

	public String getExameId() {
		return exameId;
	}

	public void setExameId(String exameId) {
		this.exameId = exameId;
	}

	public String getNomeExame() {
		return nomeExame;
	}

	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}

}
