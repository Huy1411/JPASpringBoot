<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="../../layout/admin/header.jsp" %>
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
<f:form action="${pageContext.request.contextPath}/admin/book/updateBook" method="POST" enctype="multipart/form-data" modelAttribute="bookEdit">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-10">
                <div class="card card-info">
                    <div class="card-header">
                        <h3 class="card-title">Edit Book </h3>
                    </div>
                    <div class="card-body">
                        <f:input path="id" type="hidden"/>
                        <div class="col-md-12">
                            <div class="row">
                                    <div class="form-group col-md-6">
                                        <label for="exampleInputEmail1">Book Name</label>
                                        <f:input path="name" type="text"  class="form-control ${param.errorbookname !=null ?'border border-danger':''}" placeholder="Enter Book Name"/>
                                        <p class="text-danger">${param.errorbookname}</p>
                                    </div>
                                <div class="form-group col-md-6">
                                    <label>Category:</label>
                                    <f:select class="custom-select" path="library.id">
                                        <f:options items="${libraries}"  itemLabel="name" itemValue="id" />
                                    </f:select>
                                </div>
                            </div>
                        </div>
<%--                        <div class="col-md-12">--%>
<%--                            <div class="row">--%>
<%--                                <div class="form-group col-md-6">--%>
<%--                                    <label>Price:</label>--%>
<%--                                    <f:input path="price" type="number" class="form-control " placeholder="Enter price product...."/>--%>
<%--                                </div>--%>
<%--                                <div class="form-group col-md-6">--%>
<%--                                    <label >Discount(%):</label>--%>
<%--                                    <f:input path="discount" type="number" class="form-control " value="0" placeholder="Enter discount..."/>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="col-md-12">--%>
<%--                            <div class="row">--%>
<%--                                <div class="form-group col-md-6">--%>
<%--                                    <label >Priority:</label>--%>
<%--                                    <f:select path="priority" class="custom-select">--%>
<%--                                        <f:option value="5">Default</f:option>--%>
<%--                                        <f:option value="4">Top 4</f:option>--%>
<%--                                        <f:option value="3">Top 3</f:option>--%>
<%--                                        <f:option value="2">Top 2</f:option>--%>
<%--                                        <f:option value="1">Top 1</f:option>--%>
<%--                                    </f:select>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="col-md-12">--%>
<%--                            <div class="row">--%>
<%--                                <div class="form-group col-md-12">--%>
<%--                                    <label >Description:</label>--%>
<%--                                    <f:textarea path="descriptions" style="height:500px" type="text" class="form-control" id="desId" placeholder="Enter Open Time"/>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="col-md-12">--%>
<%--                            <div class="row">--%>
<%--                                <div class="form-group col-md-12">--%>
<%--                                    <label >File Image:</label>--%>
<%--                                    <input name="file_avatar" id="fileImage" type="file" class="form-control" placeholder="Nhập Giá Bán Sản Phẩm"/>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
                        <div class="col-md-12">
                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label for="exampleInputEmail1">Status:</label>
                                    <div class="form-check">
                                        <f:radiobutton path="status" value="1"  class="form-check-input" checked="true" id="exampleInputEmail1"/>
                                        <label class="form-check-label" >Show</label>
                                        <br>
                                        <f:radiobutton path="status" value="2"  class="form-check-input" id="exampleInputEmail1"/>
                                        <label class="form-check-label" >Hidden</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card-footer">
                    <button type="submit" class="btn btn-info">Update</button>
                </div>
            </div>
        </div>
    </div>
    </div>
</f:form>
</div>
<%@include file="/WEB-INF/views/layout/admin/footer.jsp" %>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>

<%@include file="/WEB-INF/views/layout/admin/infoActionc.jsp" %>

<script type="text/javascript">
    $(function () {
        // Summernote
        $('#desId').summernote();

        click();
    })
</script>
</body>
</html>
