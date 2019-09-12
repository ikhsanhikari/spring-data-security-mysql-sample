package id.hikari.security.training.hikarisecurity.dao;

import id.hikari.security.training.hikarisecurity.dto.ResponseMultipleResult;
import id.hikari.security.training.hikarisecurity.dto.ResponseMultipleResultAll;
import id.hikari.security.training.hikarisecurity.dto.ResponseResultShortAnswer;
import id.hikari.security.training.hikarisecurity.dto.ResponseSummaryStandardResult;
import id.hikari.security.training.hikarisecurity.model.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionAnswerDAO extends JpaRepository<QuestionAnswer,Integer> {

    @Query(nativeQuery = true)
    List<ResponseMultipleResult> getResultMultiple(String packageUnique);

    @Query(nativeQuery = true)
    List<ResponseResultShortAnswer> getResultShortAnswer(String packageUnique);

    @Query(nativeQuery =true)
    List<ResponseMultipleResultAll> getResultMultipleAll(String packageUnique);

    @Query(nativeQuery = true)
    List<ResponseSummaryStandardResult> getSummaryStandardResult();
}

