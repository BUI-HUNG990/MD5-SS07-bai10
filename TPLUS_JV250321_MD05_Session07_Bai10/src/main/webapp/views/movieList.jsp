
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            margin: 30px;
            padding: 0;
            display: flex;
            flex-direction: column;
            justify-content: center;

        }

        h2 {
            text-align: center;
        }

        td:nth-child(1), td:nth-child(4), td:nth-child(5) {
            text-align: center;
        }
    </style>
</head>
<body>
<c:if test="${not empty message}">
    <p style="color: green">${message}</p>
</c:if>
<c:if test="${not empty error}">
    <p style="color: red">${error}</p>
</c:if>
<h2>Danh sách phim</h2>

<a href="goToAddPage">Them phim moi</a>
<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên phim</th>
        <th>Đạo diễn</th>
        <th>Ngày phát hành</th>
        <th>Thể loại</th>
        <th>Poster</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="movie" items="${movies}">
        <tr>
            <td>${movie.id}</td>
            <td>${movie.title}</td>
            <td>${movie.director}</td>
            <td>${movie.releaseDate}</td>
            <td>${movie.genre}</td>
            <td>
                <img src="${movie.poster}" alt="Poster" width="100" height="150"/>
            </td>
            <td>
                <a href="goToUpdatePage?id=${movie.id}">Update</a>
                <a href="deleteMovie?id=${movie.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>



