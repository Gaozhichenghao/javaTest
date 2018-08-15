package javaTest;

public class strReplaceTest {

	public static void main(String[] args) {
       String s="{s1},{s2},{s3},{s4}";
       String s1="test1";
       String s2="test2";
       String s3="test3";
       String s4="test4";

       System.out.println(s1.replace("t", "p"));
       System.out.println(s2.replaceFirst("t", "p"));
       System.out.println(s.replace("{s1}", s1).replace("{s2}", s2).replace("{s3}", s3).replace("{s4}", s4));
       
       
	}

}
