package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Const.Const;
import model.Genre;

public class BookGenreDao  extends Dao {
	public List<Genre> getGenreList() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Genre> genreList = new ArrayList<Genre>();

		try {
			// ドライバ読み込み
			Class.forName(Const.DRIVER_NAME);

			// DB接続
			conn = getConnectDb(conn);

			// SQL文の作成
			pstmt = conn.prepareStatement("SELECT * FROM M_GENRE");

			// SQL実行
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// DBから取得した分類コードと分類名を分類リストに格納
				Genre genre = new Genre();
				genre.setGenreCode(rs.getString("GENRE_CD"));
				genre.setGenreName(rs.getString("GENRE_NAME"));
				genreList.add(genre);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return genreList;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return genreList;
		} finally {
			// DB切断処理
			closeConnect(conn);
		}
		return genreList;

	}
}
