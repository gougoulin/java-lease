package com.github.gougoulin.lease.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.github.gougoulin.lease.web.*.mapper")
public class MybatisPlusConfig {
}
