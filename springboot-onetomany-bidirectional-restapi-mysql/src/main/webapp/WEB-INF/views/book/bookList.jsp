<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="pageTitle" scope="request" value="Library Manager"/>
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
                                <a href="${pageContext.request.contextPath}/book" class="nav-link"><i class="far fa-circle nav-icon"></i><p>Book Manager</p></a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </nav>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
    </aside>    <!-- Main Sidebar Container -->
</div>
<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Book Manager</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a >Home</a></li>
                        <li class="breadcrumb-item active">Book Manager</li>
                    </ol>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-7">
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title">Book List</h3>
                    </div>
                    <!-- /.card-header -->
                    <div class="card-body">
                        <table class="table table-striped projects">
                            <thead>
                            <tr>
                                <th style="width: 10px">STT</th>
                                <th>Book Name</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${bookList}" var="book" varStatus="itr">
                                <tr>
                                    <td>${offset+itr.index+1}</td>
                                    <td>${book.name }
                                        <br>
                                        <c:if test="${book.status ==1}">
                                            <span class="badge badge-success">Show</span>
                                        </c:if>
                                        <c:if test="${book.status ==2}">
                                            <span class="badge badge-danger">Hidden</span>
                                        </c:if>
                                    </td>
                                    <td>${category.created}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}book/editBook?id=${book.id}" class="btn  btn-info btn-sm"><i class="fas fa-pencil-alt"> </i> Edit</a>
                                        <a href="${pageContext.request.contextPath}book/deleteBook?id=${book.id}" class="btn  btn-danger btn-sm"><i class="fas fa-trash"> </i> Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <%-- <mytag:PaginatiomnTaglib steps="10" offset="${offset}" count="${count}" uri="/cateController/getAll.htm" next="&raquo;" previous="&laquo;"/> --%>
                    </div>
                    <!-- /.card-body -->
                    <div class="card-footer clearfix">
                        <ul class="pagination pagination-sm m-0 float-right">
                            <c:if test="${totalPages > 1}">
                                <c:if test="${currentPage>1}">
                                    <li class="page-item"><a class="page-link" href="book/page/${currentPage-1}">«</a></li>
                                </c:if>
                                <c:forEach  end="${totalPages}" begin="1" varStatus="loop">
                                    <c:if test="${currentPage != loop.index}">
                                        <li class="page-item "><a class="page-link" href="book/page/${loop.index}">${loop.index}</a></li>
                                    </c:if>
                                    <c:if test="${currentPage == loop.index}">
                                        <li class="page-item active"><a class="page-link" href="book/page/${loop.index}">${loop.index}</a></li>
                                    </c:if>
                                </c:forEach>
                                <c:if test="${currentPage<totalPages}">
                                    <li class="page-item"><a class="page-link" href="book/page/${currentPage+1}">»</a></li>
                                </c:if>
                            </c:if>
                        </ul>
                    </div>
                </div>
                <!-- /.card -->
            </div>
            <div class="col-md-5">
                <!-- general form elements -->
                <div class="card card-info">
                    <div class="card-header">
                        <h3 class="card-title">Add New Book </h3>
                        <div class="card-tools">
                            <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
                                <i class="fas fa-minus"></i></button>
                        </div>
                    </div>
                    <div class="card-body" style="display: block;">
                        <!-- /.card-header -->
                        <!-- form start -->
                        <%--@elvariable id="bookNew" type=""--%>
                        <f:form action="${pageContext.request.contextPath}/book/saveBook" method="POST" modelAttribute="bookNew">
                            <spring:bind path="name">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Book Name :</label>
                                    <f:input path="name" type="text"  class="form-control  ${status.error ?'border border-danger':''} ${param.errorcategoryname !=null ?'border border-danger':''}" id="exampleInputEmail1"  placeholder="Enter book name..."/>
                                    <f:errors path="name" class="text-danger" ></f:errors>
                                    <p class="text-danger">${param.errorbookname}</p>
                                </div>
                            </spring:bind>
                            <spring:bind path="status">
                                <div class="form-group">
                                    <label>Status :</label>
                                    <div class="custom-control custom-radio">
                                        <f:radiobutton class="custom-control-input" path="status" value="1" checked="true"  id="customRadio1" />
                                        <label for="customRadio1" class="custom-control-label">Show</label>
                                    </div>
                                    <div class="custom-control custom-radio">
                                        <f:radiobutton class="custom-control-input" path="status" value="2" id="customRadio2" />
                                        <label for="customRadio2" class="custom-control-label">Hidden</label>
                                    </div>
                                    <f:errors path="status" class="text-danger"  ></f:errors>
                                </div>
                            </spring:bind>
                            <div class="card-footer">
                                <button type="submit" class="btn btn-info">Submit</button>
                            </div>
                        </f:form>
                    </div>
                    <!-- /.card -->
                </div>
            </div>
        </div>
    </div>
</div>

<script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>


</body>
</html>
