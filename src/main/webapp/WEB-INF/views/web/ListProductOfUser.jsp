<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script>
	setTimeout(function() {
		$('#msgAlert').fadeOut('slow');
	}, 2000);
</script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src='https://cdn.jsdelivr.net/gh/vietblogdao/js/districts.min.js'></script>
<div class="container-fluid">
	<h1 class="mt-4">Danh sách sản phẩm</h1>
	<ol class="breadcrumb mb-4">
		<li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
		<li class="breadcrumb-item active">Danh sách người dùng</li>
	</ol>
	<div class="card mb-12">
		<div class=" card-header">
			<div class="row">
				<!--  <div class="col-md-4 col-xs-12">
                    <select style=" border:1px solid #7f7f7f;height:38px;" id="district" name="calc_shipping_district" required="">
                        <option value="">Quận / Huyện</option>
                    </select>
                </div> -->
				<div class="col-md-12 col-xs-12">
					<form action="Index" method="get">
						<div class="row">
							<div class="col-md-3">
								<input type="text" name="keyword"
									placeholder="Từ khóa...." class="form-control" />
							</div>
							<div class="col-md-3">

								<select name="categoryId" onchange="" class="form-control">
									<option>--Chọn danh mục--</option>
								</select>

							</div>
							<div class="col-md-3">
								<select name="status" onchange="" class="form-control">
									<option>--Chọn tình trạng--</option>
								</select>
							</div>
							<div class="col-md-3">
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
							<th>Mã sản phẩm</th>
							<th>Tên sản phẩm</th>
							<th>Giá hiện tại</th>
							<th>Số lượng</th>
							<th>Số lượt xem</th>
							<th>Tình trạng</th>

							<th></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
			<!--Phan trang  -->
		</div>
	</div>
</div>

<script>
	function myFunction() {
		var provinceText = $("#province option:selected").text();
		var districtText = $("#district option:selected").text();
		// bien luu dia chi

		var address = districtText + "_" + provinceText;
		var add = document.querySelector('input.billing_address_2');
		add.value = address;
		console.log(add.value);
	}
</script>