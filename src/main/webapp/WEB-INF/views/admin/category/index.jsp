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
                <div class="col-md-3 col-xs-12">
                    <a class="btn btn-success" href="quan-tri/danh-muc/tao-moi">Tạo mới</a>
                </div>
                <div class="col-md-9 col-xs-12">
                    <form asp-action="Index" method="get">
                        <div class="row">
                        	<div class="col-md-4">
								<select name="status" onchange="" class="form-control">
									<option>--Chọn tình trạng--</option>
								</select>
							</div>
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
						<tr style="text-align:center;">
							<th class="col-md-3">Mã danh mục</th>
							<th class="col-md-5">Ảnh đại diện</th>
							<th class="col-md-2">Tên danh mục</th>
							<th class="col-md-2">Tác vụ</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${category}">
							<tr>
								
								<td>${item.categoryCode}</td>
								<td>
									<a href="#"><img src="${item.imagePath}" alt="N/A" style="width: 70px; height: 70px; object-fit: cover;"></a>
								</td>
								<td>${item.name}</td>
								<td>
									<c:url var="editURL" value="/quan-tri/danh-muc/chinh-sua">
										<c:param name="code" value="${item.categoryCode}" />
									</c:url> 
									<c:url var="deleteURL" value="/quan-tri/danh-muc/xoa">
										<c:param name="code" value="${item.categoryCode}" />
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
			</div>
			<!--Phan trang  -->
		</div>
	</div>
</div>
