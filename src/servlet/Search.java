package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO 登録画面の実装が終わったら検索画面を実装
		
		// 検索画面で選んでいたプルダウン項目を登録画面に渡す。
		String firstPramGenreName = request.getParameter("genre");
		
		request.setAttribute("firstPramGenreName", firstPramGenreName);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Entry.jsp");
		dispatcher.forward(request, response);
	}
}
