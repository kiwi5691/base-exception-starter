package exception.entity.base;

import lombok.Data;

//import javax.persistence.Column;
//import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

//@MappedSuperclass
@Data
public class BaseModel implements Serializable {
//    @Column(name = "create_time")
    private Date createTime = new Date();

    /**
     * 创建人id
     */
    private Long creator;

    /**
     * 最近修改时间
     */
//    @Column(name = "last_modified_time")
    private Date lastModifiedTime = new Date();

    /**
     * 最近修改人id
     */
    private Long editor;

}
