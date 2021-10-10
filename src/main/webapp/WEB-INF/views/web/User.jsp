<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script>
	setTimeout(function() {
		$('#msgAlert').fadeOut('slow');
	}, 2000);
</script>

<div class="container-fluid col-md-8 col-xs-12">
	<h1 class="mt-4">Thong tin nguoi dung</h1>
	<ol class="breadcrumb mb-4">
		<li class="breadcrumb-item"><a class="nav-link" href="#">Trang
				chủ</a></li>
		<li class="breadcrumb-item active">Thong tin nguoi dung</li>
	</ol>
	<div class="card mb-4">
		<div class="card-header">
			<a class="btn btn-success" href="#">Về danh sách</a>
		</div>

		<div class="card-body">

			<div class="table-responsive">

				<table class="table table-bordered">
					<thead>
						<tr>
							<th class="col-md-4">Thuộc tính</th>
							<th class="col-md-8">Mô tả</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>ten</td>
							<td>loi</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="col-md-4">
		<a class="btn btn-success" href="#">Thay đổi thông tin</a>
	</div>
</div>
