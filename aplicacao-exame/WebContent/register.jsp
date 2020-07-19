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