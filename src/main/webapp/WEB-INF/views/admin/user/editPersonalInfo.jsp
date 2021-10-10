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
	<c:url value="quan-tri/nguoi-dung/chinh-sua-thong-tin-ca-nhan" var="editInfo" />
	<div class="container-fluid col-md-8 col-xs-12">
	    <h1 class="mt-4">Sửa thông tin cá nhân</h1>
	    <ol class="breadcrumb mb-4">
	        <li class="breadcrumb-item"><a href="quan-tri/trang-chu">Trang chủ</a></li>
	        <li class="breadcrumb-item active">Sửa thông tin cá nhân</li>
	    </ol>
	    <div class="card mb-4">
	        <div class="card-header">
	            <a class="btn btn-success" href="quan-tri/danh-muc">Về danh sách</a>
	        </div>
			<c:forEach items = "${errorMessage}" var = "error">
		         <c:out value = "${error.message}"/><p>
		    </c:forEach>
	        <div class="card-body">
	            <div class="col-md-8">
	                <form action="${editInfo}" method="POST" accept-charset="utf-8", model = "user">
	                	<div class="form-group">
	                        <label class="control-label">Họ và tên:</label>
	                        <input class="form-control" type="text" name="fullName" value="${user.fullName}"/>
	                    </div>
	                    <div class="form-group">
	                        <label class="control-label">Tên đăng nhập:</label>
	                        <input class="form-control" type="text" name="userName" value="${user.userName}"/>
	                    </div>
	                    <div class="form-group">
	                        <label class="control-label">Mật khẩu:</label>
	                        <input class="form-control" type="text" name="password" value="${user.password}"/>
	                    </div>
	                    <div class="form-group">
	                        <label class="control-label">Email:</label>
	                        <input class="form-control" type="text" name="email" value="${user.email}"/>
	                    </div>
	            		<div class="form-group">
	                        <input class="form-control" type="hidden" name="id" value="${user.id}">	                        
	                    </div>
	                    <button type="submit">Sửa</button>
	                </form>
	            </div>
	        </div>
	    </div>
	</div>
</body>
</html>