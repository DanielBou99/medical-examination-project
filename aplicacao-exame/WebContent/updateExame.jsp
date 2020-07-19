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