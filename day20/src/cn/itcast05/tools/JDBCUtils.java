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
	
	private static final String DRIVER_CLASS ; 
	private static final String URL; 
	private static final String USER ; 
	private static final String PASSWORD ; 
	/*
	 * final�����˾�̬���� 
	 *   ���� ����������֮ǰ  ��ɳ�ʼ��  
	 *      ��̬����� �����Ҳ����
	 */
	static{
		//���� properties�ļ�  �������� ��ֵ�� ����
		//ʹ��Properties���Ͻ���
		Properties prop = new Properties();
		
		//��ȡ�ļ�
		try {
			prop.load(new FileReader("src/db.properties"));
		} catch (IOException e) {
			throw new RuntimeException("��ȡ�ļ�ʧ��");
		}
		
		// ������ prop��
		// �������� ����ɳ�����ʼ��
		DRIVER_CLASS = prop.getProperty("driverClass");
		URL = prop.getProperty("url");
		USER = prop.getProperty("user");
		PASSWORD = prop.getProperty("password");
		
		
	}
	/*
	 * ����Ҫִ��ĳЩ����  ����Щ���� ִ��ִֻ��1�ε�ʱ�� ��ô�Ͱ���Щ���� 
	 *   ���ھ�̬�������
	 */
	/*
	 *   ע������
	 */
	static{
		 try {
			Class.forName(DRIVER_CLASS);
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
	    	
		     Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 return conn;
		} catch (Exception e) {
			
			throw new RuntimeException("��ȡ���Ӷ���ʧ��"+e);
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
