package cn.itcast06.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.itcast05.tools.JDBCUtils;


public class Server {
    /*
     * ʹ��Ԥ����ʽ��� ����
     */
	public User login(String username, String password) throws Exception {
		//��ȡ���Ӷ���
		Connection conn = JDBCUtils.getConn();
		
		//��ȡ���� Ԥ�������(Ԥ����ʽ��һ�����ִ��ƽ̨)
		// �ڴ��� ��� ���ִ��ƽ̨֮ǰ��֪��Ҫִ�е�sql�����ʲô
		//  ����Ԥ����ʽ��sql���  ����ǰһ�� ֻ�����ڲ������� ��? ��� 
		String sql = "select * from users where username = ? and password = ?";
		// ����Ԥ�������  
		PreparedStatement ps = conn.prepareStatement(sql);
		//��ִ��֮ǰ  ���?�ĸ�ֵ
//		ps.setXxx(int �ڼ���? ,ֵ)  ��ɸ�ֵ����
		ps.setString(1,username);
		ps.setString(2,password);
		
		
		// ִ��sql���
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
	
	//ԭʼ��ʽ
	/*
	 * ���û����ص� �û���Ϣ
	 *   û�� �ͷ��� null
	 */
//	public User login(String username, String password) throws Exception {
//		
//		Connection conn = JDBCUtils.getConn();
//		Statement state = conn.createStatement();
//		
//		/*
//		 * ����ƴ�� ���ҿ��� ����ȷһ��ƴ�ӷ�ʽ 
//		 *   ��������mysql���Ե����﷨����
//		 *    ƴ�ӵ�  "+password+"'"  ���С�ַ���  ���� �������mysql�ؼ��� �͵����﷨��һ���ִ�����
//		 *    
//		 *     ���ǵ��뷨��  "+password+"'" ���� �͵���һ������������� �Ϳ����� 
//		 *     
//		 *     ������һ���µĲ�����ʽ 
//		 *      Ԥ����ʽ
//		 *        ��ǰ ����Ҫ���ݵĲ��� ����ճ��� 
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
