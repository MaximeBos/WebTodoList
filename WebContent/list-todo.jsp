<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Web ToDo Tracker</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<!-- ${TODO_LIST}-->
<div id="wrapper">
	<div id="header">
		<h2>ToDo List</h2>
	</div>
</div>
<div id="container">
	<div id="content">
	
		<form action="AddToDoServlet" method="get">
			<input type="submit" value="Add ToDo"/>
		</form>
		
			
	<table>
		<tr>
			<th>Description </th>
		</tr>
		<c:forEach var="tempToDo" items="${TODO_LIST }" >
		
		<c:url var="EditLink" value= "EditToDoServlet">
		<c:param name="todoId" value="${tempToDo.id}"/>
		</c:url>
		<c:url var="DeleteLink" value= "DeleteToDoServlet">
		<c:param name="todoId" value="${tempToDo.id}"/>
		</c:url>
			<tr>
				<td> ${tempToDo.description}</td>
				<td> <a href="${EditLink }"> Edit</a>>|<a href="${DeleteLink }">Delete</a></td>
		</c:forEach>
	</table>
	
	<form action="InstructorLogServlet" method="get">
			<input type="submit" value="Back"/>
		</form>
		
</div>
</div>
</body>
</html>