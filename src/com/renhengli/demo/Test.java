package com.renhengli.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

public class Test {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Test.class);
		// 三种方式输出map中全部元素
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("name", "renhengli");
		map.put(1, 123);
		map.put(2, 345);
		map.put("age", 23);
		System.out.println("hashcode=" + map.hashCode());
		Set set = map.keySet();
		for (Object obj : set) {
			System.out.println("key=" + obj + ",value=" + map.get(obj));
		} 
		System.out.println(set.size());
		Iterator it = set.iterator();
		for (; it.hasNext();) {
			Object o = it.next();
			System.out.println("key=" + o + ",value=" + map.get(o));
		}

		Object[] obj = set.toArray();
		for (int i = 0; i < obj.length; i++) {
			System.out.println("key=" + obj[i] + ",value=" + map.get(obj[i]));
		}

		for (Map.Entry<Object, Object> entry : map.entrySet()) {
			System.out.println("key= " + entry.getKey() + " and value= "
					+ entry.getValue());
		}

		// 通过Map.entrySet使用iterator遍历key和value
		Iterator<Map.Entry<Object, Object>> it1 = map.entrySet().iterator();
		while (it1.hasNext()) {
			Map.Entry<Object, Object> entry = it1.next();
			System.out.println("key= " + entry.getKey() + " and value= "
					+ entry.getValue());
		}
		
		Collection<Object> valueObject = map.values();
		for(Object x :valueObject){
			System.out.println("value="+x);
		}
		
		Collection<Object> xyz = map.values();
		for(Object x :xyz){
			System.out.println("value="+x);
		}
	}
}
