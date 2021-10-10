<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<script>
	setTimeout(function() {
		$('#msgAlert').fadeOut('slow');
	}, 2000);
</script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src='https://cdn.jsdelivr.net/gh/vietblogdao/js/districts.min.js'></script>
<div class="container-fluid">
	<h1 class="mt-4">Danh sách danh mục</h1>
	<ol class="breadcrumb mb-4">
		<li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
		<li class="breadcrumb-item active">Danh sách danh mục</li>
	</ol>
	<div class="card mb-12">
		<div class=" card-header">
			<div class="row">
				<div class="col-md-12 col-xs-12">
					<form action="Index" method="get">
						<div class="row">
							<div class="col-md-7">
								<input type="text" name="keyword"
									placeholder="Từ khóa...." class="form-control" />
							</div>
							<div class="col-md-3">
								<select name="status" onchange="" class="form-control">
									<option>--Chọn tình trạng--</option>
								</select>
							</div>
							<div class="col-md-2">
								<input class="billing_address_2" name="address" type="hidden"
									value="">
								<button type="submit" onclick="myFunction()"
									class="btn btn-primary">Tìm</button>
								<button type="button"
									onclick="window.location.href='/Product/Index'"
									class="btn btn-dark">Reset</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="card-body">
			<div class="row">
				<!-- @if (ViewBag.Success != null)
                {
                <div id="msgAlert" class="alert alert-success" role="alert">
                    @ViewBag.Success
                </div>}
                @if (TempData["failResult"] != null)
                {
                <div id="failAlert" class="alert alert-success" role="alert">
                    @TempData["failResult"]
                </div>} -->
			</div>
			<div class="table-responsive">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Mã slide</th>
							<th>Ảnh</th>
							<th>Tên slide</th>
							<th>Mã sản phẩm</th>
							<th>Tình trạng</th>
							
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${slide}">
							<tr>
								
								<td>${item.id}</td>
								<td>${item.imagePath}</td>
								<td>${item.name}</td>
								<td>${item.product.name}</td>
								<td>${item.status}</td>
								
								<td>
									<c:url var="editURL" value="/quan-tri/danh-muc/tao-moi">
										<c:param name="id" value="${item.id}" />
									</c:url> 
									
									<a href='${editURL}'>
										<i class="fas fa-pen-square" style="width:25px; height:25px;"></i>
										Hiệu chỉnh
									</a>
								</td>
								</tr>
						</c:forEach>	
					</tbody>
				</table>
			</div>
			<!--Phan trang  -->
		</div>
	</div>
</div>
