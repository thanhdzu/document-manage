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
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="homeLogin">Trang chủ</a>
            </div>
            <!-- /.navbar-header -->
			<c:if test="${loginuser != null }">
            <ul class="nav navbar-top-links navbar-right">
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="infoUser?idacc=${loginuser.id_account}"> Thông tin tài khoản</a>
                        </li>
                        <%
                        	UserAccount user = new UserAccount();
                        	UserAccount use = null;
                        	use = (UserAccount)session.getAttribute("loginuser");
                        	String s = "<li>"+ "<a href"+"="+"'documentList'" +">"+
								
								" Quản lý "+"</a>" +"</li>";
                        	if(use.isLevel())
                        	{
                        		out.print(s);
                                       
                        	}
                        	
                        %>
                       
                        <li><a href="docUser?idacc=${loginuser.id_account}"> Tài liệu đăng ký mượn</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="logout"><i class="fa fa-sign-out fa-fw"></i> Đăng xuất</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            </c:if>
         
            <!-- /.navbar-top-links -->

            
        </nav>

        <!-- Page Content -->
    
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        
                    </div>
                    <!-- /.col-lg-12 -->
                    <form class="form-group" action="orderDocument" method="post" >
                    <table class="table table-striped table-bordered table-hover" id="usertable">
                        <thead>
                            <tr align="center">
                                <th>Mượn</th>
                                <th>Tên Tài Liệu</th>
                                <th>Lĩnh vực</th>
                                <th>Giáo viên HD</th>
                                <th>Điểm</th>
                                <th>Sinh Viên</th>
                                <th>Cơ quan TT</th>
                                <th>Lớp</th>
                                <th>Trạng thái</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${docList}" var="doc"> 
                        	<c:if test="${doc.status!=0}">
        						
    						
                        	<tr class="odd gradeX" align="center">
                        		<td><input type="checkbox" value="${doc.id_document}" ${doc.status==2?'disabled' : '' }  name="ckOrder"></td>
                              	
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
                                <td>
                                	<c:if test="${doc.status == 1}">
                                		<p>Đang có</p>
                                	</c:if>
                                	<c:if test="${doc.status == 2}">
                                		<p>Đã được mượn</p>
                                	</c:if>
                                </td>
                            
                            </tr>
                            </c:if>
                        	</c:forEach>
                        </tbody>
                    </table>
                    <div class="form=group" align="center">  <button type="submit" class="btn btn-default">Mượn</button></div>
                   
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
 

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
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

</body>

</html>
