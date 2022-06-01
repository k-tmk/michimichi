<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="beans.LoginUser,beans.Account,java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
	List<Account> accountList = (List<Account>) request.getAttribute("accountList");
	String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<link href="/cafeshop/css/style-cms.css" rel="stylesheet" media="all">
<title>どこつぶ アカウント管理</title>

</head>
<body>
	<div id="wrap">
		<p id="login">
			<%=loginUser.getLogin_id()%>さまオンライン中 <a href="/cafeshop/Logout">ログアウト</a>
		</p>
		<jsp:include page="../layout/header_back.jsp" />

		<h2>アカウント一覧</h2>

		<%
			if (errorMsg != null) {
		%>

		<p style="color: #ff0000;"><%=errorMsg%></p>

		<%
			} else {
		%>

		<form action="/cafeshop/Main" method="post">

			<p class="btn">
				<input class="btns btn-send" type="button" value="新規登録"
					onClick="location.href='/cafeshop/AccountEdit?fnc=1'">
			</p>

			<%
				if (accountList != null) {
			%>
			<table class="entryForm">
				<tr>
					<th class="subtitle">ID</th>
					<th class="subtitle">名前</th>
					<th class="subtitle">性別</th>
					<th class="subtitle">生年月日</th>
					<th class="subtitle">電話番号</th>
					<th class="subtitle">住所</th>
					<th class="subtitle">Email</th>
				</tr>
				<%
					for (Account account : accountList) {
				%>
				<tr>
					<td align="center"><%=account.getUser_id()%></td>
					<td><a
						href="/cafeshop/AccountEdit?user_id=<%=account.getUser_id()%>"><%=account.getName()%></a></td>
					<td align="center"><%=account.genderlist[account.getGender()]%></td>
					<td align="center"><%=account.getBirthday()%></td>
					<td><%=account.getTel()%></td>
					<td><%=account.getAddress()%></td>
					<td><%=account.getMail()%></td>
				</tr>
				<%
					}
				%>
			</table>
			<%
				}
			%>
		</form>
		<%
			}
		%>
		<br>
		<hr>
		<div id="opbtns">
			<a href="/cafeshop/CtrlForCms?pge_id=0">マイページ</a>
		</div>
	</div>
	<jsp:include page="../layout/footer_back.jsp" />

</body>
</html>