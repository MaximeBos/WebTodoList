<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Web ToDo Tracker</title>
<link type="text/css" rel="stylesheet" href="css/style-eleve.css">
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
	
	
	<table>
		<tr>
			<th>Description </th>
		</tr>
		<c:forEach var="tempToDo" items="${TODO_LIST }" >

			<tr>
				<td> ${tempToDo.description}</td>
			</tr>

		</c:forEach>
	</table>
	<form action="StudentLogServlet" method="get">
			<input type="submit" value="Back"/>
	</form>
</div>
</div>
</body>
</html>