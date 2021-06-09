package org.allobricole.web.app.security.user.dts;

import org.allobricole.web.app.dao.UserRepository;
import org.allobricole.web.app.io.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomeUserDetailsService /* implementsUserDetailsService */{

//	@Autowired
//	private UserRepository userRepository ; 
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		UserEntity user = userRepository.findByUsername(username);
//		if(user==null) throw new UsernameNotFoundException("UsernameNotFoundException");
//		return new CutomUserDetails(user);
//
//	}
	
}
