package cn.itcast06.login;

import java.util.Scanner;



public class Client {
public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�������û�����");
		String username = sc.nextLine();
		System.out.println("���������룺");
		String password = sc.nextLine();
		
		//���û��������봫�ݸ�Server����У��
		Server server = new Server();
		User user = server.login(username,password);
		//�ж��û��Ƿ����
		if(user!=null){
			System.out.println("��ӭ��,"+user);
		}else{
			System.out.println("�û������������");
		}
		
		
	}
}
