package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.LoginLogic;
import model.Genre;
import model.User;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session = request.getSession();
		List<String> errorMsgList = new ArrayList<String>();

		// リクエストパラメータ取得
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		// ログイン処理
		User user = new User(userId, password);
		LoginLogic loginLogic = new LoginLogic();
		User loginUserInfo = loginLogic.login(user);

		// DBからユーザ情報が取得できなかったとき、エラーメッセージを返す。
		if (loginUserInfo.getUserName() == null) {
			errorMsgList.add("ログインに失敗しました");
			request.setAttribute("errorMsgList", errorMsgList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
			dispatcher.forward(request, response);
//			response.sendRedirect("/Login.jsp");
		} else {
			// ログイン成功
			// 分類リスト収録処理
			List<Genre> genreList = loginLogic.getGenreList();
			
			// ユーザー情報と分類リストをセッションに保存
			session.setAttribute("loginUserInfo", loginUserInfo);
			session.setAttribute("genreList", genreList);
			
			// フォワード処理
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Search.jsp");
			dispatcher.forward(request, response);
		}
	}
}
