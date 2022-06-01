<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:import url="layout/template.jsp">

	<c:param name="title" value="Cafe Leaf　美しい" />
	<!-- <c:param name="keywords" value="徳島,Coffee,Cafe Leaf" /> -->
	<c:param name="description" value="description。description" />
	<c:param name="mycss" value="test.css" />
	<c:param name="mycss2" value="" />
	<c:param name="myjs" value="" />

	<c:param name="content">


		<a herf="/CtrlForFront?pge_id=1">TOP</a>
		<a herf="/CtrlForFront?pge_id=3">記事一覧</a>
		<a herf="/CtrlForFront?pge_id=4&con_id=1">記事個別＿ID1</a>

		<!-- 		<main id="contents" class="contents">
			<div class="container">

				<section id="menu" class="section">
					<h2 class="heading">
						Pickup Menu <a href="menu" class="more">more</a>
					</h2>
					<ul class="pc-grid-col3 menu-list">

						<c:forEach var="menu" items="${menulist}" end="5">
							<li class="col"><img src="${menu.img_path1 }"
								alt="${menu.title}">
								<p class="menu-text">${menu.title}<br>
									<b>${menu.price}円</b>
								</p></li>
						</c:forEach>

					</ul>
				</section>
				<!-- menu -->

				<div class="pc-grid-col2">
					<section id="info" class="col section">
						<h2 class="heading">
							Information <a href="" class="more">more</a>
						</h2>
						<dl class="info-list">
							<c:forEach var="post" items="${postslist}" end="4">
								<dt>
									<fmt:formatDate type="time" value="${post.createtime}"
										pattern="yyyy/MM/dd HH:mm" />
								</dt>
								<dd>
									<a class="post-item" href="#cancel" post_id="${post.post_id}">${post.title}</a>
								</dd>
							</c:forEach>
						</dl>
					</section>
					<!-- info -->

					<section id="staff" class="col section">
						<div class="staff-photo">
							<img src="img/ph_staff.jpg" alt="スタッフ近影">
						</div>
						<div class="staff-msg">
							<h2 class="staff-heading">スタッフから一言</h2>
							<%
							String str="ティーインストラクターの\n資格を持つスタッフが、\n 一杯ずつ丁寧にお入れします。";
							str=str.replaceAll("\\n","<BR>" );
							%>
							<p class="staff-text"><%=str %></p>
						</div>
					</section>
					<!-- staff -->

				</div>
				<!-- grid -->

				<section id="access" class="section">
					<h2 class="heading">Access</h2>

					<div class="map">
						<iframe
							src="https://www.google.com/maps/embed?pb=!1m16!1m12!1m3!1d3241.177172339873!2d139.72505595!3d35.672639249999996!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!2m1!1z5p2x5Lqs6YO95riv5Yy66Z2S5bGxMS0x!5e0!3m2!1sja!2sjp!4v1439816808418"
							width="600" height="450" frameborder="0" style="border: 0"
							allowfullscreen></iframe>
					</div>
					<!-- map -->

					<div class="add">
						<p>東京都港区青山1-x-x 第一青山ビル1F</p>
						<p>
							<a href="tel:03-0000-0000" class="btn-tel">03-0000-0000</a>
						</p>
					</div>
				</section>
				<!-- intro -->

				<aside id="banner" class="section">
					<ul class="pc-grid-col3 banner-list">

						<li class="col"><a href=""><img src="img/bnr_blog.jpg"
								alt="ブログ始めました"></a></li>
						<li class="col"><a href=""><img src="img/bnr_lesson.jpg"
								alt="紅茶教室のご案内"></a></li>
						<li class="col"><a href=""><img src="img/bnr_recipe.jpg"
								alt="焼き菓子レシピ"></a></li>
					</ul>
				</aside>
				<!-- banner -->

			</div>
			<!-- container -->

		</main>
		<!-- main -->


		 -->
	</c:param>
</c:import>
