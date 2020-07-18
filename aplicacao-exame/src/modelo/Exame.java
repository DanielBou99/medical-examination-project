package modelo;

public class Exame {
	
	String nomeExame;
	
	public Exame() {
		
	}

	public Exame(String nomeExame) {
		super();
		this.nomeExame = nomeExame;
	}

	public String getNomeExame() {
		return nomeExame;
	}

	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}
}
