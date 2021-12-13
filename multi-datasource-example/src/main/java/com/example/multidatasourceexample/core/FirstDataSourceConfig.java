package com.example.multidatasourceexample.core;

import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class FirstDataSourceConfig {

    private final CommonConfig commonConfig;

    @Bean(name = "firstDataSource")
    @ConfigurationProperties(prefix = "spring.first.datasource")
    public DataSource firstDataSource() {
        HikariDataSource firstDataSource = new HikariDataSource();

        // 공통설정 적용
        firstDataSource.setMaxLifetime(commonConfig.commonHikariConfig().getMaxLifetime());
        firstDataSource.setMaximumPoolSize(commonConfig.commonHikariConfig().getMaximumPoolSize());
        return firstDataSource;
    }

    @Bean(name = "firstJdbcTemplate")
    public JdbcTemplate firstJdbcTemplate(@Qualifier("firstDataSource") DataSource firstDataSource) {
        return new JdbcTemplate(firstDataSource);
    }

    /**
     * H2 DB 초기화 스크립트 실행을 위한
     * DataSourceInitializer 정의
     * @param datasource
     * @return dataSourceInitializer
     */
    @Bean
    public DataSourceInitializer firstDataSourceInitializer(@Qualifier("firstDataSource") DataSource datasource) {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.addScript(new ClassPathResource("first-schema.sql"));

        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(datasource);
        dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
        return dataSourceInitializer;
    }
}
