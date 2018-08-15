package javaTest;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
public class ConsumerJava8 {
	public static void main(String[] args) {
		  /**
         * @name 消费型接口
         * @use Consumer<T>
         * @param T 传入参数
         * @fun 接受一个参数 无返回值
         * */
        Consumer<String> con=(str)->System.out.println(str);
        con.accept("我是消费型接口!");

        /**
         * @name 供给型接口
         * @use Supplier<R>
         * @param R 返回值类型
         * @fun 无参数 有返回值
         * */
        Supplier<Date> supp=()-> new Date();
        Date date=supp.get();
        System.out.println("当前时间:"+date);

        /**
         * @name 函数型接口
         * @use Function<T,R>
         * @param T 传入参数
         * @return R 返回值类型
         * @fun 接受一个参数 有返回值
         * */
        Function<String, String> fun=(str)->"hello,"+str;
        String str=fun.apply("张俊强");
        System.out.println(str);
        /**
         * @name 断定型接口
         * @use Predicate<T>
         * @param T 传入参数
         * @return Boolean 返回一个Boolean型值
         * @fun 接受一个参数 返回Boolean型值
         * */
        Predicate<Integer> pre=(num)->num>0;
        Boolean flag=pre.test(10);
        System.out.println(flag);
	}

}
