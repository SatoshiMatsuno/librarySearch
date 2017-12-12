package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.EntryBookLogic;
import model.EntryBookInfo;
import model.User;

/**
 * Servlet implementation class Entry
 */
@WebServlet("/Entry")
public class Entry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EntryBookInfo entryBookInfo = new EntryBookInfo();
		EntryBookLogic entryBookLogic = new EntryBookLogic();
		String errorMsg = "";

		// リクエストパラメータから必要項目をゲット
		String genreCode = request.getParameter("genreCode");
		String title = request.getParameter("title");
		String kana = request.getParameter("kana");
		String author = request.getParameter("author");
		String compactDiscNum = request.getParameter("compactDiscNum");
		String remarks = request.getParameter("remarks");
		String publisher = request.getParameter("publisher");
		String firstDate = request.getParameter("firstDate");
		
		// getしたパラメータをEntryBookInfoオブジェクトにset
		entryBookInfo.setGenreCode(genreCode);
		entryBookInfo.setTitle(title);
		entryBookInfo.setKana(kana);
		entryBookInfo.setAuthor(author);
		entryBookInfo.setCompactDiscNum(Integer.parseInt(compactDiscNum));
		entryBookInfo.setRemarks(remarks);
		entryBookInfo.setPublisher(publisher);
		entryBookInfo.setFirstDate(entryBookLogic.changeformat(firstDate));
		
		// セッションからユーザIDを取得
		User loginUserInfo = (User) session.getAttribute("loginUserInfo");
		
		// 登録処理
		boolean result = entryBookLogic.entryBookInfo(entryBookInfo, loginUserInfo);
		
		if (result) {
			errorMsg = "登録に成功しました。";
		} else {
			errorMsg = "登録に失敗しました。";
		}
		
		System.out.println(errorMsg);

		// フォワード処理
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Entry.jsp");
		dispatcher.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 登録画面において戻るボタンを押したときの処理
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Search.jsp");
		dispatcher.forward(request, response);
	}

}
