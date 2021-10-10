<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
<script>
	setTimeout(function() {
		$('#msgAlert').fadeOut('slow');
	}, 2000);
</script>

<!DOCTYPE html>
<html lang="en">
<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Đăng nhập hệ thống</title>

<script src="https://kit.fontawesome.com/64d58efce2.js" crossorigin="anonymous"></script>

<title>Đăng ký và đăng nhập</title>
<link rel="stylesheet" href="<c:url value='/template/admin/js/style2.css' />" />
</head>
<body>
	<!--@render body  -->
	<dec:body/>
	
<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
	<script src="<c:url value='/template/admin//js/app.js' />"></script>	
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
	<script src="<c:url value='/template/admin/js/scripts.js' />"></script>	
</body>
</html>

