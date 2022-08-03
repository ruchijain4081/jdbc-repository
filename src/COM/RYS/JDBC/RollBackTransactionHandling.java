package COM.RYS.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RollBackTransactionHandling {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ruchi", "root", "4081");
		conn.setAutoCommit(false);
		PreparedStatement ps=conn.prepareStatement("insert into employee values(?,?,?,?,?)");
		ps.setInt(1,15);
		ps.setString(2 ,"ram");
		ps.setString(3 ,"dagi");
		ps.setInt(4,11000);
		ps.setInt(5,3);
		PreparedStatement vs=conn.prepareStatement("insert into employee values(?,?,?,?,?)");
		vs.setInt(1,15);
		vs.setString(2 ,"ram");
		vs.setString(3 ,"dagi");
		vs.setInt(4,11000);
		vs.setInt(5,3);
try {
	int i=ps.executeUpdate();
	int j=vs.executeUpdate();
	conn.commit();
} catch(Exception e){
	conn.rollback();
	System.err.println("primary key is duplicate");
	//e.printStackTrace();
}
finally {
	
	conn.close();
	ps.close();}
	}
}
