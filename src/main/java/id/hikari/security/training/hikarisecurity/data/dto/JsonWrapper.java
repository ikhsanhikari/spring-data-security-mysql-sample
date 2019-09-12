package id.hikari.security.training.hikarisecurity.data.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JsonWrapper {

    private int itemsSize;
    private String ActionType;
    private HttpStatus httpStatus;
    private Object data;


}
