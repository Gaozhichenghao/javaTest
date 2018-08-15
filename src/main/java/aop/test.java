package aop;

import java.lang.reflect.Proxy;

public class test {

	public static void main(String[] args) {
		ForumService target=new ForumServiceImpl();  
		PerformanceHandler handler=new PerformanceHandler(target);  
		ForumService proxy=(ForumService)Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(), handler);  
		proxy.removeForum(23);  
		proxy.removeTopic(678);  
		System.out.println("end monitor..."); 
	}

}
