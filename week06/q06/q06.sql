DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `uid` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户id',
  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '用户手机号',
  `user_name` varchar(64) NOT NULL DEFAULT '' COMMENT '用户名称',
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '用户状态，0正常，1已删除',
  `create_time` timestamp NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '记录创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间'
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `gid` bigint(20) NOT NULL DEFAULT '0' COMMENT '商品id',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '商品名称',
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '商品状态，0正常，1已下架',
  `stock` int(11) NOT NULL DEFAULT 0 COMMENT '库存数量',
  `create_time` timestamp NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '记录创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间'
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_gid` (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品表';

DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `oid` bigint(20) NOT NULL DEFAULT '0' COMMENT '订单id',
  `uid` bigint(20) NOT NULL DEFAULT '' COMMENT '用户id',
  `goods_list` varchar(2048) NOT NULL DEFAULT '' COMMENT '购买的商品列表，json字符串，包含商品id和数量两个字段',
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '订单状态，0初始，1已下单未支付，2已支付',
  `create_time` timestamp NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '记录创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间'
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_oid` (`oid`),
  KEY `idx_uid` (`uid`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单表';
