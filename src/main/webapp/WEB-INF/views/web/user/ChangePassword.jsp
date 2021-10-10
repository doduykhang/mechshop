<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:url value="/mat-khau-moi" var="newPassword" />
	<div class="container-fluid col-md-8 col-xs-12">
	    <h1 class="mt-4">Mật khẩu mới</h1>
	    <div class="card mb-4">
			<c:forEach items = "${errorMessage}" var = "error">
		         <c:out value = "${error.message}"/><p>
		    </c:forEach>
	        <div class="card-body">
	            <div class="col-md-8">
	                <form action="${newPassword}" method="POST" accept-charset="utf-8", model = "request">
	                    <div class="form-group">
	                        <label class="control-label">Mật khẩu mới:</label>
	                        <input class="form-control" type="text" name="password"/>
	                    </div>
	            		<div class="form-group">
	                        <input class="form-control" type="hidden" name="validationToken" value="${jwt}">	                        
	                    </div>
	                    <button type="submit">Tạo</button>
	                </form>
	            </div>
	        </div>
	    </div>
	</div>
</body>
</html>