<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:url value="quan-tri/nguoi-dung/chinh-sua" var="edit" />
	<div class="container-fluid col-md-8 col-xs-12">
	    <h1 class="mt-4">Chỉnh sửa</h1>
	    <ol class="breadcrumb mb-4">
	        <li class="breadcrumb-item"><a href="quan-tri/trang-chu">Trang chủ</a></li>
	        <li class="breadcrumb-item active">Chỉnh sửa</li>
	    </ol>
	    <div class="card mb-4">
	        <div class="card-header">
	            <a class="btn btn-success" href="quan-tri/danh-muc">Về danh sách</a>
	        </div>
			
	        <div class="card-body">
	            <div class="col-md-8">
	                <form action="${edit}" method="POST" accept-charset="utf-8", model = "user">
	                	<div class="form-group">
	                        <label class="control-label">Trạng thái:</label>
	                    </div>
	                    <div>
	                 		<input class="form-control" type="radio" name="status" value = "1" ${user.status == 1 ? 'checked' :''} />
	                 		Enable
	                 	</div>
	                 	<div>
	                 		<input class="form-control" type="radio" name="status" value = "0" ${user.status == 0 ? 'checked' :''} />
	                 		Disable
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