package sql.jdbc.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import sql.jdbc.Good;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Test {
    public static  void main(String args[]){
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://10.27.143.11:3306/test?useUnicode=true&characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("1462141540");
        jdbcTemplate.setDataSource(dataSource);
        String sql="select * from goods where gname=?";
        //简单的查询操作  只能查找返回一行的操作 返回多行或者0行都会报错
        Good good = (Good) jdbcTemplate.queryForObject(
                sql,
                new Object[]{new String("pen")},
                new RowMapper() {
                    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                       Good good=new Good();
                        good.setGid(rs.getInt("gid"));
                        good.setGname(rs.getString("gname"));
                        good.setGprice(rs.getFloat("gprice"));
                        good.setGnum( rs.getInt("gnum"));
                        return  good;
                    }
                });
        //增删改实验
        int rowCount=jdbcTemplate.update("DELETE FROM goods WHERE gname = 'pencil'");
        //删除价钱为10的商品
        int rowCount1=jdbcTemplate.update("DELETE FROM goods WHERE gprice = ?",new Object[]{10});
        System.out.println(good);

    }
}
