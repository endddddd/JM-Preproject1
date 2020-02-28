<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
  Created by IntelliJ IDEA.
  User: andrei
  Date: 21.02.2020
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PreProject1</title>
    <link rel="stylesheet" type="text/css" href="index.css">
</head>
<body>

</hr>
<div align="center"><h2>Изменить Данные:</h2> </div>
<form>
    <table>
        <thead>
<c:forEach var="user" items="${requestScope.user}">

<tr>
    <th><c:out value="${user.name}"/></th>
    <th><c:out value="${user.password}"/></th>
    <th><c:out value="${user.id}"/></th>

</tr>
        </thead>
        <tbody>
        <tr>
            <td>
               <form>
                <label><input type="text" name="name" /></label>
                <input type="hidden" name="id" value="${user.id}">
                <button formaction="/update" formmethod="post" type="submit" name="password"  value="${user.password}">Изменить Имя
                </button>
               </form>
            </td>
            <td>
                <form>
                <label> <input type="text" name="password"/></label>
                <input type="hidden" name="id" value="${user.id}">
                <button formaction="/update" formmethod="post" type="submit" name="name" value="${user.name}">Изменить Пароль
                </button>
                </form>
            </td>
            <td>
                <input formaction="/" formmethod="post" value="Назад в Список" type="submit">
            </td>
        </tr>
        </tbody>
</c:forEach>
</form>

</body>
</html>
