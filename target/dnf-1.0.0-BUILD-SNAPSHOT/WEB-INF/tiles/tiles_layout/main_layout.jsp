<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"     uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"    uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"   uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<!-- meta tags -->
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Pragma" content="no-cache" />

<!-- script tag -->
<script src="/js/jquery.min.js"></script>

<!-- favicon / 임시 -->
<!-- TODO 21.03.22 ico 파일 및 이미지 교체 필요 -->
<link rel="icon" href="/img/favicon.png" sizes="16x16">

<!-- css links -->
<link rel="stylesheet" href="/css/main_layout.css"/>

<!-- title -->
<title>Ogmaloan</title>
</head>
<body>
	<!-- Wrapper -->
	<div id="wrapper">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</div>
</body>
<div id="bg"></div>
</html>