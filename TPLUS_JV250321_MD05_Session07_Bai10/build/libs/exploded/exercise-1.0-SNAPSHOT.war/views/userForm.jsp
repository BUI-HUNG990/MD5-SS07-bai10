<%--
  Created by IntelliJ IDEA.
  User: ngoclb
  Date: 8/7/25
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form modelAttribute="user" method="post" action="">
        <label>Name:</label>
        <form:input path="name"/><br/>
        <form:errors path="name" cssStyle="color: red"/>
        <label>Age:</label>
        <form:input path="age"/><br/>
        <form:errors path="age" cssStyle="color: red"/>
        <label>Address:</label>
        <form:input path="address"/><br/>
        <form:errors path="address" cssStyle="color: red"/>
    </form:form>
</body>
</html>
