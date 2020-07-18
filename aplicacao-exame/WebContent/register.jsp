<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar</title>
<s:head/>
</head>
<body>

	<h2>Registrar Exame</h2>
	
	<s:form action="registerAction">
		<s:textfield name="exame.nomeExame" label="Exame" /> 
		
		<s:reset value="Reset" />
		<s:submit value="Register"  />
	</s:form>
	
</body>
</html>