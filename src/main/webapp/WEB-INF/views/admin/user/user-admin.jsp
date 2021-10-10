<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
  <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 class="mt-4">Danh sách người dùng</h1>
	<ol class="breadcrumb mb-4">
		<li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
		<li class="breadcrumb-item active">Danh sách người dùng</li>
	</ol>
	<div class="card mb-12">
		<div class=" card-header">
		<div class="row">
                <div class="col-md-3 col-xs-12">
                    <a class="btn btn-success" href="quan-tri/nguoi-dung/tao-moi">Tạo mới</a>
                </div>
                <div class="col-md-9 col-xs-12">
                    <form asp-action="Index" method="get">
                        <div class="row">
                            <div class="col-md-5">
                                <input type="text" placeholder="Từ khóa...." name="keyword" class="form-control" />
                            </div>
                            <div class="cold-md-3">
                                <button type="submit" class="btn btn-primary">Tìm</button>
                                <button type="button" onclick="window.location.href='/Category/Index'" class="btn btn-dark">Reset</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
			
		</div>

	<div class="table-responsive">
		<jsp:useBean id="pagedListHolder" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="quan-tri/nguoi-dung" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>
	
		<div>
			<tg:paging pagedListHolder="${pagedListHolder}"
				pagedLink="${pagedLink}" />
		</div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">Họ tên</th>
					<th scope="col">Tên đăng nhập</th>
					<th class="col-md-2">Trạng thái</th>
					<th class="col-md-2">Tác vụ</th>
				</tr>
			</thead>
			<tbody id="table_products">
				<c:forEach var="pd" items="${pagedListHolder.pageList}">
					<tr>
						<td>${pd.fullName}</td>
						<td>${pd.userName}</td>
						
						<td><c:out value="${pd.status eq 1 ? 'enable': 'disable'}"/></td>
						<td>
							<c:url var="editURL" value="/quan-tri/danh-muc/chinh-sua">
								<c:param name="code" value="${item.id}" />
							</c:url> 
							<c:url var="deleteURL" value="/quan-tri/danh-muc/xoa">
								<c:param name="code" value="${item.id}" />
							</c:url> 
							<div style="display:flex; justify-content:space-around;">
								<a href='${editURL}' >
									<i class="fas fa-pen-square" style="width:25px; height:25px;"></i>
								</a>
								<a href='${deleteURL}'>
									<i class="fas fa-trash-alt" style="width:25px; height:25px;"></i>
								</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<tg:paging pagedListHolder="${pagedListHolder}"
			pagedLink="${pagedLink}" />

	</div>
</body>
</html>