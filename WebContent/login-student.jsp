<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
                                
		<title>Login Page Student</title>
		<link type="text/css" rel="stylesheet" href="css/login.css">
	</head>

	<body>
		<form action="StudentLogServlet" method="post">

			Please enter your Login 		
			<input type="text" name="login"/><br>
		
			Please enter your password
			<input type="text" name="mdp"/>
			
			
			<input type="submit" value="submit">			
		
		</form>
		
			
	</body>
</html>
