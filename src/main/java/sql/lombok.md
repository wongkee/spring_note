#### idea中使用lombok的方法
1、安装idea中lombok的插件  File -> setting ->plugins ->搜索lombok并安装
2、打开注解生成器    File -> setting ->Annotation Processors -> Enable annotation processing 前面打勾
3、pom.xml中导入lombok的依赖  
```xml
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.16.20</version>
        </dependency>
```
需要注意的是只用使用javac编译的时候lombok才会有效，eclipse编译不支持    
此时就可以方便的使用lombok了  
lombok入门 https://juejin.im/post/5a6eceb8f265da3e467555fe    
参考链接：https://blog.csdn.net/xzp_12345/article/details/80268834  
