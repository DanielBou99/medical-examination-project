<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Exames</title>
<s:head/>
</head>
<body>

	<h2>Lista de Exames</h2>

		<table border="1" width="300">
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
	
</body>
</html>