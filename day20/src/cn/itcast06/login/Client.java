package cn.itcast06.login;

import java.util.Scanner;



public class Client {
public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入用户名：");
		String username = sc.nextLine();
		System.out.println("请输入密码：");
		String password = sc.nextLine();
		
		//将用户名和密码传递给Server进行校验
		Server server = new Server();
		User user = server.login(username,password);
		//判断用户是否存在
		if(user!=null){
			System.out.println("欢迎您,"+user);
		}else{
			System.out.println("用户名或密码错误");
		}
		
		
	}
}
