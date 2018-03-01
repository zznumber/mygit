package cn.itcast05.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 使用 Java程序  操作数据库 
 *    1:数据库中有数据了  
 *    2:已经将 数据库的jar包导入了  
 *    
 *    3:  java中对这种操作 提供了 一套APi 
 *        告诉了你步骤 
 *          1.注册驱动.
			2.获得连接.
			3.获得语句执行平台
			4.执行sql语句
			5.处理结果
			6.释放资源.
 */
public class JDBCDemo {
   public static void main(String[] args) throws SQLException {
	   
	  
	  
	   Connection conn = JDBCUtils.getConn();
	   
	   /*
	    * 3:获得语句执行平台
	    *    java中写sql  让数据库执行 
	    *    
	    *    有专门负责  sql语句执行的 一种对象 
	    *    Statement  
	    *       需要  连接对象 创建出来的 
	    */
	   Statement state = conn.createStatement();
	   
	   String sql = "select * from sort";
	   
	   /*
	    * 4 执行sql语句
	    */
	   ResultSet rs = state.executeQuery(sql);
	   //5 处理结果
	   
	   while(rs.next()){
		   
		   System.out.println(rs.getInt("sid")+"  "+rs.getString("sname"));
	   }
	  /*
	   * 
	   * 
	   * 
	   */
	   
	   //6: 释放资源
	   
	 JDBCUtils.closeAll(rs, state, conn);
   }
}
