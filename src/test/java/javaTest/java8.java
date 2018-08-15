package javaTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javaTestEntry.Apple;
import javaTestEntry.product;

public class java8 {
	public static void main(String[] args) {
		List<Apple> appleList = new ArrayList<Apple>();//存放apple对象集合
		Apple apple1 =  new Apple(1,"苹果1",new BigDecimal("3.25"),10);
		Apple apple12 = new Apple(1,"苹果2",new BigDecimal("1.35"),20);
		Apple apple2 =  new Apple(2,"香蕉",new BigDecimal("2.89"),30);
		Apple apple3 =  new Apple(3,"荔枝",new BigDecimal("9.99"),40);
		appleList.add(apple1);
		appleList.add(apple12);
		appleList.add(apple2);
		appleList.add(apple3);
	double num=appleList.stream().mapToDouble(m->m.getNum().doubleValue()).sum();
		System.out.println(num);
		
		//根据某字段值降序排列  desc
	 List<Apple> lld=appleList.stream().sorted(Comparator.comparing(Apple::getNum).reversed()).collect(Collectors.toList());		
		for (Apple apple : lld) {
			System.err.println(apple.toString());
		}
		//根据某字段值升序排列  asc
		 List<Apple> lla=appleList.stream().sorted(Comparator.comparing(Apple::getNum)).collect(Collectors.toList());		
			for (Apple apple : lla) {
				System.err.println(apple.toString());
			}		
		//数组去重 distinct
		List<Apple> lldt=appleList.stream().distinct().collect(Collectors.toList());	
		
		
		//list转换为map
   System.out.println(appleList.stream().collect(Collectors.toMap(k->k.getName(), v->v.getNum())).get("苹果2"));
		//计算BigDecimal金额   BigDecimal:: add substract multiply divide
   BigDecimal totalMoney = appleList.stream().map(Apple::getMoney).reduce(BigDecimal.ZERO, BigDecimal::add);
   System.err.println("totalMoney:"+totalMoney);  //totalMoney:17.48
		product pp=new product();
		pp.setAppleList(appleList);
		
		
		
		
	//求和兩種方式
	System.out.println(pp.getAppleList().stream().collect(Collectors.summingDouble(p->p.getMoney().doubleValue())));
	System.out.println(pp.getAppleList().stream().mapToInt(t->t.getNum()).sum()+"---");	 
	//求平均值兩種方式
	System.out.println(pp.getAppleList().stream().collect(Collectors.averagingInt(t->t.getNum())));
	System.out.println(pp.getAppleList().stream().mapToInt(t->t.getNum()).average().getAsDouble());
	//使用count查询记录数值两种方式	
	System.out.println(pp.getAppleList().stream().collect(Collectors.counting()));
	System.out.println(pp.getAppleList().stream().mapToInt(t->t.getNum()).count());
		
	//根据id聚合数量
	System.out.println(pp.getAppleList().stream().collect(Collectors.groupingBy(Apple::getId,Collectors.summingInt(t->t.getNum())))+"group by id sum num");
	
	//将分组结果映射到set数组只能使用1,2,3,4,5 get到值
	System.out.println(pp.getAppleList().stream().collect(Collectors.groupingBy(Apple::getId,Collectors.mapping(y->y.getName(), Collectors.toSet()))));
   //将结果映射到map时只能使用1,2,3,4,5 get到值
   Map ty=	pp.getAppleList().stream().collect(Collectors.groupingBy(Apple::getId,Collectors.mapping(y->y, Collectors.toMap(Apple::getName,Apple::getNum))));
	System.out.println(ty.get("香蕉")+"test");   //返回值为空
	
	
	//(A,B,C,D)
	 List<String> list = Arrays.asList("A","B","C","D");
     String res=  list.stream().collect(Collectors.joining(",","(",")"));
     System.out.println(res);
	
     // list to set  outpt AA     BB
     Set<String> set = Stream.of("AA","AA","BB").collect(Collectors.toSet());
     set.forEach(s->System.out.println(s));
     
	//list to map
//     key:CC  value:CCCC
//     key:BB  value:BBBB
//     key:AA  value:AAAA
     Map<String,String> map = Stream.of("AA","BB","CC").collect(Collectors.toMap(k->k, v->v+v));
     map.forEach((k,v)->System.out.println("key:"+k +"  value:"+v));
	  
	
	
	//stream流使用完后会自动关掉，然后需要重新初始化一个新的stream
	Stream<Integer> ll=Stream.of(1,2,3,9,0);
	int result=ll.collect(Collectors.summingInt(i->i));
	System.out.println(result);
	//之所以复制上面同样数组是因为这么定义的流只能使用一次，用完就关掉了
	Stream<Integer> ls=Stream.of(1,2,3,9,0);
	int re=ls.mapToInt(p->p).sum();
	System.out.println(re);
	
	}

}
