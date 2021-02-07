package com.skse.config;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.mysql.cj.jdbc.MysqlXADataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import javax.transaction.UserTransaction;

/**
 * @Author jiangyao
 * @Date 2021/2/7 9:20
 **/
@Slf4j
@Configuration
//@MapperScan(basePackages = {"com.skse.dao.account"})
public class DataSourcesConfig2 {

    @Bean(value = "testMysqlDataSources2")
    public MysqlXADataSource testMysqlDataSources2(DataSourcesProperties2 testConfig)throws Exception{
        //mysql对jta支持
        MysqlXADataSource mysqlDataSource = new MysqlXADataSource();
        mysqlDataSource.setUrl(testConfig.getUrl());
        mysqlDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlDataSource.setPassword(testConfig.getPassword());
        mysqlDataSource.setUser(testConfig.getUsername());
        mysqlDataSource.setPinGlobalTxToPhysicalConnection(true);
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>{}",mysqlDataSource.getUrl());
        return mysqlDataSource;
    }



    @Bean
    public DataSource jtaDataSource2(@Qualifier("testMysqlDataSources2") MysqlXADataSource mysqlXADataSource){
        AtomikosDataSourceBean atomikosDataSource = new AtomikosDataSourceBean();
        atomikosDataSource.setUniqueResourceName("testMysqlDataSources2");
        atomikosDataSource.setXaDataSource(mysqlXADataSource);
        return atomikosDataSource;
    }

    /**
     * mybaties对数据源的整合
     */
    @Bean(value = "mybatiesSqlSessionFactory2")
    public SqlSessionFactory mybatiesSqlSessionFactory2(@Qualifier(value = "jtaDataSource2")DataSource dataSource) throws Exception{
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setVfs(SpringBootVFS.class);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        factory.setConfiguration(configuration);
//        factory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper2/*.xml"));
        return factory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate2(@Qualifier("mybatiesSqlSessionFactory2") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }



    @Bean(value = "mapperScannerConfigurer2")
    public MapperScannerConfigurer mapperScannerConfigurer2() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        // 设置sqlSessionFactory名
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("mybatiesSqlSessionFactory2");
        // 设置接口映射器基础包名
        mapperScannerConfigurer.setBasePackage("com.skse.dao.account");
        return mapperScannerConfigurer;
    }

    @Bean(value = "testMysqlDataSources1")
    public MysqlXADataSource testMysqlDataSources1(DataSourcesProperties1 testConfig)throws Exception{
        //mysql对jta支持
        MysqlXADataSource mysqlDataSource = new MysqlXADataSource();
        mysqlDataSource.setUrl(testConfig.getUrl());
        mysqlDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlDataSource.setPassword(testConfig.getPassword());
        mysqlDataSource.setUser(testConfig.getUsername());
        mysqlDataSource.setPinGlobalTxToPhysicalConnection(true);
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>{}",mysqlDataSource.getUrl());
        return mysqlDataSource;
    }

    @Bean
    public DataSource jtaDataSource1(@Qualifier("testMysqlDataSources1") MysqlXADataSource mysqlXADataSource){
        AtomikosDataSourceBean atomikosDataSource = new AtomikosDataSourceBean();
        atomikosDataSource.setUniqueResourceName("testMysqlDataSources1");
        atomikosDataSource.setXaDataSource(mysqlXADataSource);

        return atomikosDataSource;
    }

    /**
     * mybaties对数据源的整合
     */
    @Bean(value = "mybatiesSqlSessionFactory1")
    public SqlSessionFactory mybatiesSqlSessionFactory1(@Qualifier(value = "jtaDataSource1")DataSource dataSource) throws Exception{
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setVfs(SpringBootVFS.class);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        factory.setConfiguration(configuration);
//        factory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper1/**/*.xml"));
        return factory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate1(@Qualifier("mybatiesSqlSessionFactory1") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(value = "mapperScannerConfigurer1")
    public MapperScannerConfigurer mapperScannerConfigurer1() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        // 设置sqlSessionFactory名
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("mybatiesSqlSessionFactory1");
        // 设置接口映射器基础包名
        mapperScannerConfigurer.setBasePackage("com.skse.dao.storage");
        return mapperScannerConfigurer;
    }

    @Bean(name = "transactionManager")
    @Primary
    public JtaTransactionManager regTransactionManager () {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        UserTransaction userTransaction = new UserTransactionImp();
        return new JtaTransactionManager(userTransaction, userTransactionManager);
    }
}
