package COM.RYS.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TransactionHandlingStatment {
	public static void main() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ruchi", "root", "4081");
		conn.setAutoCommit(false);
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate("insert into employee values (15,'shyam','sharma',13000,4)");
		int j = stmt.executeUpdate("insert into employee values (15,'shyam','sharma',13000,4)");
		System.out.println(i + "insert");
		conn.commit();
		conn.close();
		stmt.close();
}
}
