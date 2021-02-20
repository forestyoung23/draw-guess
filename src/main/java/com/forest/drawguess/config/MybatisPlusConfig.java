package com.forest.drawguess.config;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author dongyang
 * @date 2021年02月07日 15:10
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        GlobalConfig config = new GlobalConfig();
        // 不打印mybatis-plus banner
        config.setBanner(false);
        factoryBean.setGlobalConfig(config);
        return factoryBean.getObject();
    }
}
