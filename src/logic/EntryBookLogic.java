package logic;

import dao.EntryBookDao;
import model.EntryBookInfo;
import model.User;

public class EntryBookLogic {
	
	EntryBookDao dao = new EntryBookDao();
	
	public boolean entryBookInfo (EntryBookInfo entryBookInfo, User loginUserInfo) {
		
		boolean result = dao.entryBookInfo(entryBookInfo, loginUserInfo);
		
		return result;
	}
	
	public String changeformat (String inputString) {
		
		String regex = "-";
		String result = inputString.replaceAll(regex, "/");
		
		return result;
		
	}
}
