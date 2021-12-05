package com.zackliu.jdbc.database;

import com.zackliu.jdbc.database.jdbc.MysqlJdbc;

import java.sql.SQLException;
import java.util.*;

public class JdbcDemo {

    public static void main(String[] args) {
        MysqlJdbc mysqlJdbc = new MysqlJdbc();
        mysqlJdbc.createConnection();
        String table = "t_trade";
        List<String> fields = Arrays.asList("order_id", "total_fee");
        List<Object> values = Arrays.asList("202112052230", 100);
        String condition = "order_id='202112052230'";

        boolean result = mysqlJdbc.insert(table, fields, values);

        List<Map<String, Object>> items = mysqlJdbc.query(table, fields, condition);
        for (Map<String, Object> item : items) {
            System.out.println(item);
        }


        try {
            mysqlJdbc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
