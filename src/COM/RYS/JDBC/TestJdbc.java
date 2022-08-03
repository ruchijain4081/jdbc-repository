package COM.RYS.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJdbc {
	public static void main(String[] args) throws Exception {
	testSelect();
	//testAdd();
	}

	public static void testSelect() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ruchi", "root", "4081");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(
				" SELECT ID, ROLLNO, FNAME,LNAME,PHYSICS,CHEMISTRY,MATHS, (PHYSICS+CHEMISTRY+MATHS) AS TOTAL, (((PHYSICS+CHEMISTRY+MATHS)/3)) AS PERCENTAGE FROM MARKSHEE WHERE PHYSICS >40 && CHEMISTRY >40 && MATHS>40 ORDER BY TOTAL DESC;");
		System.out.println("ID"+"\t" +"ROLLNO"+"\t" +"FNAME"+"\t" +"LNAME"+"\t"+"PHYSICS"+"\t"+"CHEMISTRY"+" "+"MATHS"+"\t"+"TOTAL"+"\t"+"PERCRNT");
		System.out.println("***************************************************************************************************");
		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t " + rs.getString(2));
			System.out.print("\t " + rs.getString(3));
			System.out.print("\t " + rs.getString(4));
			System.out.print("\t  " + rs.getInt(5));
			System.out.print("\t  " + rs.getInt(6));
			System.out.print("\t  " + rs.getInt(7));
			System.out.print("\t  " + rs.getInt(8));
			System.out.println("\t  " + rs.getInt(9));
			System.out.println("--------------------------------------------------------------------------");
		}
		stmt.close();
		conn.close();
		rs.close();
	}
	
}
	
