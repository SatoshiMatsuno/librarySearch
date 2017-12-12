package Const;

public final class Const {

	private Const() {
    }

	// DB接続情報
		public static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
		public static final String JDBC_URL = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=172.16.1.35)(PORT=1521)))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=pdb2)))";
		public static final String DB_USER = "KYOIKU_01";
		public static final String DB_PASS = "KYOIKU#001";
}
