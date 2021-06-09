package org.allobricole.web.app.ui.controller;

import org.allobricole.web.app.io.entity.LoginRequest;
import org.allobricole.web.app.io.entity.UserEntity;
import org.allobricole.web.app.security.user.dts.CustomeUserDetailsService;
import org.allobricole.web.app.security.user.dts.CutomUserDetails;
import org.allobricole.web.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logings")
@CrossOrigin()
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/getLogin")
	public UserEntity login(@RequestBody UserEntity user) {
		String email = user.getUsername();
		String password = user.getPassword();
		String role = user.getRole();
		return userService.findByUsername(email, password, role);
	}
	
//	@GetMapping("/infol")
//	public UserDetails login(@RequestBody CutomUserDetails user) {
//		return userService.loadUserByUsername(user.getUsername()); 
//	}
//	
//	@GetMapping("/login")
//	public UserDetails login(@RequestBody CutomUserDetails user) {
//		return userService.loadUserByUsername(user.getUsername());
//	}
//	
//	@GetMapping("/login")
//	public UserDetails login(@RequestBody CutomUserDetails user) {
//		return userService.loadUserByUsername(user.getUsername());
//	}
}
 