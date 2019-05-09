package sql.jdbc.jdbcutil;

import sql.jdbc.Good;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static  void main(String args[]){
        String sql="select * from goods where gname=?";
        List<Object> params=new ArrayList<>();
        params.add("computer");
        List<Good> goods=JDBCUtils.executeQuery(sql,params);
        for(Good good:goods){
            System.out.println(good);
        }
        String sql1="insert into goods(gname,gprice,gnum) values(?,?,?)";
        String gname="computer";
        float gprice=10;
        int gnum=10;
        List<Object> list=new ArrayList<>();
        list.add(gname);
        list.add(gprice);
        list.add(gnum);
        int result =JDBCUtils.executeUpdate(sql1,list);
    }
}
