//package servlet;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import beams.LoginUser;
////import model.GetMutterListLogic;
////import model.Mutter;
////import model.PostMutterLogic;
////import model.Posts;
////import model.PostsLogic;
//
//
///**
// * Servlet implementation class Main
// */
//@WebServlet("/CtrlForCms")
//public class CtrlForCms extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public CtrlForCms() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		//ログインしている状態を確認する
//		HttpSession session = request.getSession();
//		LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
//		//ログインではない状態の場合は、ログイン画面へ
//		if (loginUser == null) {
//			RequestDispatcher dispatcher =
//					request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
//			dispatcher.forward(request, response);
//		}
//
//		//リクエストパラメータを取得する
//		//ページ番号
//		String para1 = request.getParameter("pge_id");
//		//そのページのコンテンツ番号
//		String para2 = request.getParameter("con_id");
//		String forward = "";
//		int pge_id = 0;
//		int con_id = 0;
//
//		//入力値チェック
//		if (para1 != null && para1.length() != 0) {
//			pge_id = Integer.parseInt(para1);
//		}
//		if (para2 != null && para2.length() != 0) {
//			con_id = Integer.parseInt(para2);
//		}
//
//		// リクエストスコープに保存
//		request.setAttribute("pge_id", pge_id);
//
//		//リクエストスコープに各ページ用情報保存、フォワード先を設定
//		if (pge_id==0) {
//			//My page
//			forward = movetoMypage(request);
//		} else if (pge_id==1) {
//			//つぶやき
//			forward = movetoMutter(request);
//		} else if (pge_id==2) {
//			//記事一覧
//			forward = movetoPostList(request);
//		} else if (pge_id==3) {
//			//menu一覧
//			forward = movetoMenuList(request);
//		} else if (pge_id==4) {
//			//アカウント一覧
//			forward = movetoAccoutList();
//		}else {
//			//My page
//			forward = movetoMypage(request);
//		}
//
//		//メイン画面にフォーワード
//		RequestDispatcher dispatcher =
//				request.getRequestDispatcher(forward);
//		dispatcher.forward(request, response);
//
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		//リクエストパラメータの取得
//		//		request.setCharacterEncoding("UTF-8");
//		String text = request.getParameter("text");
//
//		//入力値チェック
//		if (text != null && text.length()!=0 ) {
//
//			//セッションスコープに保存されたユーザー情報を取得
//			HttpSession session = request.getSession();
//			LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
//
//			//つぶやきのインスタンスを生成する
//			Mutter mutter = new Mutter(loginUser.getLogin_id(),text);
//
//			//つぶやきのインスタンスをテーブルに追加する
//			PostMutterLogic postMutterLogic = new PostMutterLogic();
//			postMutterLogic.execute(mutter);
//
//		}else {
//			//エラーメッセージをリクエストスコープに保存
//			request.setAttribute("errorMsg", "つぶやきが入力されていません");
//		}
//
//		//つぶやきリストを取得
//		GetMutterListLogic getMutterListLogic =
//				new GetMutterListLogic();
//		List<Mutter> mutterList = getMutterListLogic.execute();
//
//		//リクエストスコープに保存
////		request.setAttribute("mutterList", mutterList);
//
//		//メイン画面にフォワード
//		RequestDispatcher dispatcher =
//				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
//		dispatcher.forward(request, response);
//	}
//
//	private String movetoMenuList(HttpServletRequest request) {
//		// フォーワード先 "
//		String forward = "MenuEdit?menu_id=0";
//		return forward;
//	}
//
//	private String movetoPostList(HttpServletRequest request) {
//		// フォーワード先 "
//		String forward = "PostEdit?post_id=0";
//		return forward;
//	}
//
//	private String movetoAccoutList() {
//		// フォーワード先 "
//		String forward = "AccountEdit?user_id=0";
//		return forward;
//	}
//
////	private String movetoMutter(HttpServletRequest request) {
////		//つぶやきリストを取得
////		GetMutterListLogic getMutterListLogic =
////				new GetMutterListLogic();
////		List<Mutter> mutterList = getMutterListLogic.execute();
//
//		//リクエストスコープに保存
//		//request.setAttribute("mutterList", mutterList);
//
//		// フォーワード先 "
//		String forward = "/WEB-INF/jsp/mutter.jsp";
//		return forward;
//
//	}
//
//	private String movetoMypage(HttpServletRequest request) {
//		// 記事一覧を取得する
//		PostsLogic postslogic = new PostsLogic();
//		List<Posts> postList =  postslogic.getAllPosts(0);
//
//		//リクエストスコープに保存
//		request.setAttribute("postList", postList);
//
//		// フォーワード先 "
//		String forward = "/WEB-INF/jsp/mypage.jsp";
//		return forward;
//	}
//
//
//}
