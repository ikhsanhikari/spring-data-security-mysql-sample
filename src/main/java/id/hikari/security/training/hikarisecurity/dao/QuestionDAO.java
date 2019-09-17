package id.hikari.security.training.hikarisecurity.dao;


import id.hikari.security.training.hikarisecurity.data.dto.response.ResponseLovDTO;
import id.hikari.security.training.hikarisecurity.data.model.Question;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionDAO extends JpaRepository<Question,Integer> {
    @Query("select new id.hikari.security.training.hikarisecurity.data.dto.response.ResponseLovDTO(id,question) from Question")
    List<ResponseLovDTO> lovQuestion();


    @Query("select q from Question q order by rand()")
    List<Question> findByRand(Pageable pageable);
}
