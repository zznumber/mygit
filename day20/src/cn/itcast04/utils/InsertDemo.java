package cn.itcast04.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDemo {
  public static void main(String[] args) throws Exception {
	  
	  // ��ȡ���Ӷ��� 
	  Connection conn = JDBCUtils.getConn();
	  
	  //�������ִ��ƽ̨
	  Statement state = conn.createStatement();
	  // ִ��sql���
	  int row = state.executeUpdate("insert into sort values(4,'������Ʒ')");
	  System.out.println(row);
	  
	  JDBCUtils.closeAll(null, state, conn);
   }
}
