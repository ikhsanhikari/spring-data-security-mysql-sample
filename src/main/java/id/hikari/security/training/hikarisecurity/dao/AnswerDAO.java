package id.hikari.security.training.hikarisecurity.dao;

import id.hikari.security.training.hikarisecurity.data.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerDAO extends JpaRepository<Answer,Integer> {
    @Query("SELECT a FROM Answer a WHERE a.idQuestion = ?1 ")
    List<Answer> findAnswerByQuestion(Integer questionId);

    @Query("SELECT a FROM Answer a WHERE a.idQuestion = ?1 ")
    List<Answer> findAnswerByQuestionString(String questionId);
}
