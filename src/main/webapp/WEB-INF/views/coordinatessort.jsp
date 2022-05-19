<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coordinates sort</title>
</head>
<body>
<form method="get" action="${contextPath}/coordinates">
좌표를 아래의 예시와 같이 입력하십시오.<br>
예 : (2,6),(1,-1),(3,6),(-2,1),(1,3)<br>
<input type="text" name="coordinates">
<input type="submit" value="입력">
</form>
${coordinates_json}
</body>
</html>