package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Menu;
import model.MenuLogic;
import model.Posts;
import model.PostsLogic;

/**
 * Servlet implementation class CtrlForFront
 */
@WebServlet("/CtrlForFront")
public class CtrlForFront extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public CtrlForFront() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得する
		//ページ番号
		String para1 = request.getParameter("pge_id");
		//そのページのコンテンツ番号
		String para2 = request.getParameter("con_id");
		String forward = "";
		int pge_id = 0;
		int con_id = 0;

		//入力値チェック
		if (para1 != null && para1.length() != 0) {
			pge_id = Integer.parseInt(para1);
		}
		if (para2 != null && para2.length() != 0) {
			con_id = Integer.parseInt(para2);
		}

		// リクエストスコープに保存
		request.setAttribute("pge_id", pge_id);

		//リクエストスコープに各ページ用情報保存、フォワード先を設定
		if (pge_id==1) {
			//トップページ
			forward = movetoTop(request);
		} else if (pge_id==2) {
			//コンセプトページ
			//forward = movetoConcept(request);
			//未作成なので、とりあえずトップへ
			forward = movetoTop(request);
		} else if (pge_id==3) {
			//メニューページ
			//forward = movetoMenu(request);
			//未作成なので、とりあえずトップへ
			forward = movetoTop(request);
		} else if (pge_id==4) {
			//CMS用ログインページ
			forward = movetoLogin();
		} else {
			//トップページ
			forward = movetoTop(request);
//			System.out.println("forward:" + forward);
		}

		//メイン画面にフォーワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(forward);
		dispatcher.forward(request, response);
	}

	private String movetoMenu(HttpServletRequest request) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	private String movetoConcept(HttpServletRequest request) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	private String movetoLogin() {
		// フォーワード先 "
		String forward = "WEB-INF/jsp/login.jsp";
		return forward;
	}


	/**
	 * トップページフォワード前処理
	 *
	 * @return フォワード用パス
	 */
	private String movetoTop(HttpServletRequest request) {
		final int SHOWFALG = 1; //一覧に表示するものだけ

		// 記事一覧を取得する
		PostsLogic postslogic = new PostsLogic();
		List<Posts> postslist =  postslogic.getAllPosts(SHOWFALG);
//		System.out.println("movetoTop:");

		// メニュー一覧を取得する
		MenuLogic menulogic = new MenuLogic();
		List<Menu> menulist = menulogic.getAllMenu(SHOWFALG);

//		System.out.print(menulist.get(0));

		// リクエストスコープに保存
		request.setAttribute("postslist", postslist);
		request.setAttribute("menulist", menulist);

		// フォーワード先 "
		String forward = "WEB-INF/jsp/top.jsp";
		return forward;
	}

}
