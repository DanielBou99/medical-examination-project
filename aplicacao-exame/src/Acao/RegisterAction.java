package Acao;

import com.opensymphony.xwork2.ActionSupport;

import Modelo.Exame;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	Exame exame;

	@Override
	public String execute() throws Exception {
		System.out.println("Exame: " + exame.getNomeExame());
        return "success";
    }

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}	

}
