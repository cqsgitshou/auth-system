package com.auth.client.config.datasource;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@MapperScan(basePackages = "com.auth.client.web.dao",
            sqlSessionFactoryRef = "mainSqlSessionFactory")
public class CloudDataSourceConfiguration {


    @Autowired
    private DataSource mainDataSource;

    @Bean(name = "mainTransactionManager")
    @Primary
    public DataSourceTransactionManager mainTransactionManager() {
        return new DataSourceTransactionManager(mainDataSource);
    }

    @Bean(name = "mainSqlSessionFactory")
    @Primary
    public SqlSessionFactory mainSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(mainDataSource);

        //分页插件
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "false");
        properties.setProperty("pageSizeZero", "true");
        properties.setProperty("param", "pageNum=start;pageSize=limit");
        pageInterceptor.setProperties(properties);
        sessionFactory.setPlugins(pageInterceptor);
        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sessionFactory.getObject();
    }
}
