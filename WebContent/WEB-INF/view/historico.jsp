<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Import da taglib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${lista}" var="mov">
		<div>
			<p>${mov.data} Movimentaçao de ${mov.descricao } no valor de ${mov.valor }</p>
		</div>
	</c:forEach>
</body>
</html>