<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:import url="layout/template.jsp">

	<c:param name="title" value="特集記事一覧（仮）" />
	<!-- <c:param name="keywords" value="徳島,Coffee,Cafe Leaf" /> -->
	<c:param name="description" value="description。description" />
	<c:param name="mycss" value="" />
	<c:param name="mycss2" value="" />
	<c:param name="myjs" value="" />

	<c:param name="content">

		<section id="menu" class="section">
			<h2 class="list">
				特集一覧じゃよ～～～
			</h2>
			<ul class="pc-grid-col3 menu-list">
				<c:forEach var="list" items="${FLList}" end="5">
					<li class="col"><img src="${list.main_photo_path}"
						alt="${list.alt}">
						<p class="menu-text">${list.feature_name}<br>
						<a href="/CtrlForFront?pge_id=9&con_id=${list.feature_id}">こっちじゃよ</a>
						</p></li>
				</c:forEach>

			</ul>
		</section>

	</c:param>
</c:import>