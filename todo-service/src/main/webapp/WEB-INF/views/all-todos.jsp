<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>Todos</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!--  Bootstrap CSS-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <!--  Custom CSS-->
    <link href="<c:url value='/static/css/shared.css' />" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <br/>
    <blockquote class="blockquote">
        <button class="btn btn-dark ml-auto mb-0">
            <a class="text-white" href="<c:url value='/todo/add' />">Create new todo</a>
        </button>
    </blockquote>
    <c:choose>
        <c:when test="${fn:length(todoList) gt 0}">
            <h4> Todos </h4>
            <table border="1" class="table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th scope="col" colspan="2">Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${todoList}" var="todo" varStatus="loop">
                    <tr>
                        <th scope="row">${loop.index+1}</th>
                        <td>${todo.title}</td>
                        <td>${todo.description}</td>
                        <td><a href="<c:url value="/todo/edit/${todo.id}" />">edit</a></td>
                        <td><a href="<c:url value="/todo/delete/${todo.id}" />">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <h2>No todos found</h2>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>