<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="pageTitle" scope="request" value="Category Manager"/>
<head>
    <meta charset="UTF-8">
    <title>${pageTitle}</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="<c:url value="/assets/plugins/fontawesome-free/css/all.min.css" />">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- overlayScrollbars -->
    <link rel="stylesheet" href="/assets/dist/css/adminlte.min.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
    <link rel="stylesheet" href="/assets/plugins/fontawesome-free/css/all.min.css">
    <link rel="stylesheet" href="/assets/editor/richtext.min.css">

    <link rel="stylesheet" href="/assets/plugins/summernote/summernote-bs4.css">
</head>
<body>
<div class="wrapper">
    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <!-- Left navbar links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
            </li>
        </ul>

        <!-- SEARCH FORM -->
        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">
            <!-- Messages Dropdown Menu -->

            <!-- Notifications Dropdown Menu -->
            <li class="nav-item ">
                <a class="nav-link"  href="${pageContext.request.contextPath}/logout">
                    Logout
                </a>
            </li>

        </ul>
    </nav>

    <!-- /.navbar -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="../../index3.html" class="brand-link">
            <img src="<c:url value="/assets/dist/img/AdminLTELogo.png"/>"
                 alt="AdminLTE Logo"
                 class="brand-image img-circle elevation-3"
                 style="opacity: .8">
            <span class="brand-text font-weight-light">Admin</span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
            <!-- Sidebar user (optional) -->
            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="image">
                    <img src="https://picsum.photos/160/160" class="img-circle elevation-2" alt="User Image">
                </div>
                <div class="info">
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <a href="/logout" class="d-block">${pageContext.request.userPrincipal.name}</a>
                    </c:if>
                </div>
            </div>

            <!-- Sidebar Menu -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                    <!-- Add icons to the links using the .nav-icon class
                         with font-awesome or any other icon font library -->
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/" class="nav-link">
                            <i class="nav-icon fas fa-tachometer-alt"></i><p>Dashboard</p>
                        </a>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link"><i class="nav-icon fas fa-th"></i><p>Book Website<i class="right fas fa-angle-left"></i></p></a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="${pageContext.request.contextPath}/books" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Book Manager</p></a>
                            </li>
                            <li class="nav-item">
                                <a href="${pageContext.request.contextPath}/libraries" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Library Manager</p></a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </nav>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
    </aside>
<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Category Detail Manager</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a>Home</a></li>
                        <li class="breadcrumb-item active">Category Detail Manager</li>
                    </ol>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-5">
                <!-- general form elements -->
                <div class="card card-info">
                    <div class="card-header">
                        <h3 class="card-title">Create New Category Detail</h3>
                        <div class="card-tools">
                            <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip"
                                    title="Collapse">
                                <i class="fas fa-minus"></i></button>
                        </div>
                    </div>
                    <div class="card-body" style="display: block;">
                        <!-- /.card-header -->
                        <!-- form start -->
                        <%--@elvariable id="cateDetailEdit" type=""--%>
                        <f:form action="${pageContext.request.contextPath}/admin/categoryDetail/updateCateDetail"
                                method="POST" modelAttribute="cateDetailEdit">
                            <f:input path="cate_detail_id" type="hidden"/>
                            <f:input path="created" type="hidden"/>

                            <div class="form-group">
                                <label for="exampleInputEmail1">Name</label>
                                <f:input path="cate_detail_name" type="text" class="form-control ${param.errorcatename !=null ?'border border-danger':''}"
                                         id="exampleInputEmail1" placeholder="Name"/>
                                <p class="text-danger">${param.errorcatename}</p>
                            </div>

                            <div class="form-group">
                                <label for="exampleInputEmail1">Category</label>
                                <f:select cssClass="custom-select" path="category.cate_id">
                                    <f:options items="${listCate}" itemLabel="cate_name" itemValue="cate_id"/>
                                </f:select>
                            </div>
                            <div class="form-group">
                                <label>Status:</label>
                                <div class="custom-control custom-radio">
                                    <f:radiobutton class="custom-control-input" path="status" value="1" checked="true"
                                                   id="customRadio1"/>
                                    <label for="customRadio1" class="custom-control-label">Show</label>
                                </div>
                                <div class="custom-control custom-radio">
                                    <f:radiobutton class="custom-control-input" path="status" value="2"
                                                   id="customRadio2"/>
                                    <label for="customRadio2" class="custom-control-label">Hidden</label>
                                </div>
                            </div>
                            <!-- /.card-body -->
                            <div class="card-footer">
                                <button type="submit" class="btn btn-info">Update</button>
                            </div>
                        </f:form>
                    </div>
                    <!-- /.card -->
                </div>
            </div>
        </div>
    </div>
</div>

<footer class="main-footer">
    <div class="float-right d-none d-sm-block">
        <b>Version</b> 3.0.4
    </div>
    <strong>Copyright &copy; 2014-2019 <a href="http://adminlte.io">AdminLTE.io</a>.</strong> All rights
    reserved.
</footer>

<!-- Control Sidebar -->
<aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
</aside>

</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/assets/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/assets/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<%--<script src="${pageContext.request.contextPath}/assets/dist/js/demo.js"></script>--%>
<script src="${pageContext.request.contextPath}/assets/plugins/summernote/summernote-bs4.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script src="${pageContext.request.contextPath}/assets/dist/js/sweetalert2.all.min.js"></script>
<script type="text/javascript">
    $(function () {

        <c:if test="${param.success != null}">
        Swal.fire({
            title: '${param.success} success',
            text: "Please confirm to continue!",
            icon: 'success',
        });
        </c:if>
        <c:if test="${param.error != null}">
        Swal.fire({
            title: '${param.error} error',
            text: "Please confirm to continue!",
            icon: 'error',
        });
        </c:if>
    })
</script>

</body>
</html>