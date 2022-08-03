package COM.RYS.JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CallableStmtByFunction {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ruchi", "root", "4081");
		CallableStatement callStmt=conn.prepareCall("{?=CALL empcountttt()}");
	
		callStmt.registerOutParameter(1, Types.INTEGER);
		
		callStmt.execute();

		int count = callStmt.getInt(1);
		
		System.out.println(count);
		conn.close();
		callStmt.close();
	}

}



