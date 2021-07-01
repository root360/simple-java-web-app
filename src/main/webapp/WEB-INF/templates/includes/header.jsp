<%@ include file="init.jsp"%>
<c:if test="${not empty param.pageName}"> 
    <c:set var="pageName" value="${param.pageName}" />
</c:if>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="${pageContext.request.contextPath}/assets/images/favicon.ico">
        <title>${pageName} - root360 - simple Java App with Tomcat</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/bootstrap/4.1.3/css/bootstrap.min.css">
      </head>
    <body>
