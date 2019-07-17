package com.zysl.cloud.pms.dal.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@MapperScan(value = "tk.mybatis.mapper.annotation"
        , properties = {"mappers=tk.mybatis.mapper.common.Mapper", "notEmpty=true","identity=MYSQL"}
        , basePackages = DemoDataSourceConfig.PACKAGE
        , sqlSessionFactoryRef = DemoDataSourceConfig.SESSION_FACTORY)
@EnableTransactionManagement
public class DemoDataSourceConfig {

    static final String PACKAGE = "com.zysl.cloud.pms.dal.dao.pms.mysql";
    private static final String MAPPER_LOCATION = "classpath:mapping/pms/mysql/slave/*.xml";

    private static final String DATA_SOURCE = "demoDataSource";
//    static final String PACKAGE = "com.zysl.demo.dal.dao.demodb";
    static final String SESSION_FACTORY = "demoMySQLSessionFactory";

 /*   @Value("127.0.0.1:3306/test")
    private String url;
    @Value("")
    private String user;
    @Value("")
    private String password;
    @Value("com.mysql.cj.jdbc.Driver")
    private String driverlass;*/


    @Bean(name=DemoDataSourceConfig.DATA_SOURCE)
    public DataSource demoDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver ");
        //dataSource.setUrl("127.0.0.1:3306/test");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("123");
        //dataSource.setDbType("mysql");
        try {
            dataSource.setFilters("stat,wall");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean(name = "dataSourceTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }


    @Bean(name = DemoDataSourceConfig.SESSION_FACTORY)
    public SqlSessionFactory sqlSessionFactory(
            @Qualifier(DemoDataSourceConfig.DATA_SOURCE) DataSource myDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        //设置数据库连接信息
        factoryBean.setDataSource(myDataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().
                getResources(DemoDataSourceConfig.MAPPER_LOCATION));

        Properties properties = new Properties();
        properties.setProperty("helperDialect", "MYSQL");
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("params", "count=countSql");
        properties.setProperty("autoRuntimeDialect", "true");

        PageInterceptor pageInterceptor = new PageInterceptor();
        pageInterceptor.setProperties(properties);

        factoryBean.setPlugins(new Interceptor[] {pageInterceptor});
        return factoryBean.getObject();
    }

}
