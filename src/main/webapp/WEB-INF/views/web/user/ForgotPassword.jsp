<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:url value="/quen-mat-khau" var="forgetPassword" />
	<div class="container-fluid col-md-8 col-xs-12">
	    <h1 class="mt-4">Quên mật khẩu</h1>
	    <div class="card mb-4">
			<c:if test="${not empty message}">${message}</c:if>
	        <div class="card-body">
	            <div class="col-md-8">
	                <form action="${forgetPassword}" method="POST" accept-charset="utf-8", model = "request">
	                    <div class="form-group">
	                        <label class="control-label">Email:</label>
	                        <input class="form-control" type="text" name="email"/>
	                    </div>
	            
	                    <button type="submit">Khôi phục mật khẩu</button>
	                </form>
	
	            </div>
	        </div>
	    </div>
	</div>
</body>
</html>