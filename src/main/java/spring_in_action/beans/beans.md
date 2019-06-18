#### 装配bean
Spring提供三种主要的装配机制：  
1. 在xml文件中进行显示配置
2. 在java中进行显示配置
3. 隐式的bean发现机制和自动装配

##### TODO：
- [ ] 三种装配机制适用场景

- [ ] 每种装配机制的使用方法

##### 1、自动化装配bean
Spring从两个角度实现自动化配置：  
 - 组件扫描：spring会自动发现应用上下文创建的bean
 - 自动装配：spring自动满足bean之间的依赖
 声明为组件  
 @Component  
 表明该类作为组件类，spring要为这个类创建bean
 @Component("name")  为该组件指定名称
 组件扫描的方式：  
 （1）注解   
 @Configuration:  
 表明该类为配置类   
 @ComponentScan:  
 启用组件扫描，启用组件扫描，默认扫描类所在的包及其子包。
 （2）xml文件配置(暂不考虑)  
 
 自动装配的方式：  
 使用 @Autowired注解
 
 
##### 2、java配置
当自动化配置行不通的是时候，比如你想讲第三方库总的组件装配到你的应用中，这种情况下是无法再它的类上添加@Component和@Autowired注解的，因此不能采用自动化装配的方案
  
java配置相对于xml文件进行配置来说，类型安全并且对重构友好
 
##### 3、xml配置
因为使用XML文件配置bean已经较少使用，所以对一些bean语法的细节部分不再赘述，只是简要说明下使用流程。  
###### 使用流程
1、 创建 User类，代码中存在于 spring_in_action.beans.xmlconfig.User  
2、 书写配置文件 spring-conmfig.xml,名字不唯一
3、 在代码中调用配置好的bean
###### 依赖注入的方式  
1、 属性注入，通过setter方法注入
```xml
 <bean id="user" class="spring_in_action.beans.xmlconfig.User">
        <property name="username" value="String"></property>
        <property name="passworld" value="String"></property>
    </bean>
```
2、构造器注入
```xml
    <bean id="user1" class="spring_in_action.beans.xmlconfig.User">
       <constructor-arg value="zhangsan"></constructor-arg>
        <constructor-arg value="123"></constructor-arg>
    </bean>
```

###### 使用IOC容器中的bean
1、加载配置文件
```java
ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
```
ApplicationContext的主要实现类：
1. ClassPathXmlApplicationContext：  从类路径下加载配置文件FileSystemXmlApplicationContext: 从文件系统中加载配置文件
2. ConfigurableApplicationContext 扩展于ApplicationContext,新增两个主要方法：refresh()和close(),让ApplicationContext具有启动刷新和关闭上下文的能力
3. WebApplicationContext 是专门为Web应用而准备的，它允许从相对于WEB根目录的路径中完成初始化工作
2、读取bean的方法
（1）、通过id读取  
```User user=（HelloWorld）context.getBean("user");```
（2）、通过类型获取(这种方法要求这个bean在IOC容器中是唯一的)  
```User user1=context.getBean(User.class);```
3、 使用bean
```java
System.out.println(user.toString());
```
