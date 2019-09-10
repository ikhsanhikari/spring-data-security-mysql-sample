package id.hikari.security.training.hikarisecurity.security;

import id.hikari.security.training.hikarisecurity.dao.UserDao;
import id.hikari.security.training.hikarisecurity.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private UserDao userDao;

    public UserPrincipalDetailsService(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user =  userDao.findByUsername(s);
        if(user==null){
            throw  new UsernameNotFoundException("user 404");
        }
        UserPrincipal userPrincipal =  new UserPrincipal(user);
        return userPrincipal;
    }
}
