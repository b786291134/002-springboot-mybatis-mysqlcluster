package com.bjpowernode.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages={"com.bjpowernode.slave"},sqlSessionFactoryRef="slaveSqlSessionFactoryBean")
public class SlaveConfig {
    @Value("${slave.datasource.driver-class-name}")
    private String slaveDriver;
    @Value("${slave.datasource.url}")
    private String slaveUrl;
    @Value("${slave.datasource.username}")
    private String slaveUsername;
    @Value("${slave.datasource.password}")
    private String slavePassword;
    @Bean
    public DruidDataSource slaveDruidDataSource(){
        DruidDataSource druidDataSource=new DruidDataSource();
        druidDataSource.setDriverClassName(slaveDriver);
        druidDataSource.setUrl(slaveUrl);
        druidDataSource.setUsername(slaveUsername);
        druidDataSource.setPassword(slavePassword);
        return druidDataSource;
    }
    @Bean
    public SqlSessionFactoryBean slaveSqlSessionFactoryBean(DruidDataSource slaveDruidDataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(slaveDruidDataSource);
        return sqlSessionFactoryBean;
    }
}
