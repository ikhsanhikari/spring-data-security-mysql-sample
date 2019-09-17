package id.hikari.security.training.hikarisecurity.dao;

import id.hikari.security.training.hikarisecurity.data.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class DBInit implements CommandLineRunner {

    private UserDao userDao;
    private PasswordEncoder passwordEncoder;

    public DBInit(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }



    @Override
    public void run(String... args) throws Exception {

//        this.userDao.deleteAll();

        User dan = new User("dan",passwordEncoder.encode("dan123"),"USER","");
        User admin = new User("admin",passwordEncoder.encode("admin123"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("manager",passwordEncoder.encode("manager123"),"MANAGER","ACCESS_TEST1");

        List<User> users = Arrays.asList(dan,admin,manager);

//        this.userDao.saveAll(users);
    }
}
