package com;

import dao.ExameDAO;
import modelo.Exame;

public class DemoClass {
	public String func(String a) {
		
		Exame exame = ExameDAO.pegarExamePeloId(a);
		
		return exame.getNomeExame();
	}
}
