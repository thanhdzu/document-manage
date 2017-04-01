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
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Cập nhật
                            <small>tài liệu</small>
                        </h1>
                    </div>
                    <!-- /.col-lg-12 -->
                    <div class="col-lg-7" style="padding-bottom:120px">
                        <form action="doEditDocument" method="POST">
                            <div class="form-group">
                                <label>${stat}</label>
                                <input type="hidden" value="${Document.id_document }" name="id">
                            </div>
                            <div class="form-group">
                                <label>Tên tài liệu</label>
                                <input class="form-control" name="txtDoc" value="${Document.document_name}" placeholder="Please Enter Document" required="required"/>
                            </div>
                            <div class="form-group">
                                <label>Lĩnh vực</label>
                                <select name ="selCat" class="form-control">
                                	<c:forEach items="${CatList}" var="cat">
                                		<option  value="${cat.idcate}" ${cat.idcate == Document.idcate?'selected' : ''}>${cat.catename}</option>
                                	</c:forEach>
                                </select>
                            </div>
                             <div class="form-group">
                                <label>Giáo viên hướng dẫn</label>
                                <select name ="selTea" class="form-control">
                                	<c:forEach items="${TeaList}" var="tea">
                                		<option value="${tea.id_teacher}" ${tea.id_teacher==Document.id_teacher?'selected' : ''}>${tea.teacher_name}</option>
                                	</c:forEach>
                                </select>
                            </div>
                             <div class="form-group">
                                <label>Điểm</label>
                                <input type="number" name="txtPoint" value="${Document.point}" class="form-control" step="0.1" min="0" max ="10" required="required"/>
                            </div>
                            
                             <div class="form-group">
                                <label>Sinh viên</label>
                                <input  class="form-control" name="txtStu" value="${Document.student }" placeholder="Please Enter Student" required="required"/>
                            </div>
                            <div class="form-group">
                                <label>Cơ quan thực tập</label>
                                	<select name ="selBus" class="form-control">
                                	<c:forEach items="${BusList}" var="bus">
                                		<option value="${bus.id_business}" ${bus.id_business==Document.id_business?'selected' : ''}>${bus.business_name}</option>
                                	</c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Lớp</label>
                                	<select name ="selCla" class="form-control">
                                	<c:forEach items="${ClaList}" var="cla">
                                		<option value="${cla.id_class}" ${cla.id_class==Document.id_class?'selected' : ''}>${cla.class_name}</option>
                                	</c:forEach>
                                	</select>
                            </div>
                            <div class="form-group">
                                <label>Trạng thái</label>
                                <label class="radio-inline">
                                    <input name="rdoStat" value="0" ${Document.status==0?'checked':''}   type="radio">Ẩn
                                </label>
                                <label class="radio-inline">
                                    <input name="rdoStat" value="1" ${Document.status==1?'checked':''}   type="radio">Đang có
                                </label>
                                <label class="radio-inline">
                                    <input name="rdoStat" value="2" ${Document.status==2?'checked':''}   type="radio">Đã được mượn
                                </label>
                            </div>
                            <button type="submit" class="btn btn-default">Cập nhật</button>
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
