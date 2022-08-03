package COM.RYS.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;



public class MetadataJDBC {
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ruchi", "root", "4081");
	
	PreparedStatement ps=conn.prepareStatement("SELECT id,fname ,lname,salary,dept_id FROM EMPLOYEE");
	ResultSet rs=ps.executeQuery();
	ResultSetMetaData rsmt=rs.getMetaData();
	System.out.println("catelog="+rsmt.getCatalogName(1));
	System.out.println("table name="+rsmt.getTableName(1));
	System.out.println("total count="+rsmt.getColumnCount());
	for(int i=1;i<=rsmt.getColumnCount();i++) {
		System.out.print("column"+(i));
		System.out.print("\t lable="+rsmt.getColumnLabel(i));
		System.out.print("\t name="+rsmt.getColumnName(i));
		System.out.print("\t type="+rsmt.getColumnType(i));
		System.out.print("\t size="+rsmt.getColumnDisplaySize(i));
		System.out.println("\t precision="+rsmt.getPrecision(i));
		
	}
	conn.close();
	rs.close();
}
}
