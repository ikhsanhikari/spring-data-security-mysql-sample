package id.hikari.security.training.hikarisecurity.service;

import id.hikari.security.training.hikarisecurity.data.dto.request.RequestShortAnswerDTO;
import org.springframework.http.ResponseEntity;

public interface ShortAnswerService {

    ResponseEntity save(RequestShortAnswerDTO request);
    ResponseEntity update(RequestShortAnswerDTO request, Integer id);
    ResponseEntity findAll();
    ResponseEntity findByRand(Integer limit);
    ResponseEntity findById(Integer id);
    ResponseEntity delete(Integer id);

}
