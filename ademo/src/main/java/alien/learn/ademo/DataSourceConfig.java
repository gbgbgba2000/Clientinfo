package alien.learn.ademo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {
    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    /*
     * @Value("${spring.datasource.username}")
     * private String user;
     */

    /*
     * @Value("${spring.datasource.password}")
     * private String password;
     */

    /*
     * @Value("${cloudSQL.socketFactory}")
     * private String socketFactory;
     */

    /*
     * @Value("${cloudSQL.cloudSqlInstance}")
     * private String cloudSqlInstance;
     */

    /*
     * @Value("${cloudSQL.unixSocketPath}")
     * private String unixSocketPath;
     */

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dataSourceUrl);
        // config.setUsername(user);
        // config.setPassword(password);
        // config.setJdbcUrl("jdbc:postgresql:///CLOUD_DB");
        config.setUsername("postgres");
        config.setPassword("kokoko688");
        // config.addDataSourceProperty("socketFactory",
        // "com.google.cloud.sql.postgres.SocketFactory");
        // config.addDataSourceProperty("cloudSqlInstance",
        // "pro-tuner-422708-v5:asia-east1:gbgbgba2000");
        // config.addDataSourceProperty("unixSocketPath",
        // "pro-tuner-422708-v5:asia-east1:gbgbgba2000/.s.PGSQL.5432");

        HikariDataSource ds = new HikariDataSource(config);
        return ds;
    }

}
