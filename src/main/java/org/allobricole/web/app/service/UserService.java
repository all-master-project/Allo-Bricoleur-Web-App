package org.allobricole.web.app.service;

import java.util.List;
import org.allobricole.web.app.dao.RegionRepository;
import org.allobricole.web.app.dao.UserRepository;
import org.allobricole.web.app.io.entity.UserEntity;
import org.codehaus.groovy.ast.tools.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class UserService{

	@Autowired
	UserRepository userRepository;
	
	public UserService() {
		
	}
	
	
	
	public void deleteByIdr(Long idu){
		userRepository.deleteById(idu);	
	}
	
	public UserEntity addUser(UserEntity user) throws NullPointerException{
		return userRepository.save(user);
	};
	
	public List<UserEntity> regions(){
		return userRepository.findAll();
		}

	public UserEntity getUserByIdu(Long idu){
		return  userRepository.findById(idu).get();
		}
	
	public UserEntity findByUsername(String userName, String password, String role){
		List<UserEntity> users= userRepository.findAll();
		UserEntity userEntity = new UserEntity();
		for(UserEntity user : users) {
			if(user.getUsername().equals(userName) && user.getPassword().equals(password)) {
				userEntity = user;
			}
		}
		System.out.println(userEntity);
		return  userEntity;
		}
	
} 
