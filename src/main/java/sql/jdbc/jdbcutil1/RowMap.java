package sql.jdbc.jdbcutil1;

import java.sql.ResultSet;

public interface RowMap<T> {
   public T rowMapping(ResultSet rs);
}
