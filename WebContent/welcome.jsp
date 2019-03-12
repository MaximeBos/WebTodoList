<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Welcome</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="wrapper">
	<div id="header">
		<h2>Portail</h2>
		<h3>Bienvenue</h3>
	</div>
</div>
<div id="container">
	<div id="content">
	<form action="InstructorLogServlet" method="get">
	<input type="submit" value="Instructor"/><br/>
	</form>
	<form action="StudentLogServlet" method="get">
	<input type="submit" value="Student"/>
	</form>
	
</div>
</div>
</body>
</html>