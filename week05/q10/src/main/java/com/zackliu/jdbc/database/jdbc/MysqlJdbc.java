package com.zackliu.jdbc.database.jdbc;

import org.apache.logging.log4j.util.Strings;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MysqlJdbc {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    public void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        try {
            //TODO
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useSSL=false", "root", "123456");
            if (connection == null) {
                System.out.println("connection refused!");
            } else {
                System.out.println("connection success~");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean insert(String table, List<String> columns, List<Object> values) {
        String sql = buildInsertSql(table, columns);
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 1; i < values.size() + 1; i++) {
                preparedStatement.setObject(i, values.get(i - 1));
            }
            System.out.println(preparedStatement);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }

    private String buildInsertSql(String table, List<String> columns) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ").append(table).append("(").append(Strings.join(columns, ',')).append(") VALUES (?");
        for (int i = 0; i < columns.size() - 1; i++) {
            sb.append(",?");
        }
        sb.append(")");
        return sb.toString();
    }

    public List<Map<String, Object>> query(String table, List<String> fields, String condition) {
        String sql = buildQuerySql(table, fields, condition);
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Map<String, Object>> res = new ArrayList<>();
            while (resultSet.next()) {
                Map<String, Object> tmp = new HashMap<>();
                for (String key : fields) {
                    tmp.put(key, resultSet.getObject(key));
                }
                res.add(tmp);
            }
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private String buildQuerySql(String table, List<String> fields, String condition) {
        String sql = "SELECT " + Strings.join(fields, ',') + " FROM " + table;
        if (condition != null) {
            sql += " WHERE " + condition;
        }

        return sql;
    }

    public void close() throws SQLException {
        preparedStatement.close();
        connection.close();
    }
}
