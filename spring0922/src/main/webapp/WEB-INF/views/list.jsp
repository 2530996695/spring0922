<%--
  Created by IntelliJ IDEA.
  User: 25309
  Date: 2018/9/25
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学员管理</title>
</head>
<body>

<%--<a href="${pageContext.request.contextPath }/add">新增</a>--%>
<form action="empList" method="post">
   <p>姓名: <input type="text" name="ename" /></p>
    <p>
        时间:
        <input type="date" name="beginDate" />
        <input type="date" name="endDate" />
    </p>

    <p>
        <a href="openPage">新增</a>
        <input type="submit" value="查询">
    </p>

</form>

    <!-- 显示数据的表格 -->
    <!--         居中              -->
    <table align="center" cellpadding="10px" cellspacing="0" border="2px">

        <caption>员工信息查询</caption>
        <!-- 表头 -->
        <thead>
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>工作</th>
            <th>薪资</th>
            <th>奖金</th>
            <th>部门名称</th>
            <th>入职时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <!-- 数据行开始 -->
        <c:forEach items="${empList}" var="emp">
            <tr>
                <td>${emp.empno }</td>
                <td>${emp.ename }</td>
                <td>${emp.job }</td>
                <td>${emp.sal }</td>
                <td>${emp.comm}</td>
                <td>${emp.dname}</td>
                <td><fmt:formatDate value="${emp.hiredate}" pattern="yyyy-MM-dd" /></td>
                <td>
<%--                    <a href="javascript:dele(${emp.empno});"rel="external nofollow" >删除</a>--%>
                    <a href= "deleteByID?empno=${emp.empno}" onclick="return confirm('是否确认删除?')">删除</a>
                    <a href="updEmp?empno=${emp.empno}">修改</a>
                </td>
            </tr>
        </c:forEach>
        <!-- 数据行结束 -->
        </tbody>
    </table>
</body>
<script>
    function dele(empno) {
        if (window.confirm("是否删除")) {
            window.location.href = "${pageContext.request.contextPath }/deleteByID?empno="+empno;
        }
    }
</script>
</html>
