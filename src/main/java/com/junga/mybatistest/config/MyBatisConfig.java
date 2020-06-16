package com.junga.mybatistest.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.junga.mybatistest.dao")
public class MyBatisConfig {

    @Autowired
    private ResourceLoader resourceLoader;

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(dataSource);
        // dto 위치 설정
        sqlSessionFactoryBean.setTypeAliasesPackage("com.junga.mybatistest.dto");
        // mapper.xml 파일 위치 설정
        sqlSessionFactoryBean.setMapperLocations(ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
                .getResources("classpath:mappers/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate (SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
