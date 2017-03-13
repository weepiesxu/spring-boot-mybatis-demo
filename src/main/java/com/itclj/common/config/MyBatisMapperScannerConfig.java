package com.itclj.common.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lujun.chen on 2017/3/13.
 */
@Configuration
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {

  @Bean
  public MapperScannerConfigurer mapperScannerConfigurer() {
    MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
    //获取之前注入的beanName为sqlSessionFactory的对象
    mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
    //指定xml配置文件的路径
    mapperScannerConfigurer.setBasePackage("com.itclj.dao");
    return mapperScannerConfigurer;
  }
}
