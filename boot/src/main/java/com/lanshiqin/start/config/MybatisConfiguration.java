package com.lanshiqin.start.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Mybatis配置
 * @author 蓝士钦
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.lanshiqin.start.mapper")
public class MybatisConfiguration {
}
