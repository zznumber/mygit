package cn.itcast03.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 *  ʹ��jdbc��ѯ  sort�������е�����  
 *   select * from sort
 */
public class QueryAllDemo {
   public static void main(String[] args) throws Exception {
	  /*
	   1:ע������
	   */
	   Class.forName("com.mysql.jdbc.Driver");
      //2:��ȡ���Ӷ���
	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day04_jdbc", "root", "root");
      //3:�������ִ��ƽ̨
      Statement state = conn.createStatement();
      //4:ִ��sql���  ��ѯ  query�ؼ���  
      ResultSet rs = state.executeQuery("select * from sort");
      //5: �������� 
      /*
       * ������α�д
       */
      while(rs.next()){
    	  // true  ��һ��������
    	  // ����
    	 int sid = rs.getInt("sid");
    	 String sname = rs.getString("sname");
    	 
    	 System.out.println("sid:"+sid+"  sname:"+sname);
      }
      //6:�ͷ���Դ 
      rs.close();
      state.close();
      conn.close();
   }
}
