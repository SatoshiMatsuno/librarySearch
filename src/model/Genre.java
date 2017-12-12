package model;

public class Genre {
	
	// 分類コード
	private String genreCode;
	// 分類名
	private String genreName;
	
	// コンストラクタ
	public Genre () {
		
	}
	
	public String getGenreCode() {
		return genreCode;
	}
	
	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}
	
	public String getGenreName() {
		return genreName;
	}
	
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
}
