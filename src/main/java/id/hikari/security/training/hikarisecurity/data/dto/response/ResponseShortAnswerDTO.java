package id.hikari.security.training.hikarisecurity.data.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Setter
@Getter
@ToString
public class ResponseShortAnswerDTO {

    private Integer id;
    private String question;
    private String shortAnswer;
    private Integer questionLevel;
    private Date createdAt;
    private  Date updatedAt;
    private String createdBy;
    private String updatedBy;
    private Integer status;
}
