package id.hikari.security.training.hikarisecurity.dao;

import id.hikari.security.training.hikarisecurity.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
