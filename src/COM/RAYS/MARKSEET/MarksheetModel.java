package COM.RAYS.MARKSEET;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarksheetModel {

	public Integer nextPk() throws Exception {
		int pk = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ruchi", "root", "4081");
		//MarksheetModel model = new MarksheetModel();
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("select max(id) from markshee");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}
		conn.commit();
		ps.close();
		conn.close();
		return pk + 1;

	}

	public void add(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ruchi", "root", "4081");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("insert into markshee values(?,?,?,?,?,?,?)");
		ps.setInt(1, nextPk());
		ps.setString(2, bean.getRollno());
		ps.setString(3, bean.getFname());
		ps.setString(4, bean.getLname());
		ps.setInt(5, bean.getPhy());
		ps.setInt(6, bean.getChem());
		ps.setInt(7, bean.getMath());
		int i = ps.executeUpdate();
		System.out.println("inserted..." + i);
		conn.commit();
		conn.close();
		ps.close();
	}

	public void Update(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ruchi", "root", "4081");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("update markshee set fname=? ,lname=? where ID=?");
		ps.setString(1, bean.getFname());
		ps.setString(2, bean.getLname());
		ps.setInt(3, bean.getId());
		int i = ps.executeUpdate();
		conn.commit();

		ps.close();
		conn.close();

	}

	public void Delete(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ruchi", "root", "4081");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("delete from markshee where rollno=?");
		ps.setString(1, bean.getRollno());
		int i = ps.executeUpdate();
		conn.commit();
		ps.close();
		conn.close();
	}

	public MarksheetBean get(String rollNo) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ruchi", "root", "4081");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("select * from markshee where rollno=?");
		ps.setString(1, rollNo);
		ResultSet rs = ps.executeQuery();

		MarksheetBean bean = null;

		while (rs.next()) {

			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollno(rs.getString(2));
			bean.setFname(rs.getString(3));
			bean.setLname(rs.getString(4));
			bean.setPhy(rs.getInt(5));
			bean.setChem(rs.getInt(6));
			bean.setMath(rs.getInt(7));

		}
		conn.commit();
		ps.close();
		rs.close();
		conn.close();
		return bean;

	}

	public ArrayList<MarksheetBean> search() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ruchi", "root", "4081");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("select * from markshee");
		ResultSet rs = ps.executeQuery();

		//MarksheetBean bean = null;

		ArrayList<MarksheetBean> list = new ArrayList<MarksheetBean>();

		while (rs.next()) {

			MarksheetBean bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollno(rs.getString(2));
			bean.setFname(rs.getString(3));
			bean.setLname(rs.getString(4));
			bean.setPhy(rs.getInt(5));
			bean.setChem(rs.getInt(6));
			bean.setMath(rs.getInt(7));
			list.add(bean);

		}
		conn.commit();
		ps.close();
		rs.close();
		conn.close();
		return list;

	}
	public ArrayList<MarksheetBean> getMeritList() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ruchi", "root", "4081");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement(" SELECT ID, ROLLNO, FNAME,LNAME,PHYSICS,CHEMISTRY,MATHS, (PHYSICS+CHEMISTRY+MATHS) AS TOTAL, (((PHYSICS+CHEMISTRY+MATHS)/3)) AS PERCENTAGE FROM MARKSHEE WHERE PHYSICS >40 && CHEMISTRY >40 && MATHS>40 ORDER BY TOTAL DESC limit 1,10;");
		ResultSet rs = ps.executeQuery();

		//MarksheetBean bean = null;

		ArrayList<MarksheetBean> list = new ArrayList<MarksheetBean>();

		while (rs.next()) {

			MarksheetBean bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollno(rs.getString(2));
			bean.setFname(rs.getString(3));
			bean.setLname(rs.getString(4));
			bean.setPhy(rs.getInt(5));
			bean.setChem(rs.getInt(6));
			bean.setMath(rs.getInt(7));
			list.add(bean);

		}
		conn.commit();
		ps.close();
		rs.close();
		conn.close();
		return list;

	}

}
