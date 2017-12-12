package model;

import java.util.Date;

public class EntryBookInfo {
	
	// 分類コード
	private String genreCode;
	private String bookCode;
	private String title;
	private String kana;
	private String author;
	private int compactDiscNum;
	private String remarks;
	private String publisher;
	private String firstDate;
	private Date regDate;
	private Date deleteDate;
	private int deleteFlag;
	private Date updateTimeStamp;
	private Date insertTimeStamp;
	private String userId;
	
	// コンストラクタ
	public EntryBookInfo () {
		
	}

	public String getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKana() {
		return kana;
	}

	public void setKana(String kana) {
		this.kana = kana;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getCompactDiscNum() {
		return compactDiscNum;
	}

	public void setCompactDiscNum(int compactDiscNum) {
		this.compactDiscNum = compactDiscNum;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getFirstDate() {
		return firstDate;
	}

	public void setFirstDate(String firstDate) {
		this.firstDate = firstDate;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Date getUpdateTimeStamp() {
		return updateTimeStamp;
	}

	public void setUpdateTimeStamp(Date updateTimeStamp) {
		this.updateTimeStamp = updateTimeStamp;
	}

	public Date getInsertTimeStamp() {
		return insertTimeStamp;
	}

	public void setInsertTimeStamp(Date insertTimeStamp) {
		this.insertTimeStamp = insertTimeStamp;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
