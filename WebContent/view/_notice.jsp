<%@ page import="java.util.*" %>
<%@ page import="Object.Notice" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<style type="text/css">.alert-purple { 
border-color: #694D9F;  
background: #694D9F;    
color: #fff;
}
 
.alert-info-alt {   
border-color: #B4E1E4;  
background: #81c7e1;    
color: #fff;
}
 
.alert-danger-alt { 
border-color: #B63E5A;  
background: #E26868;    
color: #fff;
}
 
.alert-warning-alt {    
border-color: #F3F3EB;  
background: #E9CEAC;    
color: #fff;
}
 
.alert-success-alt {    
border-color: #19B99A;  
background: #20A286;    
color: #fff;
}
.glyphicon {    
margin-right:10px;
}
.alert a {  
color: yellow;
}</style>
    
<div class="container"> 
 <div class="row"> 

  <h2 class="text-center">Thông báo</h2> 
  	
  	<c:forEach items="${NotList}" var="noti">
  	<c:if test="${noti.status !=false}">
  		<div class="alert alert-info-alt alert-dismissable">  
    	 <strong>${noti.notice_info}</strong> 
   </div> 
  		
  		</c:if>
  		
  	</c:forEach>
  	
   
   
  </div> 
 </div>
</div>