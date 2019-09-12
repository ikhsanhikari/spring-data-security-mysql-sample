package id.hikari.security.training.hikarisecurity.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tes")
public class TestEndPoint {

    @GetMapping("")
    public ResponseEntity test(){
        return ResponseEntity.ok("OK");
    }
}
