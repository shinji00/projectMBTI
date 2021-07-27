package com.pt.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// DB���� �۾��� �� �� �Ź� �����ڵ带 �� ���� �۾� �� ��.

// AOP
public class DBManager {
	
	public static Connection connect() throws NamingException, SQLException {
	
		// context.xml
		Context ctx = new InitialContext();
		
		// Ʃ�� �뿩�� (Connection �뿩��)
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/ksj");
		return ds.getConnection();
	}
	
	// ������Ʈ -> �ڵ� -> ���� -> ���� ���� 
	
	// Ʃ�� �뿩�� ����. ��û�ϸ� �������� �ٶ��Ҿ ��(����)
	// DB������ ���� ��û�ϸ� �غ��� ���� Ŀ�ؼ�(Ʃ��) �ٷ� �� (�߰�����)
	
	
	
	
	/* ���� �� �� ����
	// DB�۾� �ÿ� ��¶�� �����ؾ� ��
	public static Connection connect() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		return DriverManager.getConnection(url, "c##sj", "sj");
		
	}
	
*/
	
	// ���� �� ������ �� ���� �ݱ�
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		
		try {
			if(rs!=null ) {
			rs.close();
			}
		} catch (SQLException e) {
		}
		
		try {
			if(pstmt!=null) {
			pstmt.close();
			}
		} catch (SQLException e) {
		}
		
		try {
			if(con!=null) {
			con.close();
			}
		} catch (SQLException e) {
		}
		
	}

}
