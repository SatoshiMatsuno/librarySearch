package logic;

import java.util.List;

import dao.BookGenreDao;
import dao.LoginDao;
import model.Genre;
import model.User;

public class LoginLogic {

	LoginDao logindao = new LoginDao();
	BookGenreDao bookGenreDao = new BookGenreDao();

	public User login(User user) {

		User loginUserInfo = logindao.getLoginUserInfo(user);
		String loginUserName = loginUserInfo.getUserName();

		// ユーザ情報が取得出来ていたらtrueを返す。
		if (loginUserName != null) {
			return loginUserInfo;
		} else {
			return loginUserInfo;
		}
	}
	
	public List<Genre> getGenreList() {
		List<Genre> genreList = bookGenreDao.getGenreList();
		return genreList;
	}
}
