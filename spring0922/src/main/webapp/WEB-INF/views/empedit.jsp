<%--
  Created by IntelliJ IDEA.
  User: 25309
  Date: 2018/9/25
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工信息编辑</title>
</head>
<body>
<form action="addOrUpdEmp" method="post">
    <p>
        <input type="hidden" name="empno" value="${emp.empno }" id="empno">
        用户名:<input type="text " name="ename" value="${emp.ename}">
    </p>
    <p>
        工作:<input type="text " name="job" value="${emp.job}">
    </p>
    <p>
        薪水:<input type="text " name="sal" value="${emp.sal}">
    </p>
    <p>
        奖金:<input type="text " name="comm" value="${emp.comm}">
    </p>
    <p>
        部门:
        <select name="deptno" id="deptno">
            <option value="">请选择</option>
            <c:forEach var="emp" items="${empList}">
                <option value="${emp.deptno}">${emp.dname}</option>
            </c:forEach>
        </select>
    </p>
    <p>
        <input type="submit" value="提交"/>
    </p>

</form>

</body>
</html>
