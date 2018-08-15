package javaTest;

public class compareToTest {
               public static void main(String[] args) {
				String str="hello";
				String anotherStr="Hello";
				Object oo=str;
				System.out.println(str.compareTo(anotherStr));
				System.out.println(str.compareToIgnoreCase(anotherStr));
				System.out.println(str.compareTo(oo.toString()));
			}
}
