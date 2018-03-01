package cn.itcast04.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 
 * JDBC������  
 *    ��Ϊ����  ��ȡ  ע�� ���Ӷ��� ���� ���� �ظ� 
 *                     �����仰���кܶ� �ַ���   �ر�����д��
 *                     
 *    ����������������  �ŵ�һ����������  �ɹ����� ������������� 
 *    ��ô ��д�����ʱ��  ֱ�ӵ��ø����е� ��Ӧ���ܾͿ�����  
 *    
 *    
 *    �ͷ� ���� Ҳ�����ڹ����� 
 */
public class JDBCUtils {
	
	
	/*
	 * ����Ҫִ��ĳЩ����  ����Щ���� ִ��ִֻ��1�ε�ʱ�� ��ô�Ͱ���Щ���� 
	 *   ���ھ�̬�������
	 */
	/*
	 *   ע������
	 */
	static{
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("����ע��ʧ��~");
		}
	}
	
    /**
     * ��ȡ���Ӷ���
     *  
     */
	public static Connection getConn(){
	
		  
	    try {
	    	  //��ȡ���Ӷ���
		     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day04_jdbc", "root", "root");
			
			 return conn;
		} catch (Exception e) {
			
			throw new RuntimeException("��ȡ���Ӷ���ʧ��");
		}
	}
	
	/*
	 * �ͷ���Դ����  
	 * 
	 */
	public static void closeAll(ResultSet rs ,Statement state,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				throw new RuntimeException("�ͷŽ��������ʧ��");
			}
		}
		
		if(state!=null){
			try {
				state.close();
			} catch (SQLException e) {
				throw new RuntimeException("�ͷ����ִ��ƽ̨����ʧ��");
			}
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException("�ͷ����Ӷ������ʧ��");
			}
		}
	}
	
	
}
