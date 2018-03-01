package cn.itcast03.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * ʹ��jdbc ������ݿ�� ��ѯ 
 * 
 *    ��ѯ  sid Ϊ 3 �� һ����¼  
 */
public class QueryDemo {
  public static void main(String[] args) throws Exception {
	  //1:ע������
	  Class.forName("com.mysql.jdbc.Driver");
	  
	  //2:��ȡ���Ӷ���  
	  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day04_jdbc", "root", "root");
  
      //3:�������ִ��ƽ̨ 
	  Statement state = conn.createStatement();
	  
	  //4:ִ��sql���
	  String sql = "select * from sort where sid = 3";
	  /*
	   *  ��ѯ����� �Ľ��    (���ݶ��ڶ�ά����)
	   *     ��sqlyog�п����� ��һ�� ��ʱ��   
	   *               ��ά��   ��ʵ ������sqlyog�� ��������ļ���  �����
	   *               
	   *     ��java�в�ʶ���ά�� 
	   *     ��ô��?  java��ʹ��ResultSet ������ʾ ��ά�� 
	   *     
	   *     ��ô ���� �ʹ浽 ResultSet 
	   *     �ȵõ� ResultSet ���������
	   *     �ٽ��� ����� 
	   *         
	   */
	  ResultSet rs = state.executeQuery(sql);
	  /*
	   * ��ά�� 
	   *       sid    sname
	   *        3           ����
	   */
	  //5:��������
	  //System.out.println(rs);
	  
//	  �Լ����� 
	  /*
	   * rs.next()  
	   *    ָ����һ��
	   */
	  rs.next();
	  // ���� ָ������Ҫ����������  ���� 
	          // ��ȡָ���е�ֵ
	  //    rs.getXxx(����)  rs.getXxx(�е�˳���1��ʼ��)
	   //  Xxx ָ����  ���������ݿ��е����� ʹ��java�е��������ͽ���
	  int sid = rs.getInt("sid");
      String sname = rs.getString("sname");
      
      System.out.println(sid+"  "+sname);
	  //6:�ͷ���Դ
	  rs.close();
	  state.close();
	  conn.close();
  }
}
