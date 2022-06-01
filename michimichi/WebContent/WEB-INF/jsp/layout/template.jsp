<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- META -->
<meta charset="utf-8">
<meta name="keywords" content="未知,未知の駅,みちのえき,道の駅,mitinoeki,徳島,tokusima,とくしま,四国,観光,温泉,遊ぶ,ツーリング,お出かけ,ドライブ,景色,家族で遊ぶ場,休息,休憩,産直市場,イベント,特産物,お土産,田舎,ご当地,インスタ映え,くるくるなると,ドイツ館,うだつの街並み,祖谷,鳴門,阿波,かずら橋">
<meta name="description" content="${param.description}">

<!-- META VIEWPOINT -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=2.0, user-scalable=yes" />

<!-- TITLE -->
<title>${param.title}</title>

<!-- CSS -->
<link href="<c:url value='css/base.css'/>" rel="stylesheet">
<link href="<c:url value='css/modaldlg.css'/>" rel="stylesheet">

<!-- 独自のCSS -->
<c:if test="${!empty param.mycss}">
	<link href="<c:url value="${param.mycss}" />" rel="stylesheet">
</c:if>
<c:if test="${!empty param.mycss2}">
	<link href="<c:url value="${param.mycss2}" />" rel="stylesheet">
</c:if>
<c:if test="${!empty param.mycss3}">
	<link href="<c:url value="${param.mycss3}" />" rel="stylesheet">
</c:if>

<!-- JS LINK -->
<script src="<c:url value="js/vendor/jquery-3.3.1.min.js" />"></script>

<!-- ローカルJS -->
<%-- js/script.jsは、～より下部で読み込む必要があるため、 --%>
<script src="<c:url value="js/script.js" />"></script>

<!-- 独自のJS -->
<c:if test="${!empty param.myjs}">
	<script src="<c:url value="${param.myjs}" />"></script>
</c:if>
<c:if test="${!empty param.myjs2}">
	<script src="<c:url value="${param.myjs2}" />"></script>
</c:if>
<c:if test="${!empty param.myjs3}">
	<script src="<c:url value="${param.myjs3}" />"></script>
</c:if>


<!-- icon -->
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<link rel="icon" href="favicon.ico">

</head>
<body>
	<jsp:include page="header_top.jsp" />
	<jsp:include page="navigation.jsp" />
	<div class="container">${param.content}</div>
	<jsp:include page="footer_top.jsp" />
</body>
</html>