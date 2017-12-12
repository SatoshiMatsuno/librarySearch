package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Const.Const;
import model.EntryBookInfo;
import model.User;

public class EntryBookDao extends Dao {
	public boolean entryBookInfo(EntryBookInfo entryBookInfo, User loginUserInfo) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// ドライバ読み込み
			Class.forName(Const.DRIVER_NAME);

			// DB接続
			conn = getConnectDb(conn);

			// 自動コミットオフ
			conn.setAutoCommit(false);
			
			// SQL文の作成とバインド処理
			pstmt = conn.prepareStatement("INSERT INTO M_BOOK (GENRE_CD, BOOK_CD, TITLE, KANA, AUTHOR, COMPACT_DISC_NUMBER, REMARKS, PUBLISHER, FIRST_DATE, REG_DATE, DELETE_DATE, DELETE_FLAG, UPDATE_TIME_STAMP, INSERT_TIME_STAMP, USER_ID) VALUES (?, NVL((SELECT TO_CHAR((MAX(TO_NUMBER(BOOK_CD))+1),'FM009') FROM M_BOOK WHERE GENRE_CD=?),'001'), ?, ?, ?, ?, ?, ?, ?, TO_CHAR(SYSDATE, 'yyyy/mm/dd'), null, 0, SYSTIMESTAMP, SYSTIMESTAMP, ?)");

			pstmt.setString(1, entryBookInfo.getGenreCode());
			pstmt.setString(2, entryBookInfo.getGenreCode());
			pstmt.setString(3, entryBookInfo.getTitle());
			pstmt.setString(4, entryBookInfo.getKana());
			pstmt.setString(5, entryBookInfo.getAuthor());
			pstmt.setInt(6, entryBookInfo.getCompactDiscNum());
			pstmt.setString(7, entryBookInfo.getRemarks());
			pstmt.setString(8, entryBookInfo.getPublisher());
			pstmt.setString(9, entryBookInfo.getFirstDate());
			pstmt.setString(10, loginUserInfo.getUserId());
			
			// SQL実行
			int result = pstmt.executeUpdate();
			
			// 実行結果が1だったらコミット。それ以外だったらロールバック。
			if (result == 1) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
			// Exceptionにする。
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} finally {
			// DB切断処理
			closeConnect(conn);
		}

		return true;
	}
}
