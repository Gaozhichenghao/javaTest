package zhujie;

import org.springframework.stereotype.Component;

@Component
public class test {

	public static void main(String[] args) {
		test t=new test();
		t.testGet(); 

	}
@ServiceLog
 public void testGet(){
	 System.out.println("zzzzzzzzz");
 }
}
