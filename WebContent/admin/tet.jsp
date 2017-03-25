<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Contactos</title>

        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/datatable/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/datatable/dataTables.jqueryui.min.css" rel="stylesheet" type="text/css"/>
		<link href="${pageContext.request.contextPath}/css/estilos.css" rel="stylesheet" type="text/css"/>
		
    </head>
    <body> 

        <div id="m_main">           

            <div id="m_body">
                <div id="container" style="margin:auto; width: 80%">
					<h1 class="titulo">Lista de Contactos</h1>
                    <div id="demo_jui">
                        <table id="example" class="display table-responsive" width="100%" cellspacing="0">
                             <thead>
                            <tr align="center">
                                <th>ID</th>
                                <th>Tên Đăng Nhập</th>
                                <th>Quyền</th>
                                
                                <th>Delete</th>
                                <th>Edit</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${userList}" var="user"> 
                        	<tr class="odd gradeX" align="center">
                                <td>${user.id_account}</td>
                                <td>${user.username}</td>
                                <td>
                                	${user.level ? "Admin" :"Member"}
                                </td>
                        
                                
                                <td class="center"><i class="fa fa-trash-o  fa-fw"></i><a href="deleteUser"> Delete</a></td>
                                <td class="center"><i class="fa fa-pencil fa-fw"></i> <a href="editUser">Edit</a></td>
                            </tr>
                        	</c:forEach>
                        </tbody>
                        </table>
                    </div>
                </div>
                <br/>
                <%-- para mensajes  --%>
                <div>${mensaje}</div>

            </div>
            <!--/div-->

        </div>

        <script src="${pageContext.request.contextPath}/js/jquery.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/datatable/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/datatable/dataTables.jqueryui.min.js" type="text/javascript"></script>
        
        <!--script src="../../datatableBstp/js/dataTables.bootstrap4.min.js" type="text/javascript"></script-->

        <script type="text/javascript">
            $(document).ready(function () {
                $('#example').dataTable({
                    "lengthMenu": [7, 10, 25, 50, 75, 100],
                    "language": {
                        "lengthMenu": 'Mostrar <select>' +
                                '<option value="7">7</option>' +
                                '<option value="10">10</option>' +
                                '<option value="25">25</option>' +
                                '<option value="50">50</option>' +
                                '<option value="75">75</option>' +
                                '<option value="100">100</option>' +
                                '<option value="-1">Todo</option>' +
                                '</select> registros ***** MANTENIMIENTO CONTACTOS *****',
                        "search": "Buscar:",
                        "info": "Mostrando pagina _PAGE_ de _PAGES_",
                        "paginate": {
                            "previous": "Atras",
                            "next": "Adelante"
                        }
                    }
                });
            });
        </script>
        <script>${modal}</script>
    </body>
</html>
