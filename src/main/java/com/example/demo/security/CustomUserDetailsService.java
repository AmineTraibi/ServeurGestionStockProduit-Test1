package com.example.demo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.RoleDTO;
import com.example.demo.entities.UserDTO;
import com.example.demo.repository.IUserRepository;

@Service
@Primary
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDTO user=userRepository.findByUsername(username);
        
		boolean accountNonExpired = true; 
		boolean credentialsNonExpired = true; 
		boolean accountNonLocked = true;
		
		UserDetails userDetails=new org.springframework.security.core.userdetails.User(
				username, 
				user.getPassword(), 
				user.isEnable(), 
				accountNonExpired, 
				credentialsNonExpired, 
				accountNonLocked, 
				getAuthorities(user.getRoles()));
		
		return userDetails;
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(List<RoleDTO> roles) {
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		for (RoleDTO role: roles) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
			//ROLE_USER && ROLE_ADMIN
			grantedAuthorities.add(grantedAuthority);
		}
		return grantedAuthorities;
	}

}
