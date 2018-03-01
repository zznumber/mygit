package cn.itcast01.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * ʹ�� Java����  �������ݿ� 
 *    1:���ݿ�����������  
 *    2:�Ѿ��� ���ݿ��jar��������  
 *    
 *    3:  java�ж����ֲ��� �ṩ�� һ��APi 
 *        �������㲽�� 
 *          1.ע������.
			2.�������.
			3.������ִ��ƽ̨
			4.ִ��sql���
			5.������
			6.�ͷ���Դ.
 */
public class JDBCDemo {
   public static void main(String[] args) throws SQLException {
	   
	   //1:ע������   java.sql.Driver �����ӿ� ��Ҫ���ݿ⳧��ʵ�־����ʵ���� 
	      //  mysql��ʵ�ֵ���  com.mysql.jdbc.Driver  �����ǵ���jar�� 
	   // ˭�ฺ���������� ����ע�� ��  
	   // DriverManager  
	   DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	   
	   //2:�������  ����ȥ��� ���� ָ�������ݿ� 
	   /*
	    * url: ���ݿ��λ��
	    * user:���ݿ��û���
	    * password: ���ݿ� �û�������
	    */
	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day04_jdbc", "root", "root");
	   
	   /*
	    * 3:������ִ��ƽ̨
	    *    java��дsql  �����ݿ�ִ�� 
	    *    
	    *    ��ר�Ÿ���  sql���ִ�е� һ�ֶ��� 
	    *    Statement  
	    *       ��Ҫ  ���Ӷ��� ���������� 
	    */
	   Statement state = conn.createStatement();
	   
	   String sql = "select * from sort";
	   
	   /*
	    * 4 ִ��sql���
	    */
	   ResultSet rs = state.executeQuery(sql);
	   //5 ������
	   
	   while(rs.next()){
		   
		   System.out.println(rs.getInt("sid")+"  "+rs.getString("sname"));
	   }
	  /*
	   * 
	   * 
	   * 
	   */
	   
	   //6: �ͷ���Դ
	   
	   rs.close();
	   state.close();
	   conn.close();
   }
}
