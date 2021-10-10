<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/san-pham/tao-moi" var="createProduct" />
<div class="container-fluid col-md-8 col-xs-12">
    <h1 class="mt-4">Them san pham</h1>
    <ol class="breadcrumb mb-4">
        <li class="breadcrumb-item"><a href="/">Trang chủ</a></li>
        <li class="breadcrumb-item active">Them san pham</li>
    </ol>
    <div class="card mb-4">
        <div class="card-header">
            <a class="btn btn-success" href="#">Về danh sách</a>
        </div>

        <div class="card-body">
            <div class="col-md-4">
                <dl class="row">
                    <dt class="col-sm-9">
                        Mã sản phẩm:
                    </dt>
                    <dd class="col-sm-3">
                       	ID
                    </dd>
                </dl>
                <form:form action="${createProduct}" method="POST" modelAttribute="customer"  enctype="multipart/form-data">
                    Validate
                    <div class="form-group">
                        <label class="control-label">Product name:</label>
                        <input class="form-control" />
                        <%-- <form:input path="productName" /> --%>
                        validate here
                    </div>
                    <div class="form-group">
                        <label class="control-label">Description:</label>
                        <input class="form-control" />
                        <%-- <form:input path="description" /> --%>
                        validate here
                    </div>
                </form:form>

            </div>
        </div>
    </div>
</div>