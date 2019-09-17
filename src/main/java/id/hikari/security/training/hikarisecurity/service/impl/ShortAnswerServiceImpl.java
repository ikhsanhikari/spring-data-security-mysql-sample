package id.hikari.security.training.hikarisecurity.service.impl;

import id.hikari.security.training.hikarisecurity.dao.ShortAnswerDAO;
import id.hikari.security.training.hikarisecurity.data.dto.request.RequestShortAnswerDTO;
import id.hikari.security.training.hikarisecurity.data.dto.response.JsonWrapper;
import id.hikari.security.training.hikarisecurity.data.model.ShortAnswer;
import id.hikari.security.training.hikarisecurity.mapper.ShortAnswerMapper;
import id.hikari.security.training.hikarisecurity.service.ShortAnswerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShortAnswerServiceImpl implements ShortAnswerService {

    @Autowired
    private ShortAnswerDAO shortAnswerDAO;

    @Autowired
    private ShortAnswerMapper shortAnswerMapper;

    public  static final Logger LOGGER = LoggerFactory.getLogger(ShortAnswerServiceImpl.class);


    @Override
    public ResponseEntity save(RequestShortAnswerDTO request) {
        ShortAnswer shortAnswer = shortAnswerMapper.convert(request);
        shortAnswerDAO.save(shortAnswer);
        return ResponseEntity.ok(new JsonWrapper(0,"Save" ,HttpStatus.OK,null));
    }

    @Override
    public ResponseEntity update(RequestShortAnswerDTO request,Integer id) {
        ShortAnswer shortAnswer = shortAnswerMapper.convert(request);
        shortAnswer.setId(id);
        shortAnswerDAO.save(shortAnswer);
        return ResponseEntity.ok(new JsonWrapper(0,"Save" ,HttpStatus.OK,null));
    }


    @Override
    public ResponseEntity findAll() {
        List<ShortAnswer> shortAnswers = new ArrayList<>();
        shortAnswers = shortAnswerDAO.findAll();
        return ResponseEntity.ok(new JsonWrapper(shortAnswers.size(),"find All",HttpStatus.OK,shortAnswers));
    }

    @Override
    public ResponseEntity findByRand(Integer limit) {
        PageRequest pageRequest = new PageRequest(0,limit);
        List<ShortAnswer> shortAnswers = shortAnswerDAO.findByRand(pageRequest);
        return ResponseEntity.ok(new JsonWrapper(shortAnswers.size(),"find All",HttpStatus.OK,shortAnswers));
    }

    @Override
    public ResponseEntity findById(Integer id) {
        ShortAnswer shortAnswer = shortAnswerDAO.findById(id).orElse(null);
        if(shortAnswer == null){
            LOGGER.error("Not Found");
            throw new RuntimeException("Not Found");
        }
        return ResponseEntity.ok(new JsonWrapper(1,"find By Id",HttpStatus.OK,shortAnswer));
    }

    @Override
    public ResponseEntity delete(Integer id) {
        ShortAnswer shortAnswer = new ShortAnswer();
        shortAnswer.setId(id);
        shortAnswerDAO.delete(shortAnswer);
        return ResponseEntity.ok(new JsonWrapper(0,"delete", HttpStatus.OK,null));
    }
}
