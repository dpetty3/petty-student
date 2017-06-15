<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.*" import = "buslogic.*"  import ="servlets.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction History</title>
</head>
<body bgcolor = "gray">

<div><img src="http://www.speakerboxpr.com/wp-content/uploads/2016/10/Revature_CMYK.jpg" 
alt="HTML5 Icon" style="width:140px;height:100px;"></div>

<div><h1> Have a great day <%session.getAttribute("fname"); %>></h1></div>
<% ArrayList<Customer> customerList = new ArrayList<Customer>(); 
customerList = (ArrayList<Customer>)session.getAttribute("list"); %>

<div align = "center">
<table border = '2'>
	
	<tr><td colspan = "2" bgcolor = "orange"><h4 align = "center"> Your current balance is :</h4></tr></td>
	<tr><td colspan = "2" bgcolor = "orange"><h4 align = "center"><%= session.getAttribute("bal") %></h4></tr></td>
	<br>
	<tr><td colspan = "2" bgcolor = "orange"><h4 align = "left"> Your previous transactions :</h4></tr></td>
	<tr><td colspan = "2" bgcolor = "orange"><h4 align = "left"><%= %></h4></tr></td>
	
</table>
</form>
</div>
</body>
</html>