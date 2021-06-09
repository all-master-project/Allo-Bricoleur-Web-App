package org.allobricole.web.app.service;

import java.util.List;
import org.allobricole.web.app.dao.ClientRepository;
import org.allobricole.web.app.io.entity.ClientEntity;
import org.allobricole.web.app.io.entity.MissionEntity;
import org.allobricole.web.app.io.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientService{
	
	@Autowired 
	ClientRepository clientRepository;
	
	@Autowired
	UserService userService;

	public ClientEntity findById(long id) {
		return clientRepository.findById(id).get();
	}

	public ClientEntity save(ClientEntity entity) {
		//add Login Concept
				String userName = entity.getEmailcl();
				String hasRole = "USER";
				String password = "USER";
				UserEntity user = new UserEntity(userName, password, hasRole);
				userService.addUser(user);
		return clientRepository.save(entity);
	}
	
	public void deleteById(long id) {
		clientRepository.deleteById(id);
	}
	
	public void delete(ClientEntity entity) {
		clientRepository.delete(entity);
	}
	
	public void deleteAll() {
		clientRepository.deleteAll();
	}
	
	public List<ClientEntity> findAll() {
		return clientRepository.findAll();
	}
	
	public ClientEntity updateClient(ClientEntity client) {
		ClientEntity old = clientRepository.findById(client.getIdcl()).get();
		BeanUtils.copyProperties(client, old);
		clientRepository.save(old);
		return old;
		
	}

	public List<MissionEntity> getMissionsClient(Long ids) 
	{
		 List<MissionEntity> missions = clientRepository.findById(ids).get().getMissions();
		 
		 return missions;
	}

}
