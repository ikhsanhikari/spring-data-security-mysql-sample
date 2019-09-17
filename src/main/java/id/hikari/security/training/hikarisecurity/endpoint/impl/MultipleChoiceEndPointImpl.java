package id.hikari.security.training.hikarisecurity.endpoint.impl;

import id.hikari.security.training.hikarisecurity.endpoint.MultipleChoiceEndPoint;
import id.hikari.security.training.hikarisecurity.service.MultipleChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MultipleChoiceEndPointImpl implements MultipleChoiceEndPoint {

    @Autowired
    private MultipleChoiceService multipleChoiceService;

    @Override
    public ResponseEntity selectAll() {
        return multipleChoiceService.selectAll();
    }
}
