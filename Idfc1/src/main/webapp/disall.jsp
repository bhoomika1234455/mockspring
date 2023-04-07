<%@page import="com.jsp.mock.dto.Empyoedto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border=2>
<tr>
     <th>id</th>
     <th>name</th>
     <th>pohone</th>
    

</tr>
<%List<Empyoedto> data=(List)request.getAttribute("key1"); 

for(Empyoedto empdto:data){
%>
       <tr>   <td><%= empdto.getId()%></td>
          <td><%=empdto.getName() %></td>
          <td><%=empdto.getPhone()%></td>
          
</tr>
<%} %>
</table>
</body>
</html>