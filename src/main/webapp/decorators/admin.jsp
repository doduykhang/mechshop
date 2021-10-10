<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="${pageContext.servletContext.contextPath}/">
    <meta charset="utf-8" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Administration</title>
    
    <link href="<c:url value='/template/admin/css/styles.css' />" rel="stylesheet" />
	<link href="<c:url value='/template/admin/css/style1.css'/>" rel="stylesheet"/>
    <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet"  />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" ></script>
    
</head>
<body class="sb-nav-fixed">
	<c:set var="userName"><security:authentication property="principal.username"/></c:set>
	<c:set var="id"><security:authentication property="principal.id"/></c:set>
	<c:url value="/quan-tri/nguoi-dung/chinh-sua-thong-tin-ca-nhan" var="editInfo"/>
	<c:url value="/quan-tri/nguoi-dung" var="listUser"/>
	<c:url value="/quan-tri/nguoi-dung/tao-moi" var="createUser" />
	<c:url value="/quan-tri/nguoi-dung/quan-tri" var="listAdmin" />
	
	<c:url value="/quan-tri/danh-muc" var="listCategory"/>
	<c:url value="/quan-tri/danh-muc/san-pham" var="listProduct" />
	<c:url value="/quan-tri/danh-muc/trinh-chieu" var="listSlide" />
	<c:url value="/quan-tri/danh-muc/noi-bat" var="listFeature" />
	
    <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
        <a class="navbar-brand" href="/quan-tri/trang-chu">Nhóm x</a><button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#">
            <i class="fas fa-bars"></i>
        </button>
        <!-- Navbar Search-->
        <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
            <div class="input-group">
                <input class="form-control" type="text" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2" />
                <div class="input-group-append">
                    <button class="btn btn-primary" type="button"><i class="fas fa-search"></i></button>
                </div>
            </div>
        </form>
        <!-- Navbar-->
        <ul class="navbar-nav ml-auto ml-md-0">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                    <a class="dropdown-item" href="${editInfo}?id=${id}">${userName}</a>
                    <a class="dropdown-item" href="#">Hoạt động</a>
                    <div class="dropdown-divider"></div>
                    <form method="post" action="/logout">
                        <button type="submit" class="dropdown-item">Đăng xuất</button>
                    </form>
                </div>
            </li>
        </ul>
    </nav>
    <div id="layoutSidenav">
        <div id="layoutSidenav_nav">
            <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                <div class="sb-sidenav-menu">
                    <div class="nav">
                        <div class="sb-sidenav-menu-heading">Hệ thống quản trị</div>
                        <a class="nav-link" href="/quan-tri/trang-chu">Trang chủ</a>
                        <div class="sb-sidenav-menu-heading">Hệ thống</div>

                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                            Người dùng
                            <div class="sb-sidenav-collapse-arrow">
                            	<i class="fas fa-angle-down">
                            </i></div>
                        </a>
                        <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="${listUser}">Danh sách</a>
                                <a class="nav-link" href="${createUser}">Thêm mới</a>
                                <a class="nav-link" href="${listAdmin}">Danh sách quản trị viên</a>
                            </nav>
                        </div>

                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                            <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                            Danh mục
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                <a class="nav-link" href="${listCategory}">Danh mục</a>
                                <a class="nav-link" href="${listProduct}">Sản phẩm</a>
                                <a class="nav-link" href="${listSlide}">Sản phẩm trình chiếu</a>
                                <a class="nav-link" href="${listFeature}">Sản phẩm nổi bật</a>
                                <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                    <nav class="sb-sidenav-menu-nested nav"><a class="nav-link" href="401.html">401 Page</a><a class="nav-link" href="404.html">404 Page</a><a class="nav-link" href="500.html">500 Page</a></nav>
                                </div>
                            </nav>
                        </div>

                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseStatistic" aria-expanded="false" aria-controls="collapseStatistic">
                            <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                            Thống kê
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="collapseStatistic" aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                <a class="nav-link" href="#">Lượt xem</a>
                                <a class="nav-link" href="#">Sản phẩm người dùng</a>
                                <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                    <nav class="sb-sidenav-menu-nested nav"><a class="nav-link" href="401.html">401 Page</a><a class="nav-link" href="404.html">404 Page</a><a class="nav-link" href="500.html">500 Page</a></nav>
                                </div>
                            </nav>
                        </div>

                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseContacts" aria-expanded="false" aria-controls="collapseContacts">
                            <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                            Liên hệ
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="collapseContacts" aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                <a class="nav-link" href="#">Danh sách</a>
                                <a class="nav-link" href="#">Tạo mới</a>
                                <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                                    <nav class="sb-sidenav-menu-nested nav"><a class="nav-link" href="401.html">401 Page</a><a class="nav-link" href="404.html">404 Page</a><a class="nav-link" href="500.html">500 Page</a></nav>
                                </div>
                            </nav>
                        </div>
                    </div>
                </div>

            </nav>
        </div>
        <div id="layoutSidenav_content">
            <main>
                <dec:body/>
            </main>
            <footer class="py-4 bg-light mt-auto">
                <div class="container-fluid">
                    <div class="d-flex align-items-center justify-content-between small">
                        <div class="text-muted">Copyright &copy; By Nhóm x</div>
                        <div>
                            <a href="#">Privacy Policy</a>
                            &middot;
                            <a href="#">Terms &amp; Conditions</a>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
    </div>
    <script src="<c:url value='/template/admin/js/scripts.js' />"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" ></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" ></script>

</body>
</html>