package sql.jdbc.jdbcutil1;

import sql.jdbc.Good;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static  void main(String args[]){
        String sql="select * from goods where gname=?";
        List<Good> goods= JDBCUtils.executeQuery(sql,"computer");
        for(Good good:goods){
            System.out.println(good);
        }
        String sql1="insert into goods(gname,gprice,gnum) values(?,?,?)";
      //使用变长参数大大的减少了代码量
        int result = JDBCUtils.executeUpdate(sql1,"notebook",20,20);
    }
}
