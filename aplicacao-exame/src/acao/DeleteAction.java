package acao;

import com.opensymphony.xwork2.ActionSupport;

import dao.ExameDAO;

public class DeleteAction extends ActionSupport{

	String exameId;
	
	public String execute() {
		String status = "";
		
		int status2 = ExameDAO.deletarExame(exameId);
		if (status2 == 1) {
			status = "success";
		} else {
			status = "error";
		}
		return status;
	}

	public String getExameId() {
		return exameId;
	}
	public void setExameId(String exameId) {
		this.exameId = exameId;
	}
}
