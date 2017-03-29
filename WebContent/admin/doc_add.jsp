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

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        
                        
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Xử lý Mượn - Trả<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${pageContext.request.contextPath}/orderList">Chờ duyệt</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/acceptOrderList">Nhận lại</a>
                                </li>
                                 <li>
                                    <a href="${pageContext.request.contextPath}/recieveList">Đã nhận lại</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Tài liệu<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${pageContext.request.contextPath}/documentList">Danh sách tài liệu</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/addDocument">Thêm tài liệu</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-cube fa-fw"></i> Tài khoản<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${pageContext.request.contextPath}/userList">Danh sách tài khoản</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/createAccount">Thêm tài khoản</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-users fa-fw"></i> Lĩnh vực<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${pageContext.request.contextPath}/categoryList">Danh sách lĩnh vực</a>
                                </li>
                               
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                          <li>
                            <a href="#"><i class="fa fa-users fa-fw"></i> Giáo viên hướng dẫn<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${pageContext.request.contextPath}/teacherList">Danh sách giáo viên</a>
                                </li>
                               
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                          <li>
                            <a href="#"><i class="fa fa-users fa-fw"></i> Cơ quan thực tập<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${pageContext.request.contextPath}/businessList">Danh sách cơ quan</a>
                                </li>
                               
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                          <li>
                            <a href="#"><i class="fa fa-users fa-fw"></i> Lớp<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${pageContext.request.contextPath}/classList">Danh sách lớp</a>
                                </li>
                               
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">User
                            <small>Add</small>
                        </h1>
                    </div>
                    <!-- /.col-lg-12 -->
                    <div class="col-lg-7" style="padding-bottom:120px">
                        <form action="doAddDocument" method="POST">
                        	 <div class="form-group">
                                <label>${stat}</label>
                                
                            </div>
                            <div class="form-group">
                                <label>Tên tài liệu</label>
                                <input class="form-control" name="txtDoc" placeholder="Please Enter Document" required="required"/>
                            </div>
                            <div class="form-group">
                                <label>Lĩnh vực</label>
                                <select name ="selCat" class="form-control">
                                	<c:forEach items="${CatList}" var="cat">
                                		<option value="${cat.idcate}">${cat.catename}</option>
                                	</c:forEach>
                                </select>
                            </div>
                             <div class="form-group">
                                <label>Giáo viên hướng dẫn</label>
                                <select name ="selTea" class="form-control">
                                	<c:forEach items="${TeaList}" var="tea">
                                		<option value="${tea.id_teacher}">${tea.teacher_name}</option>
                                	</c:forEach>
                                </select>
                            </div>
                             <div class="form-group">
                                <label>Điểm</label>
                                <input type="number" name="txtPoint" class="form-control" step="0.1" min="0" max ="10" />
                            </div>
                            
                             <div class="form-group">
                                <label>Sinh viên</label>
                                <input type="text" class="form-control" name="txtStu" placeholder="Please Enter Student" required="required"/>
                            </div>
                            <div class="form-group">
                                <label>Cơ quan thực tập</label>
                                	<select name ="selBus" class="form-control">
                                	<c:forEach items="${BusList}" var="bus">
                                		<option value="${bus.id_business}">${bus.business_name}</option>
                                	</c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Lớp</label>
                                	<select name ="selCla" class="form-control">
                                	<c:forEach items="${ClaList}" var="cla">
                                		<option value="${cla.id_class}">${cla.class_name}</option>
                                	</c:forEach>
                                	</select>
                            </div>
                            <input type="hidden" name="stat" value="1">
                            <button type="submit" class="btn btn-default">Thêm</button>
                            <button type="reset" class="btn btn-default">Làm lại</button>
                        <form>
                    </div>
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

    <!-- DataTables JavaScript -->
    <script src="${pageContext.request.contextPath}/admin/bower_components/DataTables/media/js/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>
</body>

</html>
