package samples;

import java.sql.*;

import main.CommonData;

public class GetConnection {
	public void GetConnectionTest() {
		try {
			// ����Class.forName()����������������
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("�ɹ�����MySQL������");
		} catch (ClassNotFoundException e1) {
			System.out.println("�Ҳ���MySQL����!");
			e1.printStackTrace();
		}

		// ����DriverManager�����getConnection()���������һ��Connection����
		Connection conn;
		try {
			conn = DriverManager.getConnection(CommonData.connect_url, CommonData.connect_name, CommonData.connect_password);
			// ����һ��Statement����
			Statement stmt = conn.createStatement(); // ����Statement����
			System.out.print("�ɹ����ӵ����ݿ⣡");
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
