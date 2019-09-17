package id.hikari.security.training.hikarisecurity.jwt;


import id.hikari.security.training.hikarisecurity.data.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JwtUserDetails implements UserDetails {

	private User user ;

	public JwtUserDetails(User user) {
		this.user = user;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

		//Extract the permissions
		this.user.getPermissionList().forEach(p->{
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(p);
			grantedAuthorities.add(grantedAuthority);
		});


		//Extract the role
		this.user.getRoleList().forEach(r->{
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+r);
			grantedAuthorities.add(grantedAuthority);
		});

		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.user.getActive() == 1;
	}


}
