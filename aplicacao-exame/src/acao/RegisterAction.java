package acao;

import com.opensymphony.xwork2.ActionSupport;

import dao.ExameDAO;
import modelo.Exame;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	Exame exame;

	@Override
	public String execute() throws Exception {

		System.out.println("Exame: " + exame.getNomeExame());
		
		ExameDAO exameDAO = new ExameDAO();
		exameDAO.salvar(exame);
	
        return "success";
    }

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}	

}
