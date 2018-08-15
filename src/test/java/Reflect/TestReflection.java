package Reflect;

import java.util.regex.Pattern;

import javaTestEntry.Apple;

public class TestReflection {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		  String className="javaTestEntry.Apple";
        Class class1=Class.forName(className);
        Class class2=Apple.class;
        Class class3=new Apple().getClass();
        
        
        // TODO Auto-generated method stub  
        String str = "abc";
        Class cls1 = str.getClass();
        Class cls2 = String.class;
        Class cls3 = null;//必须要加上null
        try {
            cls3 = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(cls1);
        System.out.println(cls1==cls2);
        System.out.println(cls1==cls3);

        System.out.println(cls1.isPrimitive());
        System.out.println(int.class.isPrimitive());//判定指定的 Class 对象是否表示一个基本类型。
        System.out.println(int.class == Integer.class);
        System.out.println(int.class == Integer.TYPE);
        System.out.println(int[].class.isPrimitive());
        System.out.println(int[].class.isArray());  
       
        System.out.println(String.class.getConstructor(StringBuffer.class));
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//        String str="this is a test.com";
//       String pattern=".*test.*";
//       boolean p=Pattern.matches(pattern, str);
//        
//        System.out.println(p);
	}

}
