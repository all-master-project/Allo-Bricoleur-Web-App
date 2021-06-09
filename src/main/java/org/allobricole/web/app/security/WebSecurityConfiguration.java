package org.allobricole.web.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 
//@EnableWebSecurity
public class WebSecurityConfiguration  /*extends WebSecurityConfigurerAdapter */{
	
//	@Autowired
//	private UserDetailsService userDetailsService ;
	
//	
//	AuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider provider
//		    = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(new BCryptPasswordEncoder());
////		return provider;
//	}
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//    	http.authorizeRequests()
//    	.antMatchers("/")
//    	.permitAll()
//    	.antMatchers("/services/getservices")
//    	.permitAll()
//    	.hasAuthority("USER")
//    	.antMatchers("/admin")
//    	.hasAuthority("ADMIN")
//    	.anyRequest()
//    	.authenticated() 
//    	.and()
//    	.httpBasic()
//    	;
//    }
}
