<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
	<thead>
		<th>id</th>
		<th>categorys</th>
	</thead>
	<tr>
		<td>1</td>
		<td>java</td>
		
		
	</tr>
	<c:forEach items="${cateList}" var="cate" >
          <tr>
             <td>${cate.idcate}</td>
             <td>${cate.catename}</td>
          </tr>
       </c:forEach>	
       
	</table>
	<form action="categoryList">
	<input type="submit">
	</form>
</body>
</html>