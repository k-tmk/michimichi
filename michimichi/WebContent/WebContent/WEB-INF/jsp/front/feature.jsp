<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:import url="layout/template.jsp">

	<c:param name="title" value="${FList.feature_name}" />
	<!-- <c:param name="keywords" value="徳島,Coffee,Cafe Leaf" /> -->
	<c:param name="description" value="description。description" />
	<c:param name="mycss" value="" />
	<c:param name="mycss2" value="" />
	<c:param name="myjs" value="" />

	<c:param name="content">

		<section id="menu" class="section">
			<h2 class="list">
				特集記事ですわよ～～～！
			</h2>
			<c:forEach var="list" items="${FList}">
			名前：<c:out value="${list.feature_name}"/>
			コンテンツ：<c:out value="${list.content}"/>
			タイプ種別：<c:out value="${list.feature_type_name}"/>
			<img src="${list.photo_path1 }"alt="${list.alt1}" />
			</c:forEach>

		</section>

	</c:param>
</c:import>