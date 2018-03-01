package cn.itcast04.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDemo {
  public static void main(String[] args) throws Exception {
	  
	  // 获取连接对象 
	  Connection conn = JDBCUtils.getConn();
	  
	  //创建语句执行平台
	  Statement state = conn.createStatement();
	  // 执行sql语句
	  int row = state.executeUpdate("insert into sort values(4,'床上用品')");
	  System.out.println(row);
	  
	  JDBCUtils.closeAll(null, state, conn);
   }
}
