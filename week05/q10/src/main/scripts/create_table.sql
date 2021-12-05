DROP TABLE IF EXISTS `t_trade`;
CREATE TABLE `t_trade` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `order_id` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '订单号',
  `total_fee` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '总金额',
  PRIMARY KEY (`id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='交易表';