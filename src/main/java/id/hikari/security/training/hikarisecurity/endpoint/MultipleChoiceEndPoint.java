package id.hikari.security.training.hikarisecurity.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("multiple-choices")
public interface MultipleChoiceEndPoint {
    @GetMapping("")
    ResponseEntity selectAll();
}
