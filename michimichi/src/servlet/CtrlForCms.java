package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beams.LoginUser;


/**
 * Servlet implementation class Main
 * @param <CommentLogic>
 */
@WebServlet("/CtrlForCms")
public class CtrlForCms<CommentLogic> extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CtrlForCms() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//ログインしている状態を確認する
		HttpSession session = request.getSession();
		LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
		//ログインではない状態の場合は、ログイン画面へ
		if (loginUser == null) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}

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
		if (pge_id==0) {
			//管理者ページTOP
			forward = movetoAdminpage(request);
		} else if (pge_id==1) {
			//コメント一覧
			forward = movetoCommentList(request);
		} else if (pge_id==2) {
			//道の駅一覧
			forward = movetoStationList(request);
		} else if (pge_id==3) {
			//特集一覧
			forward = movetoFeatureList(request);
		} else if (pge_id==4) {
			//アカウント一覧
			forward = movetoAccoutList();
		}else {
			//管理者ページトップ
			forward = movetoAdminpage(request);
		}

		//メイン画面にフォーワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(forward);
		dispatcher.forward(request, response);

	}

	private String movetoFeatureList(HttpServletRequest request) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	private String movetostationlist(HttpServletRequest request) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	private String movetoCommentList(HttpServletRequest request) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	private String movetoAdminpage(HttpServletRequest request) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");

		//入力値チェック
		if (text != null && text.length()!=0 ) {

			//セッションスコープに保存されたユーザー情報を取得
			HttpSession session = request.getSession();
			LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");

			//コメントのインスタンスを生成する
			Comment comment = new Comment(loginUser.getLogin_id(),text);

			//つぶやきのインスタンスをテーブルに追加する
			CommentLogic postMutterLogic = new CommentLogic();
			postMutterLogic.execute(Comment);

		}else {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "つぶやきが入力されていません");
		}

		//つぶやきリストを取得
		GetMutterListLogic getMutterListLogic =
				new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();

		//リクエストスコープに保存
		request.setAttribute("mutterList", mutterList);



		//メイン画面にフォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/adminpage.jsp");
		dispatcher.forward(request, response);
	}

	private String movetoStationList (HttpServletRequest request) {
		// フォーワード先 "
		String forward = "StationEdit?Station_id=0";
		return forward;
	}

	private String movetoPostList(HttpServletRequest request) {
		// フォーワード先 "
		String forward = "PostEdit?post_id=0";
		return forward;
	}

	private String movetoAccoutList() {
		// フォーワード先 "
		String forward = "AccountEdit?user_id=0";
		return forward;
	}

	private String movetoMutter(HttpServletRequest request) {
		//つぶやきリストを取得
		GetMutterListLogic getMutterListLogic =
				new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();

		//リクエストスコープに保存
		request.setAttribute("mutterList", mutterList);

		// フォーワード先 "
		String forward = "/WEB-INF/jsp/mutter.jsp";
		return forward;

	}

	private String movetoMypage(HttpServletRequest request) {
		// 記事一覧を取得する
		CommentLogic commentlistlogic = new CommentLogic();
		List<Comment> CommentList =  commentlistlogic.getAllComment(0);

		//リクエストスコープに保存
		request.setAttribute("postList", commentlistlogic);

		// フォーワード先 "
		String forward = "/WEB-INF/jsp/admin.jsp";
		return forward;
	}


}
