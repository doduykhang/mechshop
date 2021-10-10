<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/quan-tri/danh-muc/tao-moi" var="createCategory" />
<div class="container-fluid col-md-8 col-xs-12">
    <h1 class="mt-4">Thêm danh mục</h1>
    <ol class="breadcrumb mb-4">
        <li class="breadcrumb-item"><a href="quan-tri/trang-chu">Trang chủ</a></li>
        <li class="breadcrumb-item active">Thêm danh mục</li>
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
                <form action="${createCategory}" method="POST" enctype="multipart/form-data" accept-charset="utf-8">
                    <div class="form-group">
                        <label class="control-label">Tên danh mục:</label>
                        <input class="form-control" type="text" name="name"/>
                        
                    </div>
                    <div class="form-group">
                        <label class="control-label">code:</label>
                        <input class="form-control" type="text" name="code"/>
                        
                    </div>
                    <div class="form-group">
                        <label class="control-label">Ảnh đại diện:</label>
                        <input class="form-control" type="file" name="image"/>
                        
                    </div>
                    
                    <button type="submit">Tạo</button>
                </form>

            </div>
        </div>
    </div>
</div>