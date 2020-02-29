package exception.auto;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import exception.config.DBProperties;
import org.apache.logging.log4j.util.Strings;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ConditionalOnClass({DruidDataSource.class})
@AutoConfigureBefore({DruidDataSourceAutoConfigure.class})
@EnableConfigurationProperties({DataSourceProperties.class, DBProperties.class})
public class AutoDataSourceConfigure {

    public AutoDataSourceConfigure(DataSourceProperties dataSourceProperties, DBProperties dbProperties) {
        if (Strings.isBlank(dataSourceProperties.getUrl())) {
            dataSourceProperties.setUrl(dbProperties.getUrl());
        }
        if (Strings.isBlank(dataSourceProperties.getDriverClassName())) {
            dataSourceProperties.setDriverClassName(dbProperties.getDriverClassName());
        }
        if (Strings.isBlank(dataSourceProperties.getUsername())) {
            dataSourceProperties.setUsername(dbProperties.getUsername());
        }
        if (Strings.isBlank(dataSourceProperties.getPassword())) {
            dataSourceProperties.setPassword(dbProperties.getPassword());
        }

    }

    @Bean(initMethod = "init")
    @ConditionalOnMissingBean
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }
}
