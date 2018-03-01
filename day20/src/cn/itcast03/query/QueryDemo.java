package cn.itcast03.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * 使用jdbc 完成数据库的 查询 
 * 
 *    查询  sid 为 3 的 一条记录  
 */
public class QueryDemo {
  public static void main(String[] args) throws Exception {
	  //1:注册驱动
	  Class.forName("com.mysql.jdbc.Driver");
	  
	  //2:获取连接对象  
	  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day04_jdbc", "root", "root");
  
      //3:创建语句执行平台 
	  Statement state = conn.createStatement();
	  
	  //4:执行sql语句
	  String sql = "select * from sort where sid = 3";
	  /*
	   *  查询的语句 的结果    (数据都在二维表中)
	   *     在sqlyog中看到了 是一个 临时表   
	   *               二维表   其实 我们在sqlyog中 看做结果的集合  结果集
	   *               
	   *     在java中不识别二维表 
	   *     怎么办?  java中使用ResultSet 用来表示 二维表 
	   *     
	   *     那么 数据 就存到 ResultSet 
	   *     先得到 ResultSet 结果集对象
	   *     再解析 结果集 
	   *         
	   */
	  ResultSet rs = state.executeQuery(sql);
	  /*
	   * 二维表 
	   *       sid    sname
	   *        3           抱抱
	   */
	  //5:处理结果集
	  //System.out.println(rs);
	  
//	  自己解析 
	  /*
	   * rs.next()  
	   *    指向下一行
	   */
	  rs.next();
	  // 现在 指向到我想要的数据上了  解析 
	          // 获取指定列的值
	  //    rs.getXxx(列名)  rs.getXxx(列的顺序从1开始算)
	   //  Xxx 指的是  解析的数据库中的数据 使用java中的那种类型接收
	  int sid = rs.getInt("sid");
      String sname = rs.getString("sname");
      
      System.out.println(sid+"  "+sname);
	  //6:释放资源
	  rs.close();
	  state.close();
	  conn.close();
  }
}
