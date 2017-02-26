<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name ="";
String course ="";
String fee ="";
String year ="";
String curDate="";

name = request.getAttribute("NameRet").toString();
course = request.getAttribute("CourseRet").toString();
fee = request.getAttribute("FreRet").toString();
year = request.getAttribute("YearRet").toString();
curDate = request.getAttribute("CurDateRet").toString();       
%>
</body>
</html>