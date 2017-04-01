<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page import="Object.UserAccount" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Admin</title>

		

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/admin/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${pageContext.request.contextPath}/admin/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/admin/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/admin/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    
	<link href="${pageContext.request.contextPath}/datatable/jquery-ui.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/datatable/dataTables.jqueryui.min.css" rel="stylesheet" type="text/css"/>
   
</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <jsp:include page="_menu.jsp"></jsp:include>

        <!-- Page Content -->
    
            <div class="container-fluid">
                <div class="row">
                <h2 class="text-center">Tài liệu đã chọn</h2> 
                    <div class="col-lg-12">
                        
                    </div>
                    <!-- /.col-lg-12 -->
                    <form class="form-group" action="doOrderDocument" method="post">
                    <table class="table table-striped table-bordered table-hover" id="usertable">
                        <thead>
                            <tr align="center">
                                
                                <th>Tên Tài Liệu</th>
                                <th>Lĩnh vực</th>
                                <th>Giáo viên HD</th>
                                <th>Điểm</th>
                                <th>Sinh Viên</th>
                                <th>Cơ quan TT</th>
                                <th>Lớp</th>
                              
                                
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${docList}" var="doc"> 
                        <input type="hidden"  name ="id" value="${doc.id_document}"/>
                        	<c:if test="${doc.status!=0}">
        						
    						
                        	<tr class="odd gradeX" align="center">
                        		
                              	
                                <td>${doc.document_name}</td>
                                <td>
                              		<c:forEach var="cat" items='${CatList}' >
  									<c:if test="${doc.idcate == cat.idcate}">
    								
      								
      									<p><c:out value="${cat.catename}"></c:out></p>
      								
    								
  									</c:if>
									</c:forEach>
                              	</td>
                              	  <td>
                              		<c:forEach var="tea" items='${TeaList}'>
  									<c:if test="${doc.id_teacher == tea.id_teacher}">
    								
      								
      									<p><c:out value="${tea.teacher_name}"></c:out></p>
      								
    								
  									</c:if>
									</c:forEach>
                              	</td>
                              	<td>${doc.point}</td>
                                <td>
                                	${doc.student}
                                </td>
                        			  <td>
                              		<c:forEach var="bus" items='${BusList}'>
  									<c:if test="${doc.id_business == bus.id_business}">
    								
      								
      									<p><c:out value="${bus.business_name}"></c:out></p>
      								
    								
  									</c:if>
									</c:forEach>
                              	</td>
                                	  <td>
                              		<c:forEach var="cla" items='${ClaList}'>
  									<c:if test="${doc.id_class == cla.id_class}">
    								
      								
      									<p><c:out value="${cla.class_name}"></c:out></p>
      								
    								
  									</c:if>
									</c:forEach>
                              	</td>
                             
                            
                            </tr>
                            </c:if>
                        	</c:forEach>
                        </tbody>
                    </table>
                    <label>Chọn thời gian nhận</label>
                    <input type="text" id="datepick" name="dtp" required="required">
                    <div class="form=group" align="center">  <button type="submit" class="btn btn-default">Xác nhận</button>
                    										
                    </div>
                   
                    </form>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/admin/bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/admin/bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/admin/dist/js/sb-admin-2.js"></script>

     
        <script src="${pageContext.request.contextPath}/datatable/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/datatable/dataTables.jqueryui.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
 	
 	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/datetimepicker/jquery.datetimepicker.css"/ >
	<script src="${pageContext.request.contextPath}/datetimepicker/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/datetimepicker/build/jquery.datetimepicker.full.min.js"></script>
 	
	<script type="text/javascript">
	  $(document).ready(function () {
		  jQuery('#datepick').datetimepicker({
			  format:'Y-m-d H:i:s',
			  startDate:'+1971/05/01',//or 1986/12/08
			  lang:'vie'
			});
      });
	</script>
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <!--  
    <script type="text/javascript">
            $(document).ready(function () {
                $('#usertable').dataTable({
                    "lengthMenu": [10, 25, 50, 75, 100],
                    "language": {
                        "lengthMenu": 'Số lượng <select>' +
                                
                                '<option value="10">10</option>' +
                                '<option value="25">25</option>' +
                                '<option value="50">50</option>' +
                                '<option value="75">75</option>' +
                                '<option value="100">100</option>' +
                                '<option value="-1">Todo</option>' +
                                '</select> ',
                        "search": "Tìm kiếm:",
                        "info": "Page _PAGE_ of _PAGES_",
                        "paginate": {
                            "previous": "<< ",
                            "next": " >>"
                        }
                    }
                });
            });
        </script>
	-->
	<jsp:include page="_footer.jsp"></jsp:include>
</body>

</html>
