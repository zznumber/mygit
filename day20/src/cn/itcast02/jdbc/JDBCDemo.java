package cn.itcast02.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/*
 *   jdbc操作   
 *   
 *      jdbc : java和数据库的 连接 技术   
 *         jdbc 是一个连接基准  定义了连接的规则   
 *                定义了一个 驱动接口 java.sql.Driver 
 *                和 一些 类 来完成     工具类 DriverManager 
 *                                        主要功能  注册驱动
 *                                                 获取连接
 *                还会涉及到 Connection 连接对象   Statement 语句执行者  
 *                             ResultSet 结果集
 *      
 *     咱们的操作 使用mysql数据库  
 *       mysql数据库 厂商 去实现驱动规范  那么就有对应的jar包  
 *         这个jar包 导入   
 *           最终要的一个类 驱动类  com.mysql.jdbc.Driver
 *           
 *     开始操作
 *        jdbc规范 提供了操作步骤  
 *        
 *        1:注册驱动
 *          由DriverManager 负责驱动的注册  
 *                static void registerDriver(java.sql.Driver driver)
 *                  需要的是接口  传递实现类对象 com.mysql.jdbc.Driver对象  
 *                           
 *        2:获取连接       
 *        
 *        3:创建语句执行者
 *        
 *        4:执行sql语句
 */
public class JDBCDemo {
   public static void main(String[] args) throws SQLException, ClassNotFoundException {
	  
	   /*
	    * 1:注册驱动
	    *    由DriverManager 负责驱动的注册  
	    */
	  // DriverManager.registerDriver(new Driver());
	   /*
	    * 查看源码  看到当com.mysql.jdbc.Driver这个类 进入内存的时候已经完成注册操作  
	    *  再做一次 就相当于 注册两次  这种操作方式 不提倡
	    *  那么 大家想 我是不是只要注册一次 就可以了 
	    *    那什么时候能完成注册呢  类只要加载就可以了 
	    */
	   Class.forName("com.mysql.jdbc.Driver");
	   /*
	    * 2:获取连接 
	    *     连接指定的数据库   本机的  day04_jdbc这个数据库
	    *     
	    *     DriverManger中提供了一个功能 
	    *     static  Connection  getConnection(String url,String user ,String password)
	    *      
	    *     url: 数据库的位置
	    *         写法中 有三部分 
	    *         jdbc:mysql://localhost:3306/day04_jdbc
	    *     user: 用户名
	    *     password:密码
	    *     
	    */
	   //数据库位置
	   String url = "jdbc:mysql://localhost:3306/day04_jdbc";
	   //数据库用户名
	   String user = "root";
	   String password = "root";
	   //获得了 连接对象  代表一种关系
	   Connection conn = DriverManager.getConnection(url, user, password);
	   /*
	    * 这种操作的目的 是 java中操作数据库中的表数据
	    * 3:创建语句执行者  Statement
	    *    由Connection conn连接对象完成创建操作
	    *        方法 
	    *         Statement createStatement()
	    *         
	    *         专门用来执行sql语句的  
	    */
	   Statement state = conn.createStatement();
	   
	   /*
	    * 4:执行sql语句
	    */
	   // 增加一条数据
	   String sql = "insert into sort values(4,'玩具')";
	   // 执行了 
	   /*
	    * 需要使用  Statement 定义的方法 
	    * int executeUpdate(String sql); --执行insert delete update 语句.
	    *     执行 增删改语句   有几行数据受影响了 返回几
	    * ResultSet executeQuery(String sql); --执行select语句.
	    *     执行查找语句   返回一个二维表  ResultSet 就是这个二维表
	    * 
	    * boolean execute(String sql); --执行select返回true 执行其他的语句返回false.
	    */
	   int row = state.executeUpdate(sql);
       // 5: 处理结果集(主要针对 查询 )  
	   System.out.println(row+"行受影响");
	   
	   //6:释放资源 
	   state.close();
	   conn.close();
   }
}
