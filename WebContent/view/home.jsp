<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tìm kiếm</title>
 	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Home</title>

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

    <div class="container" >
    <div class="col-md-4 col-md-offset-4" align="center">
    <form>
    <div class="form-group">
    <table class="table">
    <thead>
      <tr>
        <th><input type="text" name="" placeholder="Nhập tên đề tài" required=""></th>
        <th><input type="checkbox" name=""></th>
      
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>
        	<select>
        		<option>Chọn lĩnh vực</option>
        	</select>
        </td>
        <td><input type="checkbox" name=""></td>
      
      </tr>
      <tr>
        <td>
        	<select>
        		<option>Chọn GVHD</option>
        	</select>
        </td>
        <td><input type="checkbox" name=""></td>
      
      </tr>
      <tr>
        <td>
        	<select>
        		<option>Chọn điểm</option>
        	</select>
        </td>
        <td><input type="checkbox" name=""></td>
      
      </tr>
       <tr>
        <td>
        	<select>
        		<option>Chọn cơ quan thực tập</option>
        	</select>
        </td>
        <td><input type="checkbox" name=""></td>
      
      </tr>
       <tr>
        <td>
        	<select>
        		<option>Chọn lớp</option>
        	</select>
        </td>
        <td><input type="checkbox" name=""></td>
      
      </tr>
      
      <tr>
        <td>
        	 <input type="submit" value="Tìm" class="btn btn-default">
        </td>
      
      
      </tr>
    </tbody>
  </table>
 
  </div>
  </form>
     </div>             
    </div>

           
      


    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/admin/bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/admin/bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/admin/dist/js/sb-admin-2.js"></script>

    <!-- DataTables JavaScript -->
         <script src="${pageContext.request.contextPath}/datatable/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/datatable/dataTables.jqueryui.min.js" type="text/javascript"></script>
		
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    
</body>

</html>
