<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
 	<%
		session = request.getSession();
		String name = (String)session.getAttribute("name");
		int accno = (int)session.getAttribute("accno");
		out.println("<h3>Welcome "+name+"</br>");
		out.println("Account number : "+accno);
		out.println("</h3>");
	%>
	<br>
	<a href="/BankApplication/balance.html">View Balance</a><br>
	<a href="/BankApplication/loan.html">Apply Loan</a><br>
	<a href="/BankApplication/transfer.html">Transfer Money</a><br>
	<a href="/BankApplication/changepwd.html">Change Password</a><br>
	<a href="/BankApplication/changename.html">Change Name</a><br>
	<a href="/BankApplication/logout.jsp">Logout</a><br>
</body>
</html>