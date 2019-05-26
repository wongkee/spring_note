本文件夹下是对使用到的一些java基础的复习与实现  
#### 变长数组
1、变长参数意味着可以传入0个或者多个参数，普通数据不可以传入0个  
2、变长参数只可以作为最后一个参数传入  
3、包含变长参数的方法虽然可以重载，但是会导致模糊，可能会报错  
代码实现： NewArray.java

#### forEach
作用可以迭代一个集合并对每个元素执行给定的操作。
```java
//原始的for循环
for (String name : names) {
    System.out.println(name);
}
//使用forEach
names.forEach(name -> {
    System.out.println(name);
});
```
源码：  
```java
@param action The action to be performed for each element
@throws NullPointerException if the specified action is null
@since 1.8
 default void forEach(Consumer<? super T> action) {
    Objects.requireNonNull(action);
       for (T t : this) {
           action.accept(t);
       }
}
```
那么什么可以作为它的参数呢？
1、可以是lambda表达式
           rootNode.getChildren("employee").forEach((e)->{
                     System.out.println(e.getAttributeValue("id"));
             });
2、 也可以使用方法引用语法
              rootNode.getChildren("employee").forEach( Main::readEmployeeNode );
      其中readEmployeeNode是类中定义的方法
      
      参考xml.Main.java