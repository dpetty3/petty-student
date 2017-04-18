<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.*" import = "java.io.*" import = "bizlogic.*" import= "Servlets.*" 
    import = "com.bursar.business.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bursar Operations</title>
</head>
<body>

<% Employee emp = (Employee)session.getAttribute("emp"); %>
<div><h1>Welcome <%= emp.getFname()%></h1></div>

<h5> Reimbursement:</h5> 
<button type = "button" onclick = "hide1();"> Hide</button>
<button type = "button" onclick = "show1();"> Show</button>

<div id = "reimbSel">
<form action = "ReimbSubmit" method = "post" enctype="multipart/form-data">
  Expense Type:<br>
  <input type="text" name="expType"><br>
  Expense Amount:<br>
  <input type="text" name="expAmt"><br>
  Date of Receipt:<br>
  <input type="date" name="expDate"><br>
  Receipt File:<br>
  <input type="file" name="receipt"/><br>
  <br>
  <input type = "submit" value = "Submit"/>
</form></div>
<!-- toggle -->

<script>
function hide1() {
    document.getElementById("reimbSel").style.display = "none";
}
function show1() {
    document.getElementById("reimbSel").style.display = "block";
}
</script>

<h5> View Reimbursement staging:</h5>
<button type = "button" onclick= "hide2()"> Hide</button>
<button type = "button" onclick = "show2()"> Show</button>

<div id = "pendTab">
<table border = '3'>
<tr><td colspan = '1'>Pending </td> <td colspan = '1'> Denied</td> <td> Approved</td></tr>
</table></div>

<script>
function hide2() {
    document.getElementById("pendTab").style.display = "none";
}
function show2() {
    document.getElementById("pendTab").style.display = "block";
}
</script>

<br>
<br>

</body>
</html>