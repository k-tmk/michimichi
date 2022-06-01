
//記事の表示・非表示処理ボタンクリックイベント
function postShowChange(id, showflag, title) {
	//alert("id:" + id + " showflag:" + showflag + " title:" + title);

	//Get the modal
	var modal = document.getElementById("myModal");
	modal.style.display = "block";

	//モーダル画面表示させる
	var msg1 = (showflag == 1) ? "表示" : "非表示";
	var msg2 = (showflag == 1) ? "非表示" : "表示";

	var msg = "「" + title + "」を";
	msg += msg1 + "から" + msg2 + "に変更します。";
	msg += "\nよろしいでしょうか。";
	//alert(msg);

	target= document.getElementById("modal-title");
	target.innerHTML = "記事の表示・非表示の切り替え処理";

	target= document.getElementById("modal-detail");
	target.innerHTML = msg;

	//post_idを送信フォームに代入
	target= document.getElementById("post_id");
	target.value = id;

	//表示の変更を送信フォームに代入
	target= document.getElementById("showflag");
	//showflagをひっくり返す
	var sf = (showflag == 1) ? 0:1;
	target.value = sf;

	//fncを送信フォームに代入 ４＝表示状態だけを変更
	target= document.getElementById("fnc");
	target.value = 4;
}

//menuの表示・非表示処理ボタンクリックイベント
function menuShowChange(id, showflag, title) {
	//alert("id:" + id + " showflag:" + showflag + " title:" + title);

	//Get the modal
	var modal = document.getElementById("myModal");
	modal.style.display = "block";

	//モーダル画面表示させる
	var msg1 = (showflag == 1) ? "表示" : "非表示";
	var msg2 = (showflag == 1) ? "非表示" : "表示";

	var msg = "「" + title + "」を";
	msg += msg1 + "から" + msg2 + "に変更します。";
	msg += "\nよろしいでしょうか。";
	//alert(msg);

	target= document.getElementById("modal-title");
	target.innerHTML = "メニューの表示・非表示の切り替え処理";

	target= document.getElementById("modal-detail");
	target.innerHTML = msg;

	//post_idを送信フォームに代入
	target= document.getElementById("menu_id");
	target.value = id;

	//表示の変更を送信フォームに代入
	target= document.getElementById("showflag");
	//showflagをひっくり返す
	var sf = (showflag == 1) ? 0:1;
	target.value = sf;

	//fncを送信フォームに代入 ４＝表示状態だけを変更
	target= document.getElementById("fnc");
	target.value = 4;
}

window.onload = function() {
	//複数のボタンのクリックイベント対応
	//var btnshow = document.getElementsByClassName("btnshow");
	//for (var i = 0; i < btnshow.length; i++) {
	//	btnshow[i].onclick = function(id, showflag) {
	//モーダル画面表示させる
	//		modal.style.display = "block";
	//	}
	//}

	//Get the modal
	var modal = document.getElementById("myModal");
	//Get the button that opens the modal
	//var btn = document.getElementById("myBtn");
	//Get the <span> element that closes the modal
	//When the user clicks the button, open the modal
	//btn.onclick = function() {
	//	modal.style.display = "block";
	//}

	var span = document.getElementsByClassName("close")[0];
	//When the user clicks on <span> (x), close the modal
	span.onclick = function() {
		modal.style.display = "none";
	}

	//When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
}

$(function () {

	$(window).on('load', function() {

		//トップページの新着ニュースの詳細表示
		$('a.post-item').on('click',function() {

			$this = $(this);
			var post_id = $(this)[0].getAttribute('post_id');
//			alert(post_id);
			var dlgTag;

			var request = {
					"post_id": post_id
			};

			$.ajax({
				type: "GET",
				url: "/cafeshop/ModalDLG",
				data: request,
				dataType:'json',
				async: true,
				success: function(data) {

					var typename = data["typename"];
					var title = data["title"];
					var content = data["content"];
					var img_path = "img/ph_staff.jpg";
					var name = data["name"];
					var createtime = data["createtime"];

					dlgTag =
						'<div id="modal_container" class="modal_container">' +
						'<p class="button_box"><a id="modal_close" class="link_button">x</a></p>' +
						'<div class="modal_inner">' +
						'	<img src="' + img_path + '" alt="' + title + '">' +
						'	<div class="modal_info">' +
						'		<h3 class="modal_tittle">' + title + '</h3>' +
						'		<p class="modal_name">' + name + ' ' + createtime + '</p>' +
						'		<p class="modal_overview">' + content + '</p>' +
						'	</div>' +
						'</div>' +
						'</div>';

//					alert(dlgTag);

					$('body').append(dlgTag);
					$('body').append('<div id="modal_overlay"></div>');
					$('#modal_overlay').fadeIn('slow');
					$('#modal_container').css('display','flex');
					$('#modal_overlay,#modal_close').unbind().on('click',function(){
						$('#modal_container,#modal_overlay').fadeOut("slow",function(){
							$('#modal_container').remove();
							$("#modal_overlay").remove();
						});
					});
				}
			});
		});
	});

});