package Reflect;
import java.lang.reflect.Field;
public class TestReflect {
    public static void main(String[] args) throws SecurityException, NoSuchMethodException, NoSuchFieldException, IllegalArgumentException, Exception {
        ReflectPointer rp1 = new ReflectPointer(3,4);
        Field fieldx = rp1.getClass().getField("x");//必须是x或者y
        System.out.println(fieldx.get(rp1));

        /*
         * private的成员变量必须使用getDeclaredField，并setAccessible(true),否则看得到拿不到
         */
        Field fieldy = rp1.getClass().getDeclaredField("y");
        fieldy.setAccessible(true);//暴力反射
        System.out.println(fieldy.get(rp1));

        
        //根据类型修改数据值
        ReflectPointer rp2=new ReflectPointer();
        Field [] file=rp2.getClass().getFields();
        for (Field field : file) {
			if(field.getType().equals(String.class)){
				String oldValue=(String) field.get(rp2);
				String newValue=oldValue.replace("b", "-a");
				field.set(rp2, newValue);
			};
			
		}
        
        System.out.println(rp2.toString());
        
        
        
        
    }
}

class ReflectPointer {

    public int x = 0;
    private int y = 0;
   public String str1="ab";
   public String str2="aba";
   public String str3="abab";
   public ReflectPointer() {
}
    public ReflectPointer(int x,int y) {//alt + shift +s相当于右键source
        super();
        // TODO Auto-generated constructor stub
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "ReflectPointer [str1=" + str1 + ", str2=" + str2 + ", str3="
                + str3 + "]";
    }
}
