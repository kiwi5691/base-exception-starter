package exception.config;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;


/**
 * <pre>
 * 描述：异常配置
 * </pre>
 *
 */
@Component
public class ExceptionConfig {

    private String systemCode;
    private int unknownStatus;
    private String queryDefineSql;
    private DataSource dataSource;
    private final static String DEFAULT_SYSTEM_CODE = "99";


    public String getDefaultSystemCode(){
        return  DEFAULT_SYSTEM_CODE ;
    }

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
