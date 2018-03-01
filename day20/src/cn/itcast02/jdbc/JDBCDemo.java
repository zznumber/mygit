package cn.itcast02.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/*
 *   jdbc����   
 *   
 *      jdbc : java�����ݿ�� ���� ����   
 *         jdbc ��һ�����ӻ�׼  ���������ӵĹ���   
 *                ������һ�� �����ӿ� java.sql.Driver 
 *                �� һЩ �� �����     ������ DriverManager 
 *                                        ��Ҫ����  ע������
 *                                                 ��ȡ����
 *                �����漰�� Connection ���Ӷ���   Statement ���ִ����  
 *                             ResultSet �����
 *      
 *     ���ǵĲ��� ʹ��mysql���ݿ�  
 *       mysql���ݿ� ���� ȥʵ�������淶  ��ô���ж�Ӧ��jar��  
 *         ���jar�� ����   
 *           ����Ҫ��һ���� ������  com.mysql.jdbc.Driver
 *           
 *     ��ʼ����
 *        jdbc�淶 �ṩ�˲�������  
 *        
 *        1:ע������
 *          ��DriverManager ����������ע��  
 *                static void registerDriver(java.sql.Driver driver)
 *                  ��Ҫ���ǽӿ�  ����ʵ������� com.mysql.jdbc.Driver����  
 *                           
 *        2:��ȡ����       
 *        
 *        3:�������ִ����
 *        
 *        4:ִ��sql���
 */
public class JDBCDemo {
   public static void main(String[] args) throws SQLException, ClassNotFoundException {
	  
	   /*
	    * 1:ע������
	    *    ��DriverManager ����������ע��  
	    */
	  // DriverManager.registerDriver(new Driver());
	   /*
	    * �鿴Դ��  ������com.mysql.jdbc.Driver����� �����ڴ��ʱ���Ѿ����ע�����  
	    *  ����һ�� ���൱�� ע������  ���ֲ�����ʽ ���ᳫ
	    *  ��ô ����� ���ǲ���ֻҪע��һ�� �Ϳ����� 
	    *    ��ʲôʱ�������ע����  ��ֻҪ���ؾͿ����� 
	    */
	   Class.forName("com.mysql.jdbc.Driver");
	   /*
	    * 2:��ȡ���� 
	    *     ����ָ�������ݿ�   ������  day04_jdbc������ݿ�
	    *     
	    *     DriverManger���ṩ��һ������ 
	    *     static  Connection  getConnection(String url,String user ,String password)
	    *      
	    *     url: ���ݿ��λ��
	    *         д���� �������� 
	    *         jdbc:mysql://localhost:3306/day04_jdbc
	    *     user: �û���
	    *     password:����
	    *     
	    */
	   //���ݿ�λ��
	   String url = "jdbc:mysql://localhost:3306/day04_jdbc";
	   //���ݿ��û���
	   String user = "root";
	   String password = "root";
	   //����� ���Ӷ���  ����һ�ֹ�ϵ
	   Connection conn = DriverManager.getConnection(url, user, password);
	   /*
	    * ���ֲ�����Ŀ�� �� java�в������ݿ��еı�����
	    * 3:�������ִ����  Statement
	    *    ��Connection conn���Ӷ�����ɴ�������
	    *        ���� 
	    *         Statement createStatement()
	    *         
	    *         ר������ִ��sql����  
	    */
	   Statement state = conn.createStatement();
	   
	   /*
	    * 4:ִ��sql���
	    */
	   // ����һ������
	   String sql = "insert into sort values(4,'���')";
	   // ִ���� 
	   /*
	    * ��Ҫʹ��  Statement ����ķ��� 
	    * int executeUpdate(String sql); --ִ��insert delete update ���.
	    *     ִ�� ��ɾ�����   �м���������Ӱ���� ���ؼ�
	    * ResultSet executeQuery(String sql); --ִ��select���.
	    *     ִ�в������   ����һ����ά��  ResultSet ���������ά��
	    * 
	    * boolean execute(String sql); --ִ��select����true ִ����������䷵��false.
	    */
	   int row = state.executeUpdate(sql);
       // 5: ��������(��Ҫ��� ��ѯ )  
	   System.out.println(row+"����Ӱ��");
	   
	   //6:�ͷ���Դ 
	   state.close();
	   conn.close();
   }
}
