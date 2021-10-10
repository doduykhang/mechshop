<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="forms-container">
		<div class="signin-signup">
			<form action="j_spring_security_check" id="formLogin" method="post"
				class="sign-in-form">
				<h2 class="title">Đăng nhập</h2>

				<c:if test="${param.incorrectAccount != null}">
					<div class="alert alert-danger">Username or password
						incorrect</div>
				</c:if>
				<c:if test="${param.accessDenied != null}">
					<div class="alert alert-danger">you Not authorize</div>
				</c:if>

				<div class="input-field">
					<i class="fas fa-user"></i> <input type="text" class="form-control"
						id="userName" name="j_username" placeholder="Tên đăng nhập">
				</div>
				<div class="input-field">
					<i class="fas fa-lock"></i> <input type="password"
						class="form-control" id="password" name="j_password"
						placeholder="Mật khẩu">
				</div>
				<div class="custom-control custom-checkbox">
					<input class="custom-control-input" name="rememberMe"
						type="checkbox" /> <label class="custom-control-label">Nhớ
						đăng nhập</label>
				</div>
				<input type="submit" value="Đăng nhập" class="btn solid" /> <a
					class="forgotPassword" href="quen-mat-khau">Quên mật
					khẩu?</a>
			</form>

			<form action="dang-ky" class="sign-up-form" method="post">
				<h2 class="title">Đăng ký</h2>
				<c:forEach items = "${errorMessage}" var = "error">
			         <c:out value = "${error.message}"/><p>
			    </c:forEach>
				<div class="alert alert-danger"></div>
				<div>
					<div class="input-field">
						<i class="fas fa-lock"></i> <input type="text"
							class="form-control" id="password" name="fullName"
							placeholder="Họ và tên">
					</div>
					<div class="input-field">
						<i class="fas fa-user"></i> <input type="text"
							class="form-control" id="userName" name="userName"
							placeholder="Tên đăng nhập">
					</div>
					<div class="input-field">
						<i class="fas fa-lock"></i> <input type="password"
							class="form-control" id="password" name="password"
							placeholder="Mật khẩu">
					</div>
					<div class="input-field">
						<i class="fas fa-lock"></i> <input type="text"
							class="form-control" id="password" name="email"
							placeholder="Email">
					</div>
					<input type="submit" style="margin-left: 50px;" Đăng
						ký" class="btn solid" />
				</div>
			</form>
		</div>
	</div>

	<div class="panels-container">
		<div class="panel left-panel">
			<div class="content">
				<h3>Có gì mới ?</h3>
				<p>Hãy đăng kí tài khoản để bạn có thể trở thành quản người dùng
					của website</p>
				<button class="btn transparent" id="sign-up-btn">Đăng ký</button>
			</div>

			<img src="<c:url value='/template/admin/assets/img/log.svg' />"
				class="image" alt="" />
		</div>
		<div class="panel right-panel">
			<div class="content">
				<h3>Hãy là một trong số chúng tôi ?</h3>
				<p></p>
				<button class="btn transparent" id="sign-in-btn">Đăng nhập
				</button>
			</div>
			<img src="<c:url value='/template/admin/assets/img/register.svg' />"
				class="image" alt="" />
		</div>
	</div>
</div>
