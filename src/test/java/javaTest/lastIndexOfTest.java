package javaTest;

import java.util.Arrays;
import java.util.Locale;

public class lastIndexOfTest {
      
	public static void main(String[] args) {
		 String str="testfdsfadsfsfsfsdtest";
		 //查询字符串test最后一次出现位置
       int t= str.lastIndexOf("test");
       if(t==-1){ System.out.println("没有匹配到");}
       else{System.out.println("最后一次出现时开始下标为:"+t);}
       System.out.println(str.substring(18));
       
       
       String strOrig = "Runoob Google Runoob Taobao Runoob";
       //字符串出现第一次下标位置
       int intIndex = strOrig.indexOf("Runoob");
       if(intIndex == - 1){
          System.out.println("没有找到字符串 Runoob");
       }else{
          System.out.println("Runoob 字符串位置 " + intIndex);
       }
       
       
       //字符串分割,特殊字符需要用\\进行转译
       String ss="p,a,s,s";
       String [] ls=ss.split(",");
       System.out.println(ls);
       
       //字符串转换大小写
       String strs = "STRING RUNOOB";
       String strLower = strs.toLowerCase();
       System.out.println("转换为小写: " + strLower);
       String strUp=strLower.toUpperCase();
       System.out.println("转换为大写: " + strUp);
       
       
       
	}
}
