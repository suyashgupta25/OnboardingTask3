<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!--  Bootstrap CSS-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <!--  Custom CSS-->
    <link href="<c:url value='/static/css/shared.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/errors.css' />" rel="stylesheet"></link>
    <title>New Todo</title>
</head>
<body>
<div class="container">
    <div class="row d-flex justify-content-center mt-4">
        <div class="col-10 col-sm-9 col-md-7 col-lg-5">
            <div class="row d-flex justify-content-center align-items-center">
                <div class="col-1">
                    <a href="<c:url value="/todo/all"></c:url>">
                        <img id="back-button" class="mr-4" src="<c:url value="/static/img/svg/chevron-left.svg"/>"
                             alt="" width="28" height="28">
                    </a>
                </div>
                <div class="col-10">
                    <h2 class="text-center"><small>Add New Todo</small></h2>
                </div>
                <div class="col-1">
                </div>
            </div>
        </div>
    </div>

    <div class="row d-flex justify-content-center mt-2">
        <div class="col-10 col-sm-9 col-md-7 col-lg-5">
            <form:form method="POST" modelAttribute="webTodo" class="mt-3">
                <div class="form-group">
                    <label for="title">Title</label>
                    <form:input class="form-control" path="title" id="title"/>
                    <form:errors path="title" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="description">Description</label>
                    <form:input class="form-control" path="description" id="description"/>
                    <form:errors path="description" cssClass="error"/>
                </div>
                <button type="submit" class="btn btn-dark"/>Add todo</button>
            </form:form>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>
