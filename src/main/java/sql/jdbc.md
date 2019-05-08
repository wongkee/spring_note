#### 基本的数据库操作
##### JDBC
手动启动MySQL服务的方式（windows）
使用：  
1. 导入MySQL的驱动包  
2. 选择要连接的是哪一种数据库
3. 通过主机名、端口号、用户名、密码创建
4. 选择要操作的数据库
5. 打开一个命令窗口  写sql语句  
6. 执行sql语句  查看结果，如果是查询 则返回结果集 ResultSet是一个迭代器，如果是增删改，则返回受影响的行数  
JDBCDemo.java实现了使用jdbc的基本过程  
jdbcutil包中实现了JDBC的简单封装（将一些常用的操作进行封装，方便调用）
jdbcutil1 包中实现了通用的封装（适用于任何对象）
jdbctemplate包中使用了Spring对JDBC的封装JDBCTemplate  
