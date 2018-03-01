package cn.itcast02.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * jdbc  
 * 修改 sort表中  数据 sid 为 3的    sname  抱抱
 * 
 */
public class UpdateDemo {
   public static void main(String[] args) throws Exception {
	  //1:注册驱动
	   Class.forName("com.mysql.jdbc.Driver");
	   
	   //2:获取连接对象 
	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day04_jdbc", "root", "root");
   
      //3:创建语句执行平台 
	   Statement state = conn.createStatement();
	   
	   //4:执行sql语句 
	   int row = state.executeUpdate("update sort set sname = '抱抱' where sid = 3");
      
	   //5:处理结果 
	   System.out.println(row+"行受影响");
	   
	   //6:释放资源 
	   state.close();
	   conn.close();
   }
}
