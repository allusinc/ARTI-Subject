<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert sort</title>
</head>
<body>
<form method="get" action="${contextPath}/insert">
<input type="text" name="insert">
<input type="submit" value="입력">
</form>
${insert_json}
</body>
</html>