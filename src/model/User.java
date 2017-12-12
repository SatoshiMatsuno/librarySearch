package model;

import java.io.Serializable;

public class User implements Serializable {

	// ユーザID
	private String userId;
	// ユーザ名
	private String userName;
	// パスワード
	private String password;

	// コンストラクタ
	public User() {
	}

	public User(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	public User(String userId, String userName, String password) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId (String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName (String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword (String password) {
		this.password = password;
	}
}
