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
    <title>Thông tin tài khoản</title>

		

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
                    <div class="col-lg-12">
                        
                    </div>
         
                        <h1 class="page-header">Cập nhật
                            <small>Thông tin</small>
                        </h1>
                    </div>
                    <!-- /.col-lg-12 -->
                    <div class="col-md-8" style="padding-bottom:120px">
                        <form action="updateInfo" class="col-md-8" method="POST">
                            <div class="form-group">
                            	<input type="hidden" name ="id" value="${use.id_account}" />
                            	<p>${stat}</p>
                                <label>Username</label>
                                <input class="form-control" name="txtUser" value="${use.username}" disabled />
                            </div>
                          
                             <div class="form-group">
                                <label>Họ tên</label>
                                <input  class="form-control" name="txtName" value="${use.fullname}" placeholder="Please Enter Full name" />
                            </div>
                          	 <div class="form-group">
                                <label>Mật khẩu</label>
                                <input type="password" id="txtPass" class="form-control" name="txtPass" onkeyup="checkPasswordLenght();" placeholder="Please Enter Password" />
                                <p id="divCheckPasswordLenght" class="divCheckPasswordLenght"></p>
                            </div>
                            <div class="form-group">
                                <label>Nhập lại mật khẩu</label>
                                <input type="password" id="txtRePass" class="form-control" name="txtRePass" onkeyup="checkPasswordMatch();" placeholder="Please Enter RePassword" />
                                 <p id="divCheckPasswordMatch" class="divCheckPasswordMatch"></p>
                            </div>
                             
                             <div class="form-group">
                                <label>Điện thoại</label>
                                <input type="tel" class="form-control" name="txtPhone" value="${use.phone}" placeholder="Please Enter phone" />
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input type="email" id="email" class="form-control" name="txtEmail" value="${use.email}" placeholder="Please Enter Email" />
                                <p id="statusmail" class="statusmail"></p>
                            </div>
                            
                                
                                    <input name="rdoLevel" value="0"  type="hidden">
                                
                                   
                            <div class="form-group">
                            <button type="submit" class="btn btn-default">Cập nhật</button>
                            <a href="${pageContext.request.contextPath}/homeLogin">Cancel</a>
                            </div>
                        <form>
                        
                        
                        
                           
                                   
                            
                            
                        
                    </div>
                      <div class="col-lg-7" style="padding-bottom:120px">
                        
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
    <script src="jquery.js" type="text/javascript"></script>
      <script type="text/javascript">
          $(document).ready(function(){
              $("#email").change(function(){
                  var txtEmail = $(this).val();
                  if(txtEmail.length >= 3){
                      $("#statusmail").html("<img src='img/ajax-loader.gif'><font color=gray> Checking availability...</font>");
                       $.ajax({
                          type: "POST",
                          url: "checkEmail",
                          data: "txtEmail="+ txtEmail,
                          success: function(msg){

                              $("#statusmail").ajaxComplete(function(event, request, settings){
                                   
                            	  if( msg == "")
                            		  {
                            		  $("#statusmail").html("").css("color","green");
                            		  }
                            	  else
                            		  {
                            		  	$("#statusmail").html(msg);
                            		  }
                                  

                              });
                          }
                      }); 
                  }
                  else{
                       
                      $("#statusmail").html("<font color=red>Tài khoản phải >= <b>9</b> ký tự</font>");
                  }
                  
              });
          });
        </script>
        
        
        
       <script type="text/javascript">
			function checkPasswordMatch() {
    			var password = $("#txtPass").val();
    			var confirmPassword = $("#txtRePass").val();

    			if (password != confirmPassword)
        			$("#divCheckPasswordMatch").html("Mật khẩu không đúng!").css("color","red");
    			else
        			$("#divCheckPasswordMatch").html("").css("color","green");
				}
		</script>
		
		<script type="text/javascript">
			function checkPasswordLenght() {
    			var password = $("#txtPass").val();

    			if (password.length<=6)
        			$("#divCheckPasswordLenght").html("Mật khẩu phải dài hơn 6 ký tự!").css("color","red");
    			else
        			$("#divCheckPasswordLenght").html("").css("color","green");
				}
		</script>
       
       <script type="text/javascript">
			function checkAll() {
				var userhtml = $(".status").text();
	       		var mailhtml = $(".statusmail").text();
	       		var passlength = $(".divCheckPasswordLenght").text();
	       		var passmatch = $( ".divCheckPasswordMatch").text();
	       		if(passlength ==""  && passmatch == "")
	       		{
	       			return true;
	       		}
	       		else{
	       			return false;
	       		}
	       		
	       				
			}
		</script>
		
		<jsp:include page="_footer.jsp"></jsp:include>
		
</body>

</html>
