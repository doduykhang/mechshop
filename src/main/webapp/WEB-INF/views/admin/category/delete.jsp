<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<c:url value="/quan-tri/danh-muc/xoa" var="deleteCategory" />
<div class="container-fluid col-md-10 col-xs-12">
    <h1 class="mt-4">Chỉnh sửa danh mục</h1>
    <ol class="breadcrumb mb-4">
        <li class="breadcrumb-item"><a href="/">Trang chủ</a></li>
        <li class="breadcrumb-item active">Chỉnh sửa danh mụ</li>
    </ol>
    <div class="card mb-4">
        <div class="card-header">
            <a class="btn btn-success" href="#">Về danh sách</a>
        </div>
		<c:if test="${not empty message}">${message}</c:if>
        <div class="card-body">
            <div class="col-md-8">
                <dl class="row">
                    <dt class="col-sm-4">
                        Ảnh đại diện:
                    </dt>
                    <dd class="col-sm-8">
                       	<img src="${category.imagePath}" alt="N/A" style="width: 70px; height: 70px; object-fit: cover;">
                    </dd>
                </dl>
                <form action="${deleteCategory}" method="POST" enctype="multipart/form-data" >
                    <div class="form-group">
                        <label class="control-label">Tên danh mục:</label>
                        <input class="form-control" type="text " name="name" value ="${category.name}"/>
                        <%-- <form:input path="productName" /> --%>
                    </div>
                    <div class="form-group">
                        <label class="control-label">code:</label>
                        <input class="form-control" type="text" name="code" value ="${category.categoryCode}"/>
                        <%-- <form:input path="description" /> --%>
                    </div>
                    <%-- <div class="form-group"> 	
                        <label class="control-label">Ảnh đại diện:</label>
                        <input class="form-control" type="file" name="image"/>
                        <form:input path="description" />
                    </div> --%>
                    <input type="hidden" name="id" value ="${category.id}"/>
                    <button type="submit">Xóa</button>
                </form>

            </div>
        </div>
    </div>
</div>