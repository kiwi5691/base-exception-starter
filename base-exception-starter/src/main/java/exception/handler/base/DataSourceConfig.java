package exception.handler.base;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;


@Component
public class DataSourceConfig {

    private String systemCode;
    private int unknownStatus;
    private String queryDefineSql;
    private DataSource dataSource;



    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }


    public int getUnknownStatus() {
        return unknownStatus;
    }

    public void setUnknownStatus(int unknownStatus) {
        this.unknownStatus = unknownStatus;
    }

    public String getQueryDefineSql() {
        return queryDefineSql;
    }

    public void setQueryDefineSql(String queryDefineSql) {
        this.queryDefineSql = queryDefineSql;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
