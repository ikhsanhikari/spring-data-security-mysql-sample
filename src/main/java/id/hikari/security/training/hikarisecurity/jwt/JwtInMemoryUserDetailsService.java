package id.hikari.security.training.hikarisecurity.jwt;

import id.hikari.security.training.hikarisecurity.dao.UserDao;
import id.hikari.security.training.hikarisecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

//	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

	@Autowired
	private UserDao userDao;

//	static {
//		inMemoryUserList.add(new JwtUserDetails(1L, "in28minutes",
//				"$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
//		inMemoryUserList.add(new JwtUserDetails(2L, "ranga",
//				"$2a$10$IetbreuU5KihCkDB6/r1DOJO0VyU9lSiBcrMDT.biU7FOt2oqZDPm", "ROLE_USER_2"));
//
//		//$2a$10$IetbreuU5KihCkDB6/r1DOJO0VyU9lSiBcrMDT.biU7FOt2oqZDPm
//	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
//				.filter(user -> user.getUsername().equals(username)).findFirst();
//
//		if (!findFirst.isPresent()) {
//			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
//		}
//
//		return findFirst.get();

		User user =  userDao.findByUsername(username);
		if(user==null){
			throw  new UsernameNotFoundException("user 404");
		}
		JwtUserDetails userPrincipal =  new JwtUserDetails(user);
		return userPrincipal;
	}

}
