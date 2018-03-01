package cn.itcast02.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * 
 * 使用jdbc技术 完成对数据库中表 数据的删除 
 *    删除  sid为  4  的   
 */
public class DeleteDemo {
   public static void main(String[] args) throws Exception {
	   //1:注册驱动
	   Class.forName("com.mysql.jdbc.Driver");
	   //2:获取连接对象
	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day04_jdbc", "root", "root");
       //3:获取语句执行平台  
	   Statement state = conn.createStatement();
	   //4:执行sql语句
	   int row = state.executeUpdate("delete from sort where sid = 4");
	   //5:处理结果
	   System.out.println(row+"行受影响");
       //6:释放资源
	   state.close();
	   conn.close();
   }
}
