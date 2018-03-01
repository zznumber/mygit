package cn.itcast05.tools;

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
	   
	  
	  
	   Connection conn = JDBCUtils.getConn();
	   
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
	   
	 JDBCUtils.closeAll(rs, state, conn);
   }
}
