package id.hikari.security.training.hikarisecurity.endpoint;

import id.hikari.security.training.hikarisecurity.data.dto.request.RequestShortAnswerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("short-answers")
public interface ShortAnswerEndPoint {
    @PostMapping("")
    ResponseEntity save(@RequestBody RequestShortAnswerDTO request);

    @PatchMapping("/{id}")
    ResponseEntity update(@RequestBody RequestShortAnswerDTO request,@PathVariable("id") Integer id);

    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable("id") Integer id);

    @GetMapping("")
    ResponseEntity findAll();

    @GetMapping("/rand")
    ResponseEntity findByRand(@RequestParam("limit") Integer limit);

    @GetMapping("/{id}")
    ResponseEntity findById(@PathVariable("id") Integer id);
}
