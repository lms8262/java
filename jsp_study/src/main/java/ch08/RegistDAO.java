package ch08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegistDAO {
	Connection conn = null;
	PreparedStatement pstmt;

	final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";

	public void open() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, "test", "test1234");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void close() {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Regist> findAll() {
		open();
		ArrayList<Regist> regists = new ArrayList<>();

		try {
			pstmt = conn.prepareStatement("select * from regist");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Regist r = new Regist();

				r.setId(String.valueOf(rs.getInt("id")));
				r.setName(rs.getString("name"));
				r.setAddress(rs.getString("address"));
				r.setGrade(rs.getString("grade"));
				r.setPhone(rs.getString("phone"));
				regists.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return regists;
	}

	public Regist find(String id) {
		open();
		Regist regist = new Regist();

		try {
			pstmt = conn.prepareStatement("select * from regist where id = ?");
			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				regist.setId(String.valueOf(rs.getInt("id")));
				regist.setName(rs.getString("name"));
				regist.setAddress(rs.getString("address"));
				regist.setGrade(rs.getString("grade"));
				regist.setPhone(rs.getString("phone"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return regist;
	}

	public void insert(Regist r) {
		open();
		try {
			pstmt = conn.prepareStatement("insert into regist values(re_seq.nextval, ?, ?, ?, ?)");

			pstmt.setString(1, r.getName());
			pstmt.setString(2, r.getAddress());
			pstmt.setString(3, r.getGrade());
			pstmt.setString(4, r.getPhone());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
}
