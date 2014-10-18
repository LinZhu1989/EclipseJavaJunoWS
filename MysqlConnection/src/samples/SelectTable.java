package samples;

import java.sql.*;

import main.CommonData;

public class SelectTable {
    
    public static void SelectTableTest(){
        try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL������");
                
            Connection conn;

            conn = DriverManager.getConnection(CommonData.connect_url, CommonData.connect_name, CommonData.connect_password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ⣡");

            String sql = "select * from stu";    //Ҫִ�е�SQL
            ResultSet rs = stmt.executeQuery(sql);//�������ݶ���
                System.out.println("���"+"\t"+"����"+"\t"+"����");
                while (rs.next()){
                    System.out.print(rs.getInt(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.print(rs.getInt(3) + "\t");
                    System.out.println();
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
}
