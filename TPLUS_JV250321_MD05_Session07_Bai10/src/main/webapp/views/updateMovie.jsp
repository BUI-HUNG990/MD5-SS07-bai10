
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sua Phim</title>
</head>
<body>
<h2 style="text-align: center">Sua phim</h2>

<c:if test="${not empty error}">
    <p style="color: red">${error}</p>
</c:if>

<form:form modelAttribute="movie" method="post" action="/updateMovie">
    <form:hidden path="id"/>
    <label>Tiêu đề:</label>
    <form:input path="title" />
    <form:errors path="title" cssStyle="color: red"/><br/>

    <label>Đạo diễn:</label>
    <form:input path="director" />
    <form:errors path="director" cssStyle="color: red"/><br/>

    <label>Ngày phát hành:</label>
    <form:input path="releaseDate" type="date" />
    <form:errors path="releaseDate" cssStyle="color: red"/><br/>

    <label>Thể loại:</label>
    <form:input path="genre" />
    <form:errors path="genre" cssStyle="color: red"/><br/>

    <label>Poster (URL):</label>
    <form:input path="poster" />
    <form:errors path="poster" cssStyle="color: red"/><br/>

    <button type="submit">Sua phim</button>
</form:form>

</body>
</html>
