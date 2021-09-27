package za.ac.nwu.ac.repo.config;


import lombok.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.Entity;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("za.ac.nwu.ac.repo.persistence")
@EntityScan("za.ac.nwu.ac.domain.persistence")
@PropertySource(value = "classpath:application-db.properties")

public class RepositoryConfig {

    /*private static final  String[] ENTITY_PACKAGES_TO_SCAN = {"za.ac.nwu.ac.domain.persistence"};
    private static final  String PERSISTENCE_UNIT_NAME = "account.system.persistence";

    @Value("${spring.datasource.url}")
    private String datasourceurl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    punlic LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(datasource());
        entityManagerFactoryBean.setPackagesToScan(ENTITY_PACKAGES_TO_SCAN);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaProperties(buildJpaProperties());
        entityManagerFactoryBean.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);

        return entityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(datasource());
    }

    @Bean
    public DataSource dataSource(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.oracle");

        try {
            OracleDataSource dataSource = new OracleDataSource();
            dataSource.setUser(username);
            dataSource.setPassword(password);
            dataSource.setURL(datasourceurl);
            dataSource.setImlicitCachingEnabled(true);
            dataSource.setFastConnectionFailoverEnabled(true);
            return dataSource;
        }catch (SQLException e){
            throw new RuntimeException("Unable to connect to the Database", e);
        }
    }

    private Properties buildJpaProperties(){
        Properties properties = new Properties();
        properties.setProperty("java.persistence.transactionType", "jta");
        properties.setProperty("hibernate.Integercode.use_reflection_optimizer", "true");
        properties.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JTATransactionFactory");
        properties.setProperty("hibernate.query.factory_class", "org.hibernate.hql.internal.classic.ClassicQueryTransaction");
        properties.setProperty("hibernate.transaction.jta.platforms", "org.hibernate.service.jta.platform.internal.SunOneJtaPlatform");
        properties.setProperty("hibernate.dialect", "org.hibernate.OracleOgDialect");
        properties.setProperty("hibernate.generate_statistics", "false");
        properties.setProperty("hibernate.use_sql_comments", "false");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.jdbc.batch_size", "500");
        properties.setProperty("hibernate.order_inserts", "true");
        properties.setProperty("hibernate.order_updates", "true");
        properties.setProperty("hibernate.batch_versioned_data", "true");

        return properties;
    }*/

}
