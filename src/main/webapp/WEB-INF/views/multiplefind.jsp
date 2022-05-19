<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Multiple find</title>
</head>
<body>
<form method="get" action="${contextPath}/multiple">
<input type="text" name="multiple">
<input type="submit" value="입력">
</form>
${multiple_json}
</body>
</html>