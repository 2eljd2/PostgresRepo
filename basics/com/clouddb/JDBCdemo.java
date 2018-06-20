//$Id$
package com.clouddb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdemo {

	private final static String url = "jdbc:postgresql://localhost:5432/postgres";
	private final static String user = "postgres";
	private final static String password = "postgres";

	/**
	 * Connect to the PostgreSQL database
	 *
	 * @return a Connection object
	 */

	public static Connection connect() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public static void main(String[] args) throws SQLException {

		Connection conn = connect();
		conn.setAutoCommit(false);
		Statement stmt1 = conn.createStatement();
		Statement stmt2 = conn.createStatement();

		ResultSet rs1 = stmt1.executeQuery("SELECT * FROM COMPANY");
		ResultSet rs2 = stmt2.executeQuery("SELECT * FROM COMPANY2");

		while (rs1.next() && rs2.next()) {

			System.out.println("company1: "+rs1.getInt(1));
			System.out.println("company2: "+rs2.getInt(1));

			System.out.println();
		}

		stmt1.close();
		stmt2.close();

		conn.close();

		System.out.println("-----");
	}

}
