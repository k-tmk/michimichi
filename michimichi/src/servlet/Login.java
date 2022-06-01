package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LoginUser;
import model.LoginLogic;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメータの取得
//		request.setCharacterEncoding("UTF-8");

		String login_id = request.getParameter("login_id");
		String pass = request.getParameter("pass");

		//LoginUserインスタンスの生成
		LoginUser login = new LoginUser(login_id,pass);

		//ログイン
		LoginLogic loginLogic = new LoginLogic();
		LoginUser loginUser = loginLogic.execute(login);

		if(loginUser!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser",loginUser);
			response.sendRedirect("/michimichi/CtrlForCms?pge_id=0");
		}else {

			String forward = "/WEB-INF/jsp/loginResult.jsp";
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(forward);
			dispatcher.forward(request, response);
		}
	}

}
