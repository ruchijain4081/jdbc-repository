package COM.RYS.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestCurd {
	public static void main(String[] args) throws Exception {
//		testSelect();
		// testAdd();
		// testUpdate();
//		testDelete();
		getById(6);

	}

	public static void testSelect() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ruchi", "root", "4081");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employee");

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t " + rs.getString(2));
			System.out.print("\t " + rs.getString(3));
			System.out.print("\t " + rs.getString(4));
			System.out.println("\t  " + rs.getInt(5));

		}
		stmt.close();
		conn.close();
		rs.close();
	}

	public static void testAdd() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ruchi", "root", "4081");
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate("insert into employee values (10,'shyam','sharma',13000,4)");
		System.out.println(i + "insert");
		conn.close();
		stmt.close();
	}

	public static void testUpdate() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ruchi", "root", "4081");
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate("update employee set FNAME='kannu' where ID=5");
		System.out.println(i);
		stmt.close();
		conn.close();

	}

	public static void testDelete() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ruchi", "root", "4081");
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate("delete from employee where id=10");
		System.out.println(i);
		stmt.close();
		conn.close();
	}

	public static void getById(int j) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ruchi", "root", "4081");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employee where id=" + j);

		while (rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
			
		}
		stmt.close();
		rs.close();
		conn.close();

	}
}
