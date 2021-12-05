package com.zackliu.jdbc.database.hikari;

import com.zackliu.jdbc.database.hikari.dao.TradeDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyHikariRunner implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        String sql = "SELECT * FROM t_trade";
        List<TradeDO> items = jdbcTemplate.query(sql, new BeanPropertyRowMapper(TradeDO.class));
        items.forEach(System.out::println);
    }
}
