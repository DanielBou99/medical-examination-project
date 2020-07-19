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