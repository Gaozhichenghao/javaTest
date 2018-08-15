package javaTest;

import java.util.StringJoiner;

public class test {

	public static void main(String[] args) {
		StringJoiner sjr = new StringJoiner(",", "[", "]"); sjr.add("Smart").add("Techie");
		System.out.println("The final Joined string is " + sjr);
   
		
	System.err.println(String.join("/", "yyy".toString(),"ccc".toString() + ".zip"));	
		
		
	}

}
