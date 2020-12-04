package com.bjpowernode.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages={"com.bjpowernode.master"},sqlSessionFactoryRef="masterSqlSessionFactoryBean")
public class MasterConfig {
    @Value("${master.datasource.driver-class-name}")
    private String masterDriver;
    @Value("${master.datasource.url}")
    private String masterUrl;
    @Value("${master.datasource.username}")
    private String masterUsername;
    @Value("${master.datasource.password}")
    private String masterPassword;
    @Bean
    public DruidDataSource masterDruidDataSource(){
        DruidDataSource druidDataSource=new DruidDataSource();
        druidDataSource.setDriverClassName(masterDriver);
        druidDataSource.setUrl(masterUrl);
        druidDataSource.setUsername(masterUsername);
        druidDataSource.setPassword(masterPassword);
        return druidDataSource;
    }
    @Bean
    public SqlSessionFactoryBean masterSqlSessionFactoryBean(DruidDataSource masterDruidDataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(masterDruidDataSource);
        return sqlSessionFactoryBean;
    }
}
