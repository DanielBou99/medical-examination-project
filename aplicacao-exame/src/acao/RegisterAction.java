package acao;

import com.opensymphony.xwork2.ActionSupport;

import dao.ExameDAO;
import modelo.Exame;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	Exame exame;

	@Override
	public String execute() throws Exception {

		System.out.println("Salvando exame: " + exame.getNomeExame());
		
		if (ExameDAO.salvar(exame) == 1) {
			return "success";
		}
		
        return "error";
    }

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}	

}
