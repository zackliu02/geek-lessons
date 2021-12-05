package com.zackliu.jdbc.database.hikari.dao;

import lombok.Data;

@Data
public class TradeDO {
    private int id;
    private String orderId;
    private int totalFee;
}
