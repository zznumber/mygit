package cn.itcast04.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 
 * JDBC工具类  
 *    因为发现  获取  注册 连接对象 里面 操作 重复 
 *                     这两句话中有很多 字符串   特别容易写错
 *                     
 *    单独把这两个操作  放到一个工具类中  由工具类 完成这两个步骤 
 *    那么 再写代码的时候  直接调用该类中的 相应功能就可以了  
 *    
 *    
 *    释放 操作 也定义在工具类 
 */
public class JDBCUtils {
	
	
	/*
	 * 当需要执行某些操作  而这些操作 执行只执行1次的时候 那么就把这些代码 
	 *   放在静态代码块中
	 */
	/*
	 *   注册驱动
	 */
	static{
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("驱动注册失败~");
		}
	}
	
    /**
     * 获取连接对象
     *  
     */
	public static Connection getConn(){
	
		  
	    try {
	    	  //获取连接对象
		     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day04_jdbc", "root", "root");
			
			 return conn;
		} catch (Exception e) {
			
			throw new RuntimeException("获取连接对象失败");
		}
	}
	
	/*
	 * 释放资源方法  
	 * 
	 */
	public static void closeAll(ResultSet rs ,Statement state,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				throw new RuntimeException("释放结果集对象失败");
			}
		}
		
		if(state!=null){
			try {
				state.close();
			} catch (SQLException e) {
				throw new RuntimeException("释放语句执行平台对象失败");
			}
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException("释放连接对象对象失败");
			}
		}
	}
	
	
}
