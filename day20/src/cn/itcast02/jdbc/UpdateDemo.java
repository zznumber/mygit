package cn.itcast02.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * jdbc  
 * �޸� sort����  ���� sid Ϊ 3��    sname  ����
 * 
 */
public class UpdateDemo {
   public static void main(String[] args) throws Exception {
	  //1:ע������
	   Class.forName("com.mysql.jdbc.Driver");
	   
	   //2:��ȡ���Ӷ��� 
	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day04_jdbc", "root", "root");
   
      //3:�������ִ��ƽ̨ 
	   Statement state = conn.createStatement();
	   
	   //4:ִ��sql��� 
	   int row = state.executeUpdate("update sort set sname = '����' where sid = 3");
      
	   //5:������ 
	   System.out.println(row+"����Ӱ��");
	   
	   //6:�ͷ���Դ 
	   state.close();
	   conn.close();
   }
}
