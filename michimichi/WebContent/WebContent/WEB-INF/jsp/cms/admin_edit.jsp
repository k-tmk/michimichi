<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="beams.LoginUser,model.Account,java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
	Account account = (Account) request.getAttribute("account");
	String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<link href="/cafeshop/css/style-cms.css" rel="stylesheet" media="all">

<title>アカウント管理</title>


<script type="text/javascript">
<!--
	function check(fnc) {
		var str;

		if (fnc == 1) {
			str = 'アカウントを登録します。よろしいですか？';
		} else if (fnc == 2) {
			str = 'アカウントを更新します。よろしいですか？';
		} else if (fnc == 3) {
			str = 'アカウントを削除します。よろしいですか？';
		}

		if (window.confirm(str)) {
			var ele = document.createElement('input');
			// データを設定
			ele.setAttribute('type', 'hidden');
			ele.setAttribute('name', 'fnc');
			ele.setAttribute('value', fnc);
			// 要素を追加
			document.inputForm.appendChild(ele);

			return true;

		} else {
			//window.alert('キャンセルされました');
			return false;
		}
	}
// -->
</script>

</head>
<body>
	<div id="wrap">
		<p id="login">
			<%=loginUser.getLogin_id()%>さまオンライン中 <a href="/michimichi/Logout">ログアウト</a>
		</p>

		<jsp:include page="layout/header-back.jsp" />

		<%
			if (account != null) {
		%>
		<h2>アカウント編集</h2>
		<%
			} else {
		%>
		<h2>アカウント新規登録</h2>
		<%
			}
		%>

		<%
			if (errorMsg != null) {
		%>
		<p style="color: #ff0000;"><%=errorMsg%></p>
		<%
			}
		%>

		<!-- 編集 -->
		<form name="inputForm" action="/cafeshop/AccountEdit" method="post">
			<%
				if (account != null) {
			%>
			<table class="entryForm">
				<tr>
					<th width="20">名前</th>
					<td width="80%"><input type="text" name="name"
						value="<%=account.getName()%>" size="20" required></td>
				</tr>
				<tr>
					<th width="20%">性別</th>
					<td width="80%">
						<%
							if (account.getGender() == 0) {
						%> <input type="radio" name="gender" value="0" checked="checked">男
						<input type="radio" name="gender" value="1">女 <%
 	} else {
 %> <input type="radio" name="gender" value="0">男 <input
						type="radio" name="gender" value="1" checked="checked">女 <%
 	}
 %>
					</td>
				</tr>
				<tr>
					<th width="20%">生年月日</th>
					<td width="80%"><input type="date" name="birthday"
						value="<%=account.getBirthday()%>" size="20"></td>
				</tr>
				<tr>
					<th width="20%">ログインID</th>
					<td width="80%"><input type="text" name="login_id"
						value="<%=account.getLogin_id()%>" size="20" required></td>
				</tr>
				<tr>
					<th width="20%">パスワード</th>
					<td width="80%"><input type="password" name="pass"
						value="<%=account.getPass()%>" size="20" required></td>
				</tr>
				<tr>
					<th width="20%">郵便番号</th>
					<td width="80%"><input type="text" name="postcode"
						value="<%=account.getPost_code()%>" size="8"></td>
				</tr>
				<tr>
					<th width="20%">住所</th>
					<td width="80%"><input type="text" name="address"
						value="<%=account.getAddress()%>" size="60"></td>
				</tr>
				<tr>
					<th width="20%">電話番号</th>
					<td width="80%"><input type="tel" name="tel"
						value="<%=account.getTel()%>" size="20"></td>
				</tr>
				<tr>
					<th width="20%">電子メール</th>
					<td width="80%"><input type="email" name="mail"
						value="<%=account.getMail()%>" size="60" required></td>
				</tr>
			</table>
			<!-- 隠すデータ -->
			<input type="hidden" name="user_id" value="<%=account.getUser_id()%>">
			<p class="btn">
				<%
					if (account.getUser_id() != -1) {
				%>
				<input class="btns btn-clear" type="submit" name="delete" value="削除"
					onClick="return check(3)">
				<%
					}
				%>

				<%
					if (account.getUser_id() == -1) {
				%>
				<input class="btns btn-send" type="submit" name="save" value="登録"
					onClick="return check(1)">
				<%
					} else {
				%>
				<input class="btns btn-send" type="submit" name="save" value="登録"
					onClick="return check(2)">
				<%
					}
				%>
			</p>
			<!-- 新規登録-->
			<%
				} else {
			%>
			<input type="hidden" name="user_id" value="-1">
			<table class="entryForm">
				<tr>
					<th width="20">名前</th>
					<td width="80%"><input type="text" name="name" size="20"
						required></td>
				</tr>
				<tr>
					<th width="20%">性別</th>
					<td width="80%"><input type="radio" name="gender" value="0"
						checked="checked">男 <input type="radio" name="gender"
						value="1">女</td>
				</tr>
				<tr>
					<th width="20%">生年月日</th>
					<td width="80%"><input type="date" name="birthday"
						value="1990-01-01"></td>
				</tr>
				<tr>
					<th width="20%">ログインID</th>
					<td width="80%"><input type="text" name="login_id"
						autocomplete="off" size="20" required></td>
				</tr>
				<tr>
					<th width="20%">パスワード</th>
					<td width="80%"><input type="password" name="pass"
						autocomplete="off" size="20" required></td>
				</tr>
				<tr>
					<th width="20%">郵便番号</th>
					<td width="80%"><input type="text" name="postcode" size="8">
					</td>
				</tr>
				<tr>
					<th width="20%">住所</th>
					<td width="80%"><input type="text" name="address" size="60">
					</td>
				</tr>
				<tr>
					<th width="20%">電話番号</th>
					<td width="80%"><input type="tel" name="tel" size="20"
						required></td>
				</tr>
				<tr>
					<th width="20%">電子メール</th>
					<td width="80%"><input type="email" name="mail" size="60"
						required></td>
				</tr>
			</table>
			<p class="btn">
				<input class="btns btn-clear" type="reset" value="クリア"> <input
					class="btns btn-send" type="submit" value="登録"
					onClick="return check(1)">
			</p>
			<%
				}
			%>
		</form>
		<br>
		<hr>
		<div id="opbtns">
			<a href="/cafeshop/CtrlForCms?pge_id=0">マイページ</a> <a
				href="/cafeshop/CtrlForCms?pge_id=4">アカウント一覧</a>
		</div>
	</div>
	<jsp:include page="layout/footer-back.jsp" />
</body>
</html>