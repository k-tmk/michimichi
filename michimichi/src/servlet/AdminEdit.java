package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beams.LoginUser;
import dao.M_accountsDAO;
import model.Account;

/**
 * Servlet implementation class AccountEdit
 */
@WebServlet("/AccountEdit")
public class AdminEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminEdit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//ログインの状態をチェックする
		HttpSession session = request.getSession();
		LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");

		if(loginUser == null) {
			//ログイン画面へリダイレクト
			response.sendRedirect("/cafeshop/CtrlForCms");
		}

		String forward = "";
		int user_id = 0;

		//リクエストパラメータを取得する
		String str = request.getParameter("user_id");
		String str1 = request.getParameter("fnc");
		int fnc = 0;
		if(str1 != null) {
			fnc = Integer.parseInt(str1);
		}

		if(fnc==1) {
			//アカウントの新規登録
			forward = "/WEB-INF/jsp/accountEdit.jsp";
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(forward);
			dispatcher.forward(request, response);
		}

		if(str != null) {
			user_id = Integer.parseInt(str);
		}

		//データを読み込む処理
		M_accountsDAO accountDAO = new M_accountsDAO();
		if(user_id > 0) {
			//指定したuser_idで該当アカウントを読み込む
			Account account = accountDAO.findByUserid(user_id);

			if(account != null) {
				request.setAttribute("account", account);
			}else {
				request.setAttribute("errorMsg", "アカウントを読み込むにエラーが発生しました。");
			}
			forward = "/WEB-INF/jsp/accountEdit.jsp";

		}else if(user_id == 0){

			//全アカウントを読み込み
			List<Account> accountList = accountDAO.findAll();
			//リクエストスコープにaccountListを保存する
			if(accountList != null) {
				request.setAttribute("accountList", accountList);
			}else {
				request.setAttribute("errorMsg", "アカウント一覧を読み込むにエラーが発生しました。");
			}
			forward = "/WEB-INF/jsp/accountList.jsp";
		}

		RequestDispatcher dispatcher =
				request.getRequestDispatcher(forward);
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//ログインの状態をチェックする
		HttpSession session = request.getSession();
		LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");

		if(loginUser == null) {
			//ログイン画面へリダイレクト
			response.sendRedirect("/cafeshop/CtrlForCms");
		}

//		request.setCharacterEncoding("UTF-8");

		String str;
		int fnc = 0;		//操作キー　0=なし　1=新規　2=更新　3=削除
		int user_id = 0;	//ユーザーID　0=指定なし　Null=新規　>0　更新
		String forward = "";

		str = request.getParameter("fnc");
		if(str != null) {
			fnc = Integer.parseInt(str);
		}
		str = request.getParameter("user_id");
		if(str != null) {
			user_id = Integer.parseInt(str);
		}

		M_accountsDAO accountDAO = new M_accountsDAO();
		Account account;

		//入力されたアカウントデータを取得してaccountに代入する
		String login_id = request.getParameter("login_id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");

		//お誕生日処理
		String date = request.getParameter("birthday");
		Date birthday = changeDate(date);

		int gender = Integer.parseInt(request.getParameter("gender"));
		String postcode = request.getParameter("postcode");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String mail = request.getParameter("mail");

		//現時点のシステム日時を取得する
		Date createtime = new Date();

		account = new Account(user_id,login_id,pass,name,birthday,gender,
				postcode,address,tel,mail,createtime);

		//新規アカウント挿入
		if(fnc == 1) {

			//データベースに挿入する
			boolean bret = accountDAO.insert(account);
			if(bret == false) {
				request.setAttribute("errorMsg", "アカウントの新規挿入にエラーが発生しました");
				request.setAttribute("account", account);
				forward = "/WEB-INF/jsp/accountEdit.jsp";

			}else {
				//データベースからすべてのアカウントを読み込む
				List<Account> accountList = accountDAO.findAll();
				request.setAttribute("accountList", accountList);
				forward = "/WEB-INF/jsp/accountList.jsp";
			}

			//更新
		}else if(fnc == 2){

			//データベースに挿入する
			boolean bret = accountDAO.update(account);
			if(bret == false) {
				request.setAttribute("errorMsg", "アカウントの更新にエラーが発生しました");
				request.setAttribute("account", account);
				forward = "/WEB-INF/jsp/accountEdit.jsp";

			}else {
				//データベースからすべてのアカウントを読み込む
				List<Account> accountList = accountDAO.findAll();
				request.setAttribute("accountList", accountList);
				forward = "/WEB-INF/jsp/accountList.jsp";
			}

		//削除
		}else if(fnc == 3){
			if(user_id > 0) {
				//指定したuser_idで該当アカウントを読み込む
				boolean bret = accountDAO.delete(user_id);

				if(bret == false) {
					request.setAttribute("errorMsg", "アカウントを削除する時にエラーが発生しました。");
					//該当データを読み込む
					account = accountDAO.findByUserid(user_id);
					request.setAttribute("account", account);
					forward = "/WEB-INF/jsp/accountEdit.jsp";
				}else{
					//データベースからすべてのアカウントを読み込む
					List<Account> accountList = accountDAO.findAll();
					request.setAttribute("accountList", accountList);
					forward = "/WEB-INF/jsp/accountList.jsp";
				}
			}
		}

		RequestDispatcher dispatcher =
				request.getRequestDispatcher(forward);
		dispatcher.forward(request, response);

	}

	/**
	 * 文字列を日付に変換する
	 * @param strDate
	 * @return
	 */
	public static Date changeDate(String strDate) {
        if (strDate == null || strDate.length() != 10) {
            return null;
        }
        DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        dft.setLenient(false);
        try {
        	Date dd = dft.parse(strDate);
            return dd;
        } catch (Exception e) {
            return null;
        }
    }


}
