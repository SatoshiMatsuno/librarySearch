package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Const.Const;
import model.User;

public class LoginDao extends Dao {
	public User getLoginUserInfo(User userForSqlPram) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User loginUserInfo = new User();

		try {
			// ドライバ読み込み
			Class.forName(Const.DRIVER_NAME);

			// DB接続
			conn = getConnectDb(conn);

			// SQL文の作成とバインド処理
			pstmt = conn.prepareStatement("SELECT * FROM M_USER WHERE USER_ID = ? AND PASSWORD = ?");
			pstmt.setString(1, userForSqlPram.getUserId());
			pstmt.setString(2, userForSqlPram.getPassword());

			// SQL実行
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// 各パラメータ取得とuserオブジェクトへのセット
				String loginUserId = rs.getString("USER_ID");
				String loginUserName = rs.getString("USER_NAME");
				String loginUserPassword = rs.getString("PASSWORD");
				
				loginUserInfo.setUserId(loginUserId);
				loginUserInfo.setUserName(loginUserName);
				loginUserInfo.setPassword(loginUserPassword);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return loginUserInfo;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return loginUserInfo;
		} finally {
			// DB切断処理
			closeConnect(conn);
		}
		return loginUserInfo;

	}
}
