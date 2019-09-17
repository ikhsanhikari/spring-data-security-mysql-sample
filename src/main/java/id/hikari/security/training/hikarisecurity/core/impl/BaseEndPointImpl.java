package id.hikari.security.training.hikarisecurity.core.impl;


import id.hikari.security.training.hikarisecurity.core.BaseEndPoint;
import id.hikari.security.training.hikarisecurity.data.dto.response.JsonWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class BaseEndPointImpl<T,ID> implements BaseEndPoint<T,ID> {

    @Autowired
    CrudRepository<T,ID> baseRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseEndPointImpl.class);


    @Override
    @PostMapping("")
    public ResponseEntity save(@RequestBody T t){
        t = baseRepository.save(t);
        return  ResponseEntity.ok(new JsonWrapper(0,"save", HttpStatus.OK,t));

    }

    @Override
    @GetMapping("")
    public ResponseEntity findAll() {
        List<T> findAllData = (List<T>) baseRepository.findAll();
        return ResponseEntity.ok(new JsonWrapper(findAllData.size(),"findAll", HttpStatus.OK,findAllData));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") ID id) throws RuntimeException{
        T t = baseRepository.findById(id).orElse(null);
        if(t!=null){
            return ResponseEntity.ok(new JsonWrapper(1,"findById", HttpStatus.OK,t));
        }else{
            LOGGER.error("Can't find Id {} ",id);
            throw new RuntimeException("Error parameter not found");
        }

    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") ID id){
        T t = baseRepository.findById(id).get();
        if(t==null){
            throw new RuntimeException("Error parameter not found");
        }
        baseRepository.delete(t);
        return ResponseEntity.ok(new JsonWrapper(0,"delete", HttpStatus.OK,null));
    }
}
