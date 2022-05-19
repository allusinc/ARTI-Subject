<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Selection sort</title>
</head>
<body>
<form method="get" action="${contextPath}/selection">
<input type="text" name="selection">
<input type="submit" value="입력">
</form>
${selection_json}
</body>
</html>