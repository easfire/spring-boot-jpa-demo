CREATE TABLE `subject_label` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(64) NOT NULL COMMENT '主体标签',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '' COMMENT '用户ID',
  `industry_id` bigint(20) DEFAULT '0' COMMENT '行业ID',
  `weight` float DEFAULT '0' COMMENT 'CPM权重',
  `frequent_used` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '常用主体标签(0非常用,1常用)',
  `abroad_type` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '海外投放限制(0=不允许,1=必须允许,2=可以允许)',
  `deleted_at` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `product_score` decimal(4,1) DEFAULT NULL COMMENT '标签对应产品分',
  `highest_ad_level` varchar(64) DEFAULT '0' COMMENT '最高分类级别012',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='主体标签列表';

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `address_at` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
