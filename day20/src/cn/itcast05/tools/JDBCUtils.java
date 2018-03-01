package cn.itcast05.tools;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import cn.itcast06.login.User;

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
	
	private static final String DRIVER_CLASS ; 
	private static final String URL; 
	private static final String USER ; 
	private static final String PASSWORD ; 
	/*
	 * final修饰了静态变量 
	 *   在类 整体加载完毕之前  完成初始化  
	 *      静态代码块 中完成也可以
	 */
	static{
		//解析 properties文件  并将数据 赋值给 常量
		//使用Properties集合解析
		Properties prop = new Properties();
		
		//读取文件
		try {
			prop.load(new FileReader("src/db.properties"));
		} catch (IOException e) {
			throw new RuntimeException("读取文件失败");
		}
		
		// 数据在 prop中
		// 解析数据 并完成常量初始化
		DRIVER_CLASS = prop.getProperty("driverClass");
		URL = prop.getProperty("url");
		USER = prop.getProperty("user");
		PASSWORD = prop.getProperty("password");
		
		
	}
	/*
	 * 当需要执行某些操作  而这些操作 执行只执行1次的时候 那么就把这些代码 
	 *   放在静态代码块中
	 */
	/*
	 *   注册驱动
	 */
	static{
		 try {
			Class.forName(DRIVER_CLASS);
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
	    	
		     Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 return conn;
		} catch (Exception e) {
			
			throw new RuntimeException("获取连接对象失败"+e);
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
