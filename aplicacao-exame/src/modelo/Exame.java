package modelo;

public class Exame {
	
	Integer id;
	String nomeExame;
	
	public Exame() {
		
	}

	public Exame(String nomeExame) {
		super();
		this.nomeExame = nomeExame;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeExame() {
		return nomeExame;
	}

	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}

	@Override
	public String toString() {
		return "Exame [id=" + id + ", nomeExame=" + nomeExame + "]";
	}
	
}
