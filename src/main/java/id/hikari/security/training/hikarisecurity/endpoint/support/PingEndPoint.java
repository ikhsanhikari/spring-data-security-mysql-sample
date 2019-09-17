package id.hikari.security.training.hikarisecurity.endpoint.support;

import id.hikari.security.training.hikarisecurity.data.dto.response.JsonWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ping")
@RestController
public class PingEndPoint {

    @GetMapping("")
    public ResponseEntity ping(){
        return ResponseEntity.ok(new JsonWrapper(1,"", HttpStatus.OK,"pong"));
    }
}
