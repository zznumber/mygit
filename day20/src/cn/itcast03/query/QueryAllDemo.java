package cn.itcast03.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 *  使用jdbc查询  sort表中所有的数据  
 *   select * from sort
 */
public class QueryAllDemo {
   public static void main(String[] args) throws Exception {
	  /*
	   1:注册驱动
	   */
	   Class.forName("com.mysql.jdbc.Driver");
      //2:获取连接对象
	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day04_jdbc", "root", "root");
      //3:创建语句执行平台
      Statement state = conn.createStatement();
      //4:执行sql语句  查询  query关键字  
      ResultSet rs = state.executeQuery("select * from sort");
      //5: 处理结果集 
      /*
       * 代码如何编写
       */
      while(rs.next()){
    	  // true  这一行有数据
    	  // 解析
    	 int sid = rs.getInt("sid");
    	 String sname = rs.getString("sname");
    	 
    	 System.out.println("sid:"+sid+"  sname:"+sname);
      }
      //6:释放资源 
      rs.close();
      state.close();
      conn.close();
   }
}
