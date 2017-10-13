<%--
  Created by IntelliJ IDEA.
  User: duanjingdi
  Date: 2017/10/12
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户角色列表</title>
</head>
<body>
<h1>用户角色列表</h1>
    <table>
        <thead>
            <tr>
                <td> 客户编号 </td><td>客户名称</td><td>客户昵称</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${  requestScope.lgs  }" var="guest">
                <tr>

                   <td> ${guest.userid} </td>
                    <td>${guest.username}</td>
                    <td>${guest.nickname}</td>
                </tr>

            </c:forEach>

        </tbody>

    </table>
</body>
</html>
