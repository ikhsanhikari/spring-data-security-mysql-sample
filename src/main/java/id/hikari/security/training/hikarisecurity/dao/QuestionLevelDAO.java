package id.hikari.security.training.hikarisecurity.dao;


import id.hikari.security.training.hikarisecurity.dto.ResponseLovDTO;
import id.hikari.security.training.hikarisecurity.model.QuestionLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionLevelDAO extends JpaRepository<QuestionLevel,Integer> {

    @Query("select new id.hikari.security.training.hikarisecurity.dto.ResponseLovDTO(id,questionLevel) from QuestionLevel")
    List<ResponseLovDTO> lovQuestionLevel();
}
