package cn.itcast06.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.itcast05.tools.JDBCUtils;


public class Server {
    /*
     * 使用预处理方式完成 操作
     */
	public User login(String username, String password) throws Exception {
		//获取连接对象
		Connection conn = JDBCUtils.getConn();
		
		//获取的是 预处理对象(预处理方式的一种语句执行平台)
		// 在创建 这个 语句执行平台之前就知道要执行的sql语句是什么
		//  这种预处理方式的sql语句  跟以前一样 只不过在参数部分 被? 替代 
		String sql = "select * from users where username = ? and password = ?";
		// 创建预处理对象  
		PreparedStatement ps = conn.prepareStatement(sql);
		//在执行之前  完成?的赋值
//		ps.setXxx(int 第几个? ,值)  完成赋值操作
		ps.setString(1,username);
		ps.setString(2,password);
		
		
		// 执行sql语句
		ResultSet rs = ps.executeQuery();
		
		User user = null;
		if(rs.next()){
			user = new User();
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
		}
		return user;
	}
	
	//原始方式
	/*
	 * 有用户返回的 用户信息
	 *   没有 就返回 null
	 */
//	public User login(String username, String password) throws Exception {
//		
//		Connection conn = JDBCUtils.getConn();
//		Statement state = conn.createStatement();
//		
//		/*
//		 * 这种拼接 在我看来 是正确一种拼接方式 
//		 *   可以由于mysql语言的弱语法性质
//		 *    拼接的  "+password+"'"  这个小字符串  里面 如果有了mysql关键字 就当做语法的一部分处理了
//		 *    
//		 *     我们的想法是  "+password+"'" 整体 就当做一个密码参数看待 就可以了 
//		 *     
//		 *     出现了一种新的操作方式 
//		 *      预处理方式
//		 *        提前 将你要传递的参数 给你空出来 
//		 */
//		String sql = "select * from users where username='"+username+"' and password='"+password+"'";
//		
//		ResultSet rs = state.executeQuery(sql);
//		User user = null;
//		if(rs.next()){
//			user = new User();
//			user.setUsername(rs.getString("username"));
//			user.setPassword(rs.getString("password"));
//			user.setEmail(rs.getString("email"));
//		}
//		return user;
//	}


}
