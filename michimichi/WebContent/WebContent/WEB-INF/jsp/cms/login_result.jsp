<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.LoginUser"%>
<%
	LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<link href="/cafeshop/css/style-cms.css" rel="stylesheet" media="all">
<title>どこつぶ</title>
</head>
<body>
	<div id="wrap">
		<jsp:include page="layout/header-back.jsp" />

		<%
			if (loginUser != null) {
		%>

		<p>
			ようこそ <a
				href="/cafeshop/AcountEdit&user_id=<%=loginUser.getLogin_id()%>">
				<%=loginUser.getLogin_id()%>
			</a> さま
		</p>

		<p>
			<a href="/cafeshop/CtrlFroCms">つぶやき投稿・閲覧へ</a>
		</p>

		<%
			} else {
		%>
		<p>
			ロングインが失敗しました。<br>再度ログインしてください。
		</p>
		<p>
			<a href="/cafeshop/">TOPへ</a>
		</p>
		<%
			}
		%>

		<hr>
		<br>
		<jsp:include page="layout/footer-back2.jsp" />
	</div>
</body>
</html>