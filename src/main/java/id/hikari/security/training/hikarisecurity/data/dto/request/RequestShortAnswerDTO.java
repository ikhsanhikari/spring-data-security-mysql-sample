package id.hikari.security.training.hikarisecurity.data.dto.request;


import lombok.*;

import java.io.Serializable;

@ToString
@Setter
@Getter
public class RequestShortAnswerDTO implements Serializable {

    private String question;
    private String shortAnswer;
    private Integer questionLevel;

}
