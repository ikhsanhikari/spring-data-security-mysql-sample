package id.hikari.security.training.hikarisecurity.dao;

import id.hikari.security.training.hikarisecurity.data.model.ShortAnswer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShortAnswerDAO extends JpaRepository<ShortAnswer,Integer> {
    @Query("select q from ShortAnswer q order by rand()")
    List<ShortAnswer> findByRand(Pageable pageable);
}
