package sql.jdbc.jdbcutil1;

import sql.jdbc.Good;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodDao implements RowMap<Good> {
    @Override
    public Good rowMapping(ResultSet rs) {
        Good good=new Good();
        try {
            good.setGid(rs.getInt("gid"));
            good.setGname(rs.getString("gname"));
            good.setGprice(rs.getFloat("gprice"));
            good.setGnum( rs.getInt("gnum"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return good;
    }
}
