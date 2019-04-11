<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<h1>Registration Form</h1>
<form action="insertData" method="post">
<pre>
Id    : <input type="text" name="eid"/>
Name  : <input type="text" name="ename"/>
Email : <input type="text" name="email"/>
Salary: <input type="text" name="esal"/>
<input type="submit" value="Insert"/>
</pre>
</form>
${msg}
</body>
</html>