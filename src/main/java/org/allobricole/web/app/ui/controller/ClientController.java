package org.allobricole.web.app.ui.controller;

import java.util.List;

import org.allobricole.web.app.io.entity.ClientEntity;
import org.allobricole.web.app.io.entity.MissionEntity;
import org.allobricole.web.app.service.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 

@ComponentScan
@RestController()
@CrossOrigin//(origins = "http://localhost:3001")
@RequestMapping("/clients")
public class ClientController {
     
	@Autowired
	private ClientService clientService;
	
	
	@GetMapping("/getclients")
	public List<ClientEntity> clients(){
		return clientService.findAll();
	}
	
	@GetMapping(path="/getclientById/{id}")
	public ClientEntity clients(@PathVariable Long ids){
		return clientService.findById(ids);
	}
	
	@GetMapping(path="/getmissionsclient/{id}")
	public List<MissionEntity> missionsclient(@PathVariable Long ids){
		return clientService.getMissionsClient(ids);
	}
	
	@PostMapping("/save")
	public ClientEntity ajouterClient(@RequestBody ClientEntity client){
		return clientService.save(client);
	}
	
	@PutMapping("/update")
	public ClientEntity modifierClients(@RequestBody ClientEntity client){
		
		ClientEntity oldClient = clientService.findById(client.getIdcl());
		BeanUtils.copyProperties(client, oldClient);
		return oldClient;
		}
	
}
