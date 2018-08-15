package javaTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringListToIntList {
	// String数组转int数组
	public static void main(String[] args) {
		String str = "1,2,3,9,7,8,3,6,5";
		String[] strList = str.split(",");
		int len=strList.length;
		int[] intList=new int[len];
       for (int i = 0; i <len; i++) {
		    intList[i]=Integer.parseInt(strList[i]);
	}
       for (int i = 0; i < intList.length; i++) {
    	   System.out.println(intList[i]);
	}
       
       
       //使用java8进行数组转int并排序
       List<Integer> ll=Arrays.asList(strList).stream().map(Integer::parseInt).sorted().collect(Collectors.toList());
		for (int string : ll) {
			System.err.println(string);
		}
		
	}
	
}
