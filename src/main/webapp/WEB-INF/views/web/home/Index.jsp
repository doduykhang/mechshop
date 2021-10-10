<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class=" card-header">
	<div class="row">
		<div class="col-md-12 col-xs-12">
			<form action="Index" method="get">
				<div class="row">
					<div class="col-md-3">
						<input name="keyword" type="text" class="form-control"
							placeholder="Từ khóa...." />
					</div>
					<div class="col-md-3">
						<select name="categoryCode" onchange="" class="form-control">
							<option>--Chọn danh mục--</option>
						</select>
					</div>
					<div class="col-md-2">
						<input type="text" name="minPrice" placeholder="Giá min"
							class="form-control" />
					</div>
					<div class="col-md-2">
						<input type="text" name="maxPrice" placeholder="Giá max"
							class="form-control" />
					</div>
					<div class="col-md-2">
						<button type="submit" class="btn btn-success">Lọc</button>
						<button type="button"
							onclick="window.location.href='/Category/Index'"
							class="btn btn-dark">Reset</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<div class="container px-4 px-lg-5 mt-5">
	<div
		class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
		<c:forEach var="item" items="${product}">
			<div class="col mb-5">
				<div class="card h-100">
					<!-- Sale badge-->
					<div class="badge bg-dark text-white position-absolute"
						style="top: 0.5rem; right: 0.5rem">Sale</div>
					<!-- Product image-->
					<img class="card-img-top"
						src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
					<!-- Product details-->
					<div class="card-body p-4">
						<div class="text-center">
							<!-- Product name-->
							<h5 class="fw-bolder">${item.name }</h5>
							<!-- Product reviews-->
							<div
								class="d-flex justify-content-center small text-warning mb-2">
								<div class="bi-star-fill"></div>
								<div class="bi-star-fill"></div>
								<div class="bi-star-fill"></div>
								<div class="bi-star-fill"></div>
								<div class="bi-star-fill"></div>
							</div>
							<!-- Product price-->
							<span class="text-muted text-decoration-line-through">$20.00</span>
							$18.00
						</div>
					</div>
					<!-- Product actions-->
					<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
						<div class="text-center">
							<a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>


	</div>
</div>