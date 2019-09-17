package id.hikari.security.training.hikarisecurity.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.util.Date;


@Setter
@Getter
@MappedSuperclass
public class BaseModel {
    private Date createdAt;
    private  Date updatedAt;
    private String createdBy;
    private String updatedBy;
    private Integer status;
}
