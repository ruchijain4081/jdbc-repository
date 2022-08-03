package COM.RYS.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PreparedSt {
	public static void main(String[] args) throws Exception {
        //testSelect();
		//testAdd();
		// testUpdate();
	//testDelete();
	getById(6);
}
	public static void testSelect() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ruchi", "root", "4081");
		
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM EMPLOYEE ,DEPARTMENT WHERE EMPLOYEE.DEPT_ID=DEPARTMENT.ID");
		ResultSet rs=ps.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t " + rs.getString(2));
			System.out.print("\t " + rs.getString(3));
			System.out.print("\t " + rs.getString(4));
			System.out.print("\t  " + rs.getInt(5));
			System.out.print("\t  " + rs.getInt(6));
			System.out.println("\t  " + rs.getString(7));
		}
		conn.close();
		
		ps.close();
		rs.close();
	}
		


			public static void testAdd() throws Exception {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ruchi", "root", "4081");
				
				PreparedStatement ps=conn.prepareStatement("insert into employee values(?,?,?,?,?)");
				ps.setInt(1,11);
				ps.setString(2 ,"pankj");
				ps.setString(3 ,"dagi");
				ps.setInt(4,1100);
				ps.setInt(5,4);
				int i=ps.executeUpdate();
				
				conn.close();
				ps.close();
			}

			public static void testUpdate() throws Exception {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ruchi", "root", "4081");
				PreparedStatement ps=conn.prepareStatement("update employee set FNAME=? where ID=?");
				ps.setString(1,"pankj");
				ps.setInt(2,9);
				int i=ps.executeUpdate();
				
				ps.close();
				conn.close();

			}

			public static void testDelete() throws Exception {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ruchi", "root", "4081");
				PreparedStatement ps=conn.prepareStatement("delete from employee where id=?");
				ps.setInt(1,11);
				int i=ps.executeUpdate();
				ps.close();
				conn.close();
			}

			public static void getById(int j) throws Exception {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ruchi", "root", "4081");
				
				PreparedStatement ps=conn.prepareStatement("select * from employee where id=" + j);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
					
				}
				ps.close();
				rs.close();
				conn.close();

			}
		}

