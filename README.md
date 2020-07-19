# medical-examination-project

<h3>Banco de Dados </h3>
<b>ExameDAO</b> <br />
1. Classe responsável por interagir com o Banco de Dados. <br />

```
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import factory.DBUtil;
import modelo.Exame;

public class ExameDAO {
	
	public ExameDAO() {
		
	}
	
	public static int salvar(Exame exame) {

		int status = 0;

		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("insert into exame (nomeExame) values (?)");
			ps.setString(1, exame.getNomeExame());
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static List<Exame> pegarTodosExames() {
		List<Exame> listaExames = new ArrayList<Exame>();
		
		try {
			Connection conn = DBUtil.getConnection();
			Statement st= conn.createStatement();
			ResultSet rs= st.executeQuery("select * from exame");
			
			while(rs.next()) {
				Exame exame = new Exame(rs.getString("nomeExame"));
				exame.setId(rs.getInt("idExame"));
				
				listaExames.add(exame);
			}
			DBUtil.closeConnection(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return listaExames;
	}
	
	public static Exame pegarExamePeloId(String exameId) {
		Exame exame = null;
		
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("select * from exame where idExame = ?");
			ps.setString(1, exameId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				exame = new Exame(rs.getInt("idExame"), rs.getString("nomeExame"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return exame;
	}
	
	public static int atualizarExame(Exame exame) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("update exame set nomeExame=? WHERE idExame=?");
			ps.setString(1, exame.getNomeExame());
			ps.setInt(2, exame.getId());
			status = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public static int deletarExame(String exameId) {
		int status = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("delete from exame where idExame = ?");
			ps.setString(1, exameId);
			status = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
```

<br /><br />
--------------------------------------------
<br /><br />

<h3>Classe Modelo </h3>
<b>Exame</b> <br />
1. Classe com os dados do Exame. <br />

```
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
	
	public Exame(Integer id, String nomeExame) {
		super();
		this.id = id;
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
```

<br /><br />
--------------------------------------------
<br /><br />

<h3>Cadastrar um novo Exame </h3>
<b>register.jsp</b> <br />
1. Página com o formulário para o usuário cadastrar. <br />
2. Envia requisição para a classe RegisterAction. <br />

```
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar</title>
<link rel="stylesheet" href="style.css">
<s:head/>
</head>
<body>
	<div align="center">

		<h2>Registrar Exame</h2>
		
		<a href="welcomeAction">
			<button class="actionBtn">Listar exames</button>
		</a>
		
		<s:form action="registerAction" class="formTable">
			<s:textfield name="exame.nomeExame" label="Exame" /> 
			
			<s:reset value="Reset" class="actionBtn"/>
			<s:submit value="Register" class="actionBtn"/>
		</s:form>
	
	</div>
</body>
</html>
```
<b>RegisterAction</b> <br />
1. Classe que recebe requisição da register.jsp. <br />
2. Consulta o banco de dados pela classe ExameDAO. <br />
3. Envia requisição para a classe WelcomeAction. <br />
```
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
```

<br /><br />
--------------------------------------------
<br /><br />

<h3>Listar os Exames</h3>
<b>WelcomeAction</b> <br />
1. Requisita as informações do Banco de Dados através da classe ExameDAO.<br />
2. Envia os dados para a página welcome.jsp. <br />

```
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
```

<b>welcome.jsp</b> <br />
1. Lista os dados recebidos pela classe WelcomeAction.<br />

```
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Exames</title>
<link rel="stylesheet" href="style.css">
<s:head/>
</head>
<body>

	<div align="center">
		<h2>Lista de Exames</h2>
		
		<a href="register.jsp">
			<button class="actionBtn">Adicionar novo exame</button>
		</a>

		<table width="750" class="productTable" align="center">
		
			<thead>  
				<tr>
					<th>Exame ID</th>
					<th>Exame Nome</th>
					<th>Exame Editar</th>
					<th>Exame Deletar</th>
				</tr>
			</thead>
	
			<s:iterator value="exames" var="exame">
				<tr>
					<td>
						<s:property value="#exame.id"/>
					</td>
					<td>
						<s:property value="#exame.nomeExame"/>
					</td>
					<td>
						<a
						href="updateDataAction?exameId=<s:property value="#exame.id"/>">
							<button class="actionBtn">Editar</button>
						</a> 
					</td>
					<td>
						<a href="deleteAction?exameId=<s:property value="#exame.id"/>">
							<button class="actionBtn">Deletar</button>
						</a>
					</td>
				</tr>
			</s:iterator>
		
		</table>
	</div>
	
</body>
</html>
```

<br /><br />
--------------------------------------------
<br /><br />

<h3>Editar os Exames</h3>
<b>UpdateDataAction</b> <br />
1. Classe recebe o id do exame à ser alterado pela página welcome.jsp. <br />
2. Consulta os dados do exame no Banco de Dados através da classe ExameDAO. <br />
3. Retorna a página updateExame.jsp para o usuário com os dados do Exame. <br />

```
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

```

<br /><br />
--------------------------------------------
<br /><br />

<b>updateExame.jsp</b> <br />
1. Classe recebe dados do Exame pela classe UpdateDataAction. <br />
2. Envia dados para a classe UpdateAction. <br />

```
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Exame</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div align="center">
		<h2>Editar Exame</h2>
		
		<a href="register.jsp">
			<button class="actionBtn">Adicionar novo exame</button>
		</a>
		<a href="welcomeAction">
			<button class="actionBtn">Listar exames</button>
		</a>
		
		<s:form action="updateAction">
			<s:textfield name="exameId" label="Exame ID" class="formTextField" readonly="true" style="background-color: #DCDCDC"/>
			<s:textfield name="nomeExame" label="Exame Nome" class="formTextField"/>
			
			<s:submit value="Editar" class="actionBtn"/>
		</s:form>
	</div>
	
</body>
</html>
```

<br /><br />
--------------------------------------------
<br /><br />

<b>UpdateAction</b> <br />
1. Classe recebe dados do Exame pela página updateExame.jsp. <br />
2. Realiza o update no Banco de Dados pela classe ExameDAO. <br />
3. Envia requisição para a classe WelcomeAction (Ela irá listar os Exames com dados atualizados). <br />

```
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
```


<br /><br />
--------------------------------------------
<br /><br />

<h3>Deletar Exame</h3>
<b>DeleteAction</b> <br />
1. Classe recebe ID pela página welcome.jsp. <br />
2. Realiza o DELETE no Banco de Dados através classe ExameDAO. <br />
3. Envia requisição para a classe WelcomeAction (Ela irá listar os Exames com dados atualizados). <br />

```
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

```
