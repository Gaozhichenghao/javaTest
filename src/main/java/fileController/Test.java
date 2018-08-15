package fileController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Test {
private static final Map map;
static{
Map aMap =new HashMap();
aMap.put("22", "two");
aMap.put("11", "one");
aMap.put("33", "88");
aMap.put("44", "99");
map =aMap;
}


public static void main(String[] args) {
	  new Test();
//	  
//	  
	  List t=new ArrayList<>(map.entrySet());
	  for (Object object : t) {
		System.out.println(object);
	}
	Iterator tt=map.entrySet().iterator();
	    while (tt.hasNext()) {
	    Entry rr=(Entry) tt.next();
	    System.out.println(rr.getKey().toString()+rr.getValue());
		}
	map.forEach((k,v)->System.out.println("key : " + k + "; value : " + v));
	  
	  //hashmap散列存储，无法排序,采用LinkedHashMap或者是TreeMap即可，当然会造成一些额外开销，但并不影响什么
	Collections.sort(t , new Comparator<Map.Entry<String, String>>() {
		@Override
		public int compare(Entry<String, String> o1, Entry<String, String> o2) {
//			System.out.println(o1.getValue());
			return  o1.getKey().compareTo(o2.getKey());
		}
	});
	map.forEach((k,v)->System.out.println("key : " + k + "; value : " + v)); 
	 
	
	
	
	  Map<String, String> map = new TreeMap<String, String>(
              new Comparator<String>() {
                  public int compare(String obj1, String obj2) {
                      // 降序排序
                      return obj2.compareTo(obj1);
                  }
              });
      map.put("c", "ccccc");
      map.put("a", "aaaaa");
      map.put("b", "bbbbb");
      map.put("d", "ddddd");
      
      Set<String> keySet = map.keySet();
      Iterator<String> iter = keySet.iterator();
      while (iter.hasNext()) {
          String key = iter.next();
          System.out.println(key + ":" + map.get(key));
      }
	
}
}