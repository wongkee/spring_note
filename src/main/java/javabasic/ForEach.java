package javabasic;

import java.util.*;

public class ForEach {
    public  static  void  main(String args[]){
        //asList 使用数组建立列表
        //列表使用forEach
        List<String> names = Arrays.asList("Larry", "Steve", "James");
        names.forEach(System.out::println);

        //集合
        Set<String> uniqueNames = new HashSet<>(Arrays.asList("Larry", "Steve", "James"));
        uniqueNames.forEach(System.out::println);

        //集合
        Queue<String> namesQueue = new ArrayDeque<>(Arrays.asList("Larry", "Steve", "James"));
        namesQueue.forEach(System.out::println);

        //map虽不是Iterable 单也提供了 forEach的变体
        Map<Integer, String> namesMap = new HashMap<>();
        namesMap.put(1, "Larry");
        namesMap.put(2, "Steve");
        namesMap.put(3, "James");

        //使用lambda函数作为参数
        namesMap.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
