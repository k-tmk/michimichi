<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:import url="layout/template_back.jsp">

	<c:param name="title" value="ログイン" />
	<c:param name="keywords" value="徳島 Coffee" />
	<c:param name="description" value="description。description" />
	<c:param name="content">

		<div id="wrap">
			<div id="main">
				<h1>管理者ログイン</h1>
				<div id="login">
					<form action="/michimichi/Login" method="post">
						<p>
							ユーザー名：<input type="text" name="login_id">
						</p>
						<p>
							パスワード：<input type="password" name="password">
						</p>
						<p>
							<input class="btns btn-send" type="submit" value="ログイン">
						</p>
					</form>
				</div>
			</div>
		</div>

	</c:param>
</c:import>