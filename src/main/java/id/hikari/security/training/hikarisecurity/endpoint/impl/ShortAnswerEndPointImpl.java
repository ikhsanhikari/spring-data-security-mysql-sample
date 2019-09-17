package id.hikari.security.training.hikarisecurity.endpoint.impl;


import id.hikari.security.training.hikarisecurity.dao.ResultShortAnswerDAO;
import id.hikari.security.training.hikarisecurity.data.dto.request.RequestShortAnswerDTO;
import id.hikari.security.training.hikarisecurity.data.dto.response.JsonWrapper;
import id.hikari.security.training.hikarisecurity.data.model.ResultShortAnswer;
import id.hikari.security.training.hikarisecurity.endpoint.ShortAnswerEndPoint;
import id.hikari.security.training.hikarisecurity.service.ShortAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShortAnswerEndPointImpl implements ShortAnswerEndPoint {


    @Autowired
    private ResultShortAnswerDAO resultShortAnswerDAO;

    @Autowired
    private ShortAnswerService shortAnswerService;

    @Override
    public ResponseEntity save(@RequestBody  RequestShortAnswerDTO request) {
        return shortAnswerService.save(request);
    }

    @Override
    public ResponseEntity update(@RequestBody RequestShortAnswerDTO request,@PathVariable("id") Integer id) {
        return shortAnswerService.update(request,id);
    }

    @Override
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        return shortAnswerService.delete(id);
    }

    @Override
    public ResponseEntity findAll() {
        return shortAnswerService.findAll();
    }

    @Override
    public ResponseEntity findByRand(@RequestParam("limit") Integer limit) {
        return shortAnswerService.findByRand(limit);
    }

    @Override
    public ResponseEntity findById(@PathVariable("id") Integer id) {
        return shortAnswerService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity saveShortAnswer(@RequestBody List<ResultShortAnswer> resultShortAnswers){
        resultShortAnswerDAO.saveAll(resultShortAnswers);
        return ResponseEntity.ok(new JsonWrapper(0,"save", HttpStatus.OK,resultShortAnswers));
    }
}
