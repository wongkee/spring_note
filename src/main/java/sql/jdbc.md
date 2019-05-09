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
1、数据库操作的参数用户使用的时候传递过来  
2、解决参数个数不确定的问题，使用动态数组解决  
3、解决参数的类型不确定的问题，一律使用Object对象接收  
jdbcutil1 包中实现了通用的封装（适用于任何对象） 
1、每次用户进行数据库操作都需要new一个List,再将参数都存放进去，过于繁杂，使用java8中的边长数组实现。  
2、JDBCUtils中数据查询的时候都需要一个特定的对象（此处是Good的对象）接收，不通用  

jdbctemplate包中使用了Spring对JDBC的封装JDBCTemplate  



#### MySql 常用语句
增：  
```sql
# 插入指定列的数据
INSERT INTO tb_name (tb_field1, tb_field2) VALUES ('Gates', 'Bill');
insert into goods(gname,gprice,gnum) values('foo',20,20);

#所有列
insert into goods(gname,gprice,gnum) values(2，'foo',20,20);

```

删：  
```sql
# 删除一个记录
DELETE FROM tb_name WHERE name = 'Bill';
# 删除所有行
DELETE FROM tb_name;
# 删除表
DROP TABLE tb_name;
# 删除数据库
DROP DATABASE db_name;
# 删除索引
ALTER TABLE tb_name DROP INDEX [索引名称];
# 删除列
ALTER TABLE tb_name  DROP COLUMN column_name;
```

改：  
```sql
数据修改
UPDATE tb_name SET tb_field1 = 'One', tb_field2 = 'Two' WHERE tb_field3 = '111';
```

查：
```sql
SELECT * FROM tb_name;
SELECT * FROM tb_name WHERE id = XXX;
```  

#### 疑难杂症
MysSQL 报错 duplicate entry 'book' for key 'name'  
错误原因 MySQL中将gname 设计成唯一索引，不能插入相同的gname.  
解决方案 将索引类型删除或者插入不同的商品名称（更符合逻辑一些）。