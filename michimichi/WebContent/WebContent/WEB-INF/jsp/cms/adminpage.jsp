<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:import url="layout/template-back.jsp">

	<c:param name="title" value="My page" />
	<c:param name="keywords" value="徳島 Coffee" />
	<c:param name="description" value="description。description" />
	<c:param name="mycss" value="" />
	<c:param name="mycss2" value="" />
	<c:param name="myjs" value="js/vendor/lightbox_plus.js" />

	<c:param name="content">

		<div id="wrap">
			<p id="login">
				<c:out value="${loginUser.login_id }" />
				さまオンライン中 <a href="/cafeshop/Logout">ログアウト</a>
			</p>

			<section>
				<h1>マイページ</h1>
				<div id="opbtns">
					<a href="/michimichi/CtrlForCms?pge_id=1">コメント管理</a> <a
						href="/michimichi/CtrlForCms?pge_id=2">道の駅管理</a> <a
						href="/michimichi/CtrlForCms?pge_id=3">特集管理</a> <a
						href="/michimichi/CtrlForCms?pge_id=4">アカウント管理</a>
				</div>
			</section>

			<!-- <section>
				<h2>お知らせ</h2>
				<table class="entryForm">
					<tr>
						<th class="subtitle" width="18%">日時</th>
						<th class="subtitle" width="12%">発信者</th>
						<th class="subtitle" width="30%">タイトル</th>
						<th class="subtitle" width="40%">概要</th>
					</tr>
					<c:forEach var="post" items="${postList}" end="20">
						<tr>
							<td class="time"><fmt:formatDate type="time"
									value="${post.createtime}" pattern="yyyy/MM/dd HH:mm" /></td>
							<td class="name">${post.name}</td>
							<td class="title">${post.title}</td>
							<td class="mutter">${fn:escapeXml(post.summary)}</td>
						</tr>
					</c:forEach>
				</table>
			</section> -->
		</div>

	</c:param>
</c:import>